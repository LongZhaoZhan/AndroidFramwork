package mvc.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.zl.framwork.R;
import com.zl.framwork.gilde.GlideManager;
import com.zl.framwork.inter.BitmapListener;
import com.zl.framwork.utils.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import mvc.BaseActivity;
import mvc.MainActivity;

/**
 * 作者:longzhao2
 * 手机号:15375447216
 * 邮箱:longzhao2@iflytek.com
 * 项目:mvc.activity
 * 时间:2018/5/7
 * 简介:
 */
public class SplashActivity extends BaseActivity {

    @BindView(R.id.splash_img)
    ImageView splashImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        loadAdv("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1525684612912&di=054457056d2b077e3e632e29cb1bf0c4&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F12%2F70%2F58%2F50i58PICJqx.jpg");
    }

    private void loadAdv(String url) {
        if (null == splashImg) {
            return;
        }
        new GlideManager.Builder().setContext(this).setImgSource(url).setImageView(splashImg).setLoadingBitmap(R.color.transParent).builder().addLoadLstner(new BitmapListener() {
            @Override
            public void onSuccess(Object responseObj) {
                LogUtil.getInstance().i("加载广告图片成功==" + responseObj);
            }

            @Override
            public void onFailure(Object errorObj) {
                LogUtil.getInstance().i("加载广告图片失败==" + errorObj);
            }
        });

        startTimer();

    }

    /**
     * 开始倒计时
     */
    private void startTimer(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                MainActivity.startAction(SplashActivity.this);
            }
        },2500);
    }

}
