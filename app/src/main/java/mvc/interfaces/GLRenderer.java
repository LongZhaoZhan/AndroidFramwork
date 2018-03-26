package mvc.interfaces;

import android.opengl.GLSurfaceView;
import android.view.SurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * 日期：2018/1/31
 * 时间：14:39
 * zhaolong
 */

public class GLRenderer implements GLSurfaceView.Renderer {

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glClearColor(1f, 0f, 0f, 0f);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    }
}
