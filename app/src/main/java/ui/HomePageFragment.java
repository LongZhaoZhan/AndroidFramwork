package ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import framwork.zl.com.androidframwork.R;
import framwork.zl.com.androidframwork.baseframwork.BaseFragment;

/**
 * 作者：${ZhaoLong} on 2017/5/15 13:39
 * 邮箱：127124zhao@gmail.com
 * todo ==>>> 首页fragment
 */

public class HomePageFragment extends BaseFragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);
        return view;
    }



}
