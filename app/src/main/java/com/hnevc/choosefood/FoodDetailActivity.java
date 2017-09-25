package com.hnevc.choosefood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FoodDetailActivity extends AppCompatActivity {
    Food mFood;
    int index=0;
    private ImageView mIvPic;
    private TextView mTvFoodName;
    private TextView mTvFoodPrice;
    private TextView mTvFoodDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        initView();
        //获取食物对象
        List<Food> foodList =new DataUtil(this).getFoodList();
        mFood = foodList.get(index);

        //显示数据
        mIvPic.setImageDrawable(mFood.getPics());
        mTvFoodName.setText(mFood.getFoodName());
        mTvFoodPrice.setText(mFood.getFoodPrice()+"");
        mTvFoodDetail.setText(mFood.getDetail());

    }

    private void initView() {
        mIvPic = (ImageView) findViewById(R.id.id_iv_foodPic);
        mTvFoodName = (TextView) findViewById(R.id.id_tv_foodName);
        mTvFoodPrice = (TextView) findViewById(R.id.id_tv_foodPrice);
        mTvFoodDetail = (TextView) findViewById(R.id.id_tv_foodDetail);
    }
}
