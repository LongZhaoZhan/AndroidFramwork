package mvc.activity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.zl.framwork.R;
import com.zl.framwork.utils.ToastUtil;

import mvc.BaseActivity;
import mvc.interfaces.GLRenderer;

/**
 * 日期：2018/1/31
 * 时间：14:05
 * zhaolong
 */

public class GLSurfaceViewActivity extends BaseActivity {

    private GLSurfaceView glSurfaceView;

    /**
     * 启动openGl界面
     * @param context
     */
    public static void startAction(Context context) {
        Intent intent = new Intent(context, GLSurfaceViewActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        if (isCanOpenGl()) {
            glSurfaceView = new GLSurfaceView(this);
//            glSurfaceView.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
            glSurfaceView.setRenderer(new GLRenderer());
            setContentView(glSurfaceView);
        } else {
            setContentView(R.layout.activity_glsurfaceview);
            ToastUtil.showShort(this,"当前设备不支持OpenGL ES 2.0!");
        }
    }

    public boolean isCanOpenGl() {
        boolean canOpenGl;
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        ConfigurationInfo ci = activityManager.getDeviceConfigurationInfo();
        canOpenGl = ci.reqGlEsVersion >=0x200;

        //兼容模拟器
        boolean isEmulator = Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1
                && (Build.FINGERPRINT.startsWith("generic")
                || Build.FINGERPRINT.startsWith("unknown")
                || Build.MODEL.contains("google_sdk")
                || Build.MODEL.contains("Emulator")
                || Build.MODEL.contains("Android SDK built for x86"));

        //模拟器和手机上有一个满足，就可以执行openGl
        canOpenGl = canOpenGl || isEmulator;
        return canOpenGl;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(null != glSurfaceView){
            glSurfaceView.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(null != glSurfaceView){
            glSurfaceView.onPause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
