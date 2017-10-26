package com.zl.framwork.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zl.framwork.R;
import com.zl.framwork.baseframwork.BaseFragment;

/**
 * 作者：${ZhaoLong} on 2017/5/15 13:39
 * 邮箱：127124zhao@gmail.com
 * todo ==>>> 首页
 */

public class HomePageFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);
        return view;
    }
}
