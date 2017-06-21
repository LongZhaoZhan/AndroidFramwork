package com.zl.framwork.baseframwork;

import android.app.Application;
import android.content.Context;

/**
 * 作者：${ZhaoLong} on 2017/3/21 15:33
 * 邮箱：127124zhao@gmail.com
 * todo ==>>>
 */

public class MyBaseApplication extends Application{

    public static Context myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
    }



}
