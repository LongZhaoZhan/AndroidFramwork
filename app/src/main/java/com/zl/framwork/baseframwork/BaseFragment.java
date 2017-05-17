package com.zl.framwork.baseframwork;

import android.app.Fragment;

import com.zl.framwork.utils.LogUtil;

/**
 * 作者：${ZhaoLong} on 2017/3/20 10:17
 * 邮箱：127124zhao@gmail.com
 * todo ==>>>
 */

public class BaseFragment extends Fragment{

    private static final String TAG = "BaseFragment";

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        LogUtil.getInstance().i(TAG, "setUserVisibleHint");
    }

}
