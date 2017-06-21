package com.zl.framwork.utils;

import android.util.Log;

import com.zl.framwork.BuildConfig;

/**
 * 作者：${ZhaoLong} on 2017/5/15 13:56
 * 邮箱：127124zhao@gmail.com
 * todo ==>>>
 */

public class LogUtil {

    private static volatile LogUtil logUtil;//日志工具类
    private String className;//类名
    private String methodName;//方法名
    private int lineNumber;//行数

    public static LogUtil getInstance(){
        if(null == logUtil){
            synchronized (LogUtil.class){
                if(null == logUtil){
                    logUtil = new LogUtil();
                }
            }
        }
        return logUtil;
    }

    public void getMethodNames(StackTraceElement[] sELement){
        className = sELement[1].getFileName();
        methodName = sELement[1].getMethodName();
        lineNumber = sELement[1].getLineNumber();
    }

    public static boolean isDebuggable() {
        return BuildConfig.DEBUG;
    }

    public String createLog(String message){
        StringBuffer buffer = new StringBuffer();
        buffer.append(methodName);
        buffer.append("(").append(className).append(":").append(lineNumber).append(")");
        buffer.append(message);
        return buffer.toString();
    }

    public void e(String message){
        if (!isDebuggable())
            return;

        // Throwable instance must be created before any methods
        getMethodNames(new Throwable().getStackTrace());
        Log.e(className, createLog(message));
    }


    public void i(String message){
        if (!isDebuggable())
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.i(className, createLog(message));
    }

    public void d(String message){
        if (!isDebuggable())
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.d(className, createLog(message));
    }

    public void v(String message){
        if (!isDebuggable())
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.v(className, createLog(message));
    }

    public void w(String message){
        if (!isDebuggable())
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.w(className, createLog(message));
    }

    public void wtf(String message){
        if (!isDebuggable())
            return;
        getMethodNames(new Throwable().getStackTrace());
        Log.wtf(className, createLog(message));
    }

}
