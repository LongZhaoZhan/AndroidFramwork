package mvc.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.zl.framwork.BaseApplication;
import com.zl.framwork.R;
import com.zl.framwork.utils.LogUtil;
import com.zl.framwork.utils.ToastUtil;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mvc.BaseFragment;
import mvc.receiver.BaiDuLocation;

/**
 * 作者：zhaolong
 * 日期：2017/10/27
 * 邮箱：longzhao2@gmail.com
 * 电话：15209866017
 * TODO=> 影院界面
 */

public class CinemaFragment extends BaseFragment {

    @BindView(R.id.cinema_city_tv)
    TextView cityTv;
    @BindView(R.id.cinema_re_location_pb)
    ProgressBar reGetLocationPb;
    public BaiDuLocation locationService;
    @BindView(R.id.cinema_fragment_reget_location)
    RelativeLayout reGetLocation;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (null == savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_cinema, container, false);
            LogUtil.getInstance().i("创建影院fragment");
            ButterKnife.bind(this, view);
            //首次进入进行定位
            initLocation();
            return view;
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    /**
     * 初始化定位
     */
    private void initLocation() {
        reGetLocationPb.setVisibility(View.VISIBLE);
        cityTv.setVisibility(View.GONE);
        locationService = new BaiDuLocation(getActivity());
        //注册监听,监听为弱引用，防止抱死mainActivity的上下文，导致内存泄漏
        locationService.registerListener(new MyListener(this));
        locationService.setLocationOption(locationService.getDefaultLocationClientOption());
        locationService.start();
    }

    /**
     * 开启子线程接受，防止内存泄漏
     * @param addressStr
     */
    public void setLocation(final String addressStr){
        reGetLocationPb.setVisibility(View.GONE);
        cityTv.setVisibility(View.VISIBLE);
        cityTv.setText(addressStr);
        if(null != locationService) {
            locationService.stop();
        }
    }

    @OnClick(R.id.cinema_fragment_reget_location)
    public void reLoadLocation(){
        //开始定位
        if(null != locationService){
            reGetLocationPb.setVisibility(View.VISIBLE);
            cityTv.setVisibility(View.GONE);
            locationService.start();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.getInstance().i("影院界面destroy");
        locationService.stop();
        locationService = null;
    }

    /**
     * 百度定位监听
     * 弱引用监听，防止内存泄漏
     */
    public static class MyListener extends BDAbstractLocationListener {
        private final WeakReference<CinemaFragment> weakReference;

        public MyListener(CinemaFragment cinemaFragment) {
            this.weakReference = new WeakReference<CinemaFragment>(cinemaFragment);
        }

        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            if (null != weakReference.get().locationService) {
                if (null != bdLocation && bdLocation.getLocType() != BDLocation.TypeServerError) {
                    if (bdLocation.getLocType() == BDLocation.TypeGpsLocation) {// GPS定位结果
                        ToastUtil.showShort(weakReference.get().getActivity(), "gps定位成功");

                    } else if (bdLocation.getLocType() == BDLocation.TypeNetWorkLocation) {// 网络定位结果
                        // 运营商信息
                        ToastUtil.showShort(weakReference.get().getActivity(), "运营商定位成功");

                    } else if (bdLocation.getLocType() == BDLocation.TypeOffLineLocation) {// 离线定位结果
                        ToastUtil.showShort(weakReference.get().getActivity(), "定位失败，请检查您的网络连接~");
                        weakReference.get().setLocation("点击重试~");
                        return;
                    } else if (bdLocation.getLocType() == BDLocation.TypeNetWorkException) {
                        ToastUtil.showShort(weakReference.get().getActivity(), "网络不同导致定位失败，请检查网络是否通畅");
                        weakReference.get().setLocation("点击重试~");
                        return;
                    } else if (bdLocation.getLocType() == BDLocation.TypeCriteriaException) {
                        ToastUtil.showShort(weakReference.get().getActivity(), "无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");
                        weakReference.get().setLocation("点击重试~");
                        return;
                    } else {
                        ToastUtil.showShort(weakReference.get().getActivity(), "定位失败");
                        weakReference.get().setLocation("点击重试~");
                        return;
                    }
                } else {
                    ToastUtil.showShort(weakReference.get().getActivity(), "服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");
                    weakReference.get().setLocation("点击重试~");
                    return;
                }
                //设置城市位置
                weakReference.get().setLocation(bdLocation.getAddrStr());
            }
        }
    }

}
