package com.hnevc.choosefood;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Food> foodlist = new ArrayList<>();
    EditText mEtUserName;
    RadioGroup mRgGender;
    CheckBox mCbFish,mCbHot,mCbSour;
    SeekBar mSbBudget;//预算
    Button mBtnFind;//查找按钮
    Button mBtnFirst;//第一个
    Button mBtnPre;//前一个
    Button mBtnNext;//后一个
    Button mBtnLast;//最后一个
    Button mBtnSelect;//选中
    ImageView mIvPic;


    String userName,gender;
    Boolean isNeedSour,isNeedFish,isNeedHot;
    Float budget=0.0f;
    List<Food> selectedFoodList = new ArrayList<>();
    int index=0;//要显示的满足条件的菜品的序号
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        initEvent();
    }

    private void initEvent() {
        mRgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if(checkedId==R.id.id_rb_male)
                    gender = "男";
                else
                    gender ="女";
            }
        });
        mBtnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedFoodList.clear();
                isNeedSour = mCbSour.isChecked();
                isNeedHot = mCbHot.isChecked();
                isNeedFish = mCbFish.isChecked();

                //编列foodlist，将符合条件的菜品加入selectedFoodList中
                for (int i = 0; i < foodlist.size(); i++) {
                    Food food = foodlist.get(i);
                    if( isNeedSour==food.isSour()
                            && isNeedFish == food.isFish()
                            && isNeedHot == food.isHot()
                            && budget >=food.getFoodPrice() //不能超出预算
                            ){

                        selectedFoodList.add(foodlist.get(i));
                    }
                }
                //如果没找到则显示空盘子图片
                if(selectedFoodList.size()==0){
                    mIvPic.setImageResource(R.drawable.kongpan);
                }else {
                    //否则，显示当前index的图片，初始值为0
                    mIvPic.setImageDrawable(selectedFoodList.get(index).getPics());
                }
                Toast.makeText(MainActivity.this, "共有"+selectedFoodList.size()+"选中", Toast.LENGTH_SHORT).show();
            }
        });
        mSbBudget.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    budget =(float) progress;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //TODO 设计实现上一个、第一个、最后一个菜品的显示功能
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index==selectedFoodList.size()-1)
                    return;
                else{
                    index++;
                    mIvPic.setImageDrawable(selectedFoodList.get(index).getPics());
                }
            }
        });
        mBtnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, selectedFoodList.get(index).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView(){
        mEtUserName = (EditText) findViewById(R.id.id_et_username);
        mRgGender = (RadioGroup)findViewById(R.id.id_rg_sex);
        mSbBudget = (SeekBar) findViewById(R.id.id_sk_budget);
        mCbFish = (CheckBox) findViewById(R.id.id_cb_fish);
        mCbHot = (CheckBox) findViewById(R.id.id_cb_hot);
        mCbSour = (CheckBox) findViewById(R.id.id_cb_sour);
        mBtnFind = (Button) findViewById(R.id.id_btn_findfood);
        mBtnFirst = (Button) findViewById(R.id.id_btn_first);
        mBtnLast = (Button) findViewById(R.id.id_btn_last);
        mBtnPre = (Button) findViewById(R.id.id_btn_pre);
        mBtnNext = (Button) findViewById(R.id.id_btn_next);
        mBtnSelect = (Button) findViewById(R.id.id_btn_chooseit);
        mIvPic = (ImageView) findViewById(R.id.id_iv_foodPic);
    }



    //初始化数据
    private void initData(){
        //获取食物名称数组
        String[] foodNames = getResources().getStringArray(R.array.foodName);
        String[] foodPrices = getResources().getStringArray(R.array.foodPrice);
        String[] foodHots = getResources().getStringArray(R.array.hot);
        String[] foodSours = getResources().getStringArray(R.array.sour);
        String[] foodFishs = getResources().getStringArray(R.array.fish);
        TypedArray pices = getResources().obtainTypedArray(R.array.pics);
        //将数组中的数据，转变为链表中的数据
        for(int i=0;i<foodNames.length;i++){
            Food food = new Food();
            food.setFoodName(foodNames[i]);
            food.setFoodPrice(Float.parseFloat(foodPrices[i]));
            food.setFish(foodFishs[i].equals("鱼")?true:false);
            food.setHot(foodHots[i].equals("辣")?true:false);
            food.setSour(foodSours[i].equals("酸")?true:false);
            food.setPics(pices.getDrawable(i));
            foodlist.add(food);
        }
    }
}
