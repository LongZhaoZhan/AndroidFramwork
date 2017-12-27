package mvc.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zl.framwork.R;

import butterknife.ButterKnife;
import mvc.BaseActivity;

/**
 * 作者：zhaolong
 * 日期：2017/10/27
 * 邮箱：longzhao2@gmail.com
 * 电话：15209866017
 * TODO=> 城市选择控件界面+高德地图定位
 */

public class CityChooseActivity extends BaseActivity{

    public static void startAction(Context context){
        context.startActivity(new Intent(context,CityChooseActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        ButterKnife.bind(this);
    }

}
