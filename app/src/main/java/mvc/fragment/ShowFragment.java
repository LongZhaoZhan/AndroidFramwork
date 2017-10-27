package mvc.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zl.framwork.R;
import com.zl.framwork.utils.LogUtil;

import mvc.BaseFragment;

/**
 * 作者：zhaolong
 * 日期：2017/10/27
 * 邮箱：longzhao2@gmail.com
 * 电话：15209866017
 * TODO=>
 */

public class ShowFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(null == savedInstanceState){
            View view = inflater.inflate(R.layout.fragment_show,container,false);
            LogUtil.getInstance().i("创建演出fragment");
            return view;
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
