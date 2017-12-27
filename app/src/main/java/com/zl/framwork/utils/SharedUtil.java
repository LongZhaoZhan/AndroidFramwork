package com.zl.framwork.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.zl.framwork.BaseApplication;

/**
 * 日期：2017/12/15
 * 时间：8:32
 * zhaolong
 */

public class SharedUtil {

    private static final String shareName = BaseApplication.myApplication.getPackageName();

    /**
     * 保存字符串数据到share
     *
     * @param key
     * @param value
     */
    public static void saveStr(String key, String value) {
        SharedPreferences sp = BaseApplication.myApplication.getSharedPreferences(shareName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * 从share中去除字符串数据
     *
     * @param key
     * @return
     */
    public String getStr(String key) {
        try {
            return BaseApplication.myApplication.getSharedPreferences(shareName, Context.MODE_PRIVATE).getString(key, "");
        } catch (Exception e) {
            LogUtil.getInstance().e("获取share存储信息失败" + e.getMessage());
        }
        return "";
    }


}
