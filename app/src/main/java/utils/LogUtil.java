package utils;

import android.util.Log;

import framwork.zl.com.androidframwork.baseframwork.BaseFragment;

/**
 * 作者：${ZhaoLong} on 2017/5/15 13:56
 * 邮箱：127124zhao@gmail.com
 * todo ==>>>
 */

public class LogUtil {

    private static volatile LogUtil logUtil;

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

    public void i(String tag , String info){
        Log.i(tag , info);
    }




}
