package mvc.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zl.framwork.R;
import com.zl.framwork.utils.LogUtil;
import com.zl.framwork.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mvc.BaseFragment;
import mvc.activity.SearchActivity;

/**
 * 作者：${ZhaoLong} on 2017/5/15 13:39
 * 邮箱：127124zhao@gmail.com
 * todo ==>>> 首页
 */

public class HomeFragment extends BaseFragment {

    private View view;
    @BindView(R.id.home_list_rv)
    RecyclerView homeRvList;//首页列表
    @BindView(R.id.home_title_city_name)
    TextView cityChoose;//城市选择控件入口
    @BindView(R.id.home_title_search)
    TextView movieSearch;//搜索入口

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(null ==savedInstanceState){
            view = inflater.inflate(R.layout.fragment_home, container, false);
            LogUtil.getInstance().i("创建首页fragment");
            ButterKnife.bind(this,view);
            return view;
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @OnClick(R.id.home_title_search)
    public void search(){
        ToastUtil.showShort(getActivity(),"搜索");
        //跳转到搜索界面
        SearchActivity.startAction(getActivity());
    }

    @OnClick(R.id.home_title_city_name)
    public void cityChoose(){
        ToastUtil.showShort(getActivity(),"城市选择");


    }



}
