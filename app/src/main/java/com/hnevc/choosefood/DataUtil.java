package com.hnevc.choosefood;

import android.content.Context;
import android.content.res.TypedArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/25.
 */

public class DataUtil {
    private Context mContext;

    public DataUtil(Context context) {
        mContext = context;
    }

    public  List<Food> getFoodList(){
        ArrayList<Food> foodlist = new ArrayList<>();
        //获取食物名称数组
        String[] foodNames = mContext.getResources().getStringArray(R.array.foodName);
        String[] foodPrices = mContext.getResources().getStringArray(R.array.foodPrice);
        String[] foodHots = mContext.getResources().getStringArray(R.array.hot);
        String[] foodSours = mContext.getResources().getStringArray(R.array.sour);
        String[] foodFishs = mContext.getResources().getStringArray(R.array.fish);
        String[] foodDetail = mContext.getResources().getStringArray(R.array.detail);
        TypedArray pices = mContext.getResources().obtainTypedArray(R.array.pics);
        //将数组中的数据，转变为链表中的数据
        for(int i=0;i<foodNames.length;i++){
            Food food = new Food();
            food.setFoodName(foodNames[i]);
            food.setFoodPrice(Float.parseFloat(foodPrices[i]));
            food.setFish(foodFishs[i].equals("鱼")?true:false);
            food.setHot(foodHots[i].equals("辣")?true:false);
            food.setSour(foodSours[i].equals("酸")?true:false);
            food.setDetail(foodDetail[i]);
            food.setPics(pices.getDrawable(i));
            foodlist.add(food);
        }
        return foodlist;
    }
}
