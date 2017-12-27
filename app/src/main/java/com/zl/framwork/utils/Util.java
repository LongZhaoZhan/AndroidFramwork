package com.zl.framwork.utils;

import android.content.Context;

/**
 * 作者：zhaolong
 * 日期：2017/11/8
 * 时间：14:11
 * 邮箱：longzhao2@gmail.com
 * 电话：15209866017
 * TODO=>
 */

public class Util {

    /**
     * dip转px
     * @param context
     * @param dipValue
     * @return
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * px转dp
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

}
