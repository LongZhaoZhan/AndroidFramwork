package framwork.zl.com.androidframwork.baseframwork;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import utils.LogUtil;

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
