package com.zl.framwork.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zl.framwork.R;
import com.zl.framwork.baseframwork.BaseFragment;
import com.zl.framwork.http.VolleyUtil;
import com.zl.framwork.utils.LogUtil;

/**
 * 作者：${ZhaoLong} on 2017/5/15 13:39
 * 邮箱：127124zhao@gmail.com
 * todo ==>>> 首页fragment
 * RecyclerView  打造
 */

public class HomePageFragment extends BaseFragment {

    private TextView title;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_homepage, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.home_page_rc_lv);


        LogUtil.getInstance().i("HomePageFragment_RecyclerView");


        title = (TextView) view.findViewById(R.id.title);



        return view;
    }

    public void volleyStr(View strBtn){
        VolleyUtil volleyUtil = new VolleyUtil();
        volleyUtil.sendVolleyStrPost();

    }



}
