package mvc.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.zl.framwork.R;
import com.zl.framwork.utils.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import mvc.BaseFragment;

/**
 * 日期：2018/2/11
 * 时间：16:51
 * zhaolong
 */

public class CommonAppStartFragment extends BaseFragment {

    @BindView(R.id.goto_wechat)
    RelativeLayout gotoWechat;
    @BindView(R.id.goto_qq)
    RelativeLayout gotoQq;
    @BindView(R.id.goto_alipay)
    RelativeLayout gotoAlipay;
    @BindView(R.id.goto_sina)
    RelativeLayout gotoSina;
    @BindView(R.id.goto_taobao)
    RelativeLayout gotoTaobao;
    @BindView(R.id.goto_tianmao)
    RelativeLayout gotoTianmao;
    Unbinder unbinder;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (null == view) {
            view = inflater.inflate(R.layout.fragment_common_start_app, container, false);
        }
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.goto_wechat)
    public void goToWeChat() {
        LogUtil.getInstance().i("点击启动微信");
//        Util.doStartApplicationWithPackageName(getActivity(),"com.tencent.mm");
    }


}
