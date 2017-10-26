package com.zl.framwork;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * 作者：${ZhaoLong} on 2017/3/21 15:33
 * 邮箱：127124zhao@gmail.com
 * todo ==>>> 自定义工程文件
 */

public class MyBaseApplication extends Application{

    public static Context myApplication;
    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;

        refWatcher = initLeakCanary();

    }

    /**
     * 初始化内存监控
     */
    private RefWatcher initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return RefWatcher.DISABLED;
        }
        return LeakCanary.install(this);
    }

    /**
     * 获得内存泄漏观察者
     * @param context
     * @return
     */
    public static RefWatcher getRefWatcher(Context context) {
        MyBaseApplication application = (MyBaseApplication) context.getApplicationContext();
        return application.refWatcher;
    }


}
