package mvc;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zl.framwork.R;
import com.zl.framwork.utils.LogUtil;
import com.zl.framwork.utils.StatusBarCompat;

/**
 * 作者：${ZhaoLong} on 2017/3/20 09:42
 * 邮箱：127124zhao@gmail.com
 * todo ==>>> mvc所有activity基类
 */

public class BaseActivity extends AppCompatActivity {

    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        LogUtil.getInstance().i(getClass().getSimpleName());
        //设置沉侵式状态栏
        StatusBarCompat.compat(this, getResources().getColor(R.color.colorAccent));
    }

}
