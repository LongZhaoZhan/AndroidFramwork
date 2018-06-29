package com.zl.framwork;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.zl.framwork.okhttp.Constants;
import com.zl.framwork.okhttp.OkHttpFinal;
import com.zl.framwork.okhttp.OkHttpFinalConfiguration;
import com.zl.framwork.okhttp.Part;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;
import okhttp3.Interceptor;

/**
 * 作者：${ZhaoLong} on 2017/3/21 15:33
 * 邮箱：127124zhao@gmail.com
 * todo ==>>> 仿猫眼电影，自定义工程文件
 */

public class BaseApplication extends MultiDexApplication{

    public static Context myApplication;
    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        refWatcher = initLeakCanary();
        //初始化图片加载组件
        initImageLoader();
        //初始化http组件
        initOkhttp();
        //初始化数据库插件
        initGreenDao();

    }

    /**
     * 初始化数据库插件
     */
    private void initGreenDao() {

    }

    /**
     * 初始化http框架
     */
    private void initOkhttp() {
        //公共参数
        List<Part> commomParams = new ArrayList<>();
        //公共头部
        Headers commonHeaders = new Headers.Builder().build();
        //拦截器
        List<Interceptor> interceptorList = new ArrayList<>();
        OkHttpFinalConfiguration.Builder builder = new OkHttpFinalConfiguration.Builder()
                .setCommenParams(commomParams)
                .setCommenHeaders(commonHeaders)
                .setTimeout(Constants.REQ_TIMEOUT)
                .setInterceptors(interceptorList)
                //.setCookieJar(CookieJar.NO_COOKIES)
                //.setCertificates(...)
                //.setHostnameVerifier(new SkirtHttpsHostnameVerifier())
                .setDebug(Constants.DEBUG);
//        addHttps(builder);
        OkHttpFinal.getInstance().init(builder.build());
    }

    /**
     * 初始化图片加载控件
     */
    private void initImageLoader() {
        File cacheDir = StorageUtils.getCacheDirectory(this);
//        ImageLoaderConfiguration config = ImageLoaderConfiguration.createDefault(this);
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
//                .memoryCacheExtraOptions(480, 800) // default = device screen dimensions
//              .diskCacheExtraOptions(480, 800, Bitmap.CompressFormat.JPEG, 75, null)
//              .taskExecutor(...)
//              .taskExecutorForCachedImages(...)
                .threadPoolSize(3) // default
                .threadPriority(Thread.NORM_PRIORITY - 1) // default
                .tasksProcessingOrder(QueueProcessingType.FIFO) // default
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
                .memoryCacheSize(2 * 1024 * 1024)
                .memoryCacheSizePercentage(13) // default
//                .diskCache(new UnlimitedDiscCache(cacheDir)) // default
                .diskCacheSize(50 * 1024 * 1024)
                .diskCacheFileCount(100)
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
                .imageDownloader(new BaseImageDownloader(this)) // default
                .imageDecoder(new BaseImageDecoder(BuildConfig.DEBUG)) // default
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple()) // default
                .writeDebugLogs()
                .build();
        ImageLoader.getInstance().init(config);
    }

    /**
     * 初始化内存监控
     */
    private RefWatcher initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return RefWatcher.DISABLED;
        }
        return LeakCanary.install(this);
    }

    /**
     * 获得内存泄漏观察者
     * @param context
     * @return
     */
    public static RefWatcher getRefWatcher(Context context) {
        BaseApplication application = (BaseApplication) context.getApplicationContext();
        return application.refWatcher;
    }


}
