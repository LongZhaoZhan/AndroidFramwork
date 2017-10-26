package com.zl.framwork.baseframwork;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zl.framwork.utils.LogUtil;

/**
 * 作者：${ZhaoLong} on 2017/3/20 09:42
 * 邮箱：127124zhao@gmail.com
 * todo ==>>> 所有activity基类
 */

public class BaseActivity extends AppCompatActivity {

    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        LogUtil.getInstance().i(getClass().getSimpleName());

    }


}
