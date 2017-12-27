package mvc.receiver;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.zl.framwork.BaseApplication;
import com.zl.framwork.utils.LogUtil;

import mvc.utils.LocationUtl;

/**
 * 作者：zhaolong
 * 日期：2017/10/30
 * 邮箱：longzhao2@gmail.com
 * 电话：15209866017
 * TODO=> 高德地图定位工具类
 */

public class GDLocation{

    private AMapLocationClientOption myOption;
    private static GDLocation gdLocation;
    private AMapLocationClient locationClient;
    private LocationCallBack callBack;

    /**
     * 获取GDLocation实列
     * @return
     */
    public static GDLocation getInstance(){
        if(null == gdLocation){
            synchronized (GDLocation.class){
                if(null == gdLocation){
                    gdLocation = new GDLocation();
                }
            }
        }
        return gdLocation;
    }

    /**
     * 开始定位
     */
    public void startLocation(LocationCallBack callBack){
        this.callBack = callBack;
        //初始化client
        locationClient = new AMapLocationClient(BaseApplication.myApplication);
        if(null != myOption){
            //设置定位参数
            locationClient.setLocationOption(myOption);
        }else{
            locationClient.setLocationOption(getDefaultOption());
        }
        // 设置定位监听
        locationClient.setLocationListener(locationListener);
        // 启动定位
        locationClient.startLocation();
    }

    /**
     * 设置定位参数
     * @param option
     */
    public void setOption(AMapLocationClientOption option){
        this.myOption = option;
    }

    /**
     * 获取默认option
     * @return
     */
    private AMapLocationClientOption getDefaultOption(){
        AMapLocationClientOption mOption = new AMapLocationClientOption();
        mOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);//可选，设置定位模式，可选的模式有高精度、仅设备、仅网络。默认为高精度模式
        mOption.setGpsFirst(false);//可选，设置是否gps优先，只在高精度模式下有效。默认关闭
        mOption.setHttpTimeOut(30000);//可选，设置网络请求超时时间。默认为30秒。在仅设备模式下无效
        mOption.setInterval(2000);//可选，设置定位间隔。默认为2秒
        mOption.setNeedAddress(true);//可选，设置是否返回逆地理地址信息。默认是true
        mOption.setOnceLocation(false);//可选，设置是否单次定位。默认是false
        mOption.setOnceLocationLatest(false);//可选，设置是否等待wifi刷新，默认为false.如果设置为true,会自动变为单次定位，持续定位时不要使用
        AMapLocationClientOption.setLocationProtocol(AMapLocationClientOption.AMapLocationProtocol.HTTP);//可选， 设置网络请求的协议。可选HTTP或者HTTPS。默认为HTTP
        mOption.setSensorEnable(false);//可选，设置是否使用传感器。默认是false
        mOption.setWifiScan(true); //可选，设置是否开启wifi扫描。默认为true，如果设置为false会同时停止主动刷新，停止以后完全依赖于系统刷新，定位位置可能存在误差
        mOption.setLocationCacheEnable(true); //可选，设置是否使用缓存定位，默认为true
        return mOption;
    }

    /**
     * 停止定位
     */
    public void stopLocation(){
        if(null != locationClient){
            locationClient.stopLocation();
        }
    }

    /**
     * 销毁定位
     */
    public void destroyLocation(){
        if (null != locationClient) {
            /**
             * 如果AMapLocationClient是在当前Activity实例化的，
             * 在Activity的onDestroy中一定要执行AMapLocationClient的onDestroy
             */
            locationClient.onDestroy();
            locationClient = null;
            myOption = null;
        }
    }

    /**
     * 定位监听
     */
    AMapLocationListener locationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation loc) {
            if (null != loc) {
                //解析定位结果
                String result = LocationUtl.getLocationStr(loc);
                LogUtil.getInstance().i("定位成功信息="+result);
                callBack.success(loc.getCity());
            } else {
                callBack.failed("errorCode="+loc.getErrorCode()+"errorInfo="+loc.getErrorInfo());
                LogUtil.getInstance().i("定位失败信息="+"errorCode="+loc.getErrorCode()+"errorInfo="+loc.getErrorInfo());
            }
            stopLocation();
        }
    };

    /**
     * 定位信息回调到上层方法
     */
    public interface LocationCallBack{
        void success(String result);
        void failed(String berrorInfo);
    }

}
