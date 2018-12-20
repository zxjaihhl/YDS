package com.zxjaihhl.yds.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.zxjaihhl.yds.view.BatteryView;

/**
 * Created by Administrator on 2017/9/13.
 * 描述：
 */

public class SharedUtils{
    public static final String NAME = "config";

    //键 值
    public static void putString(Context mContext, String key, String value) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(key, value).commit();
    }

    //键 默认值
    public static String getString(Context mContext, String key, String defValue) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, defValue);
    }

    //键 值
    public static void putInt(Context mContext, String key, int value) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt(key, value).commit();
    }

    //键 默认值
    public static int getInt(Context mContext, String key, int defValue) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, defValue);
    }

    //键 值
    public static void putBoolean(Context mContext, String key, boolean value) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean(key, value).commit();
    }

    //键 默认值
    public static boolean getBoolean(Context mContext, String key, boolean defValue) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, defValue);
    }
    //删除 单个
    public static void deleShare(Context mContext,String key){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().remove(key).commit();
    }
    //删除 全部
    public static void deleAll(Context mContext){
        SharedPreferences sharedPreferences=mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().commit();

    }

}
