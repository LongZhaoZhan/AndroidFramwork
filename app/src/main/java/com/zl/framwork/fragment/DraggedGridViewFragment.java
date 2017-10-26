package com.zl.framwork.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zl.framwork.R;
import com.zl.framwork.baseframwork.BaseFragment;

/**
 * 作者：zhaolong
 * 日期：2017/10/24
 * 邮箱：longzhao2@gmail.com
 * 电话：15209866017
 * TODO=> 可拖动的gridview界面
 */

public class DraggedGridViewFragment extends BaseFragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drag_gridview,container,false);
        return view;
    }
}
