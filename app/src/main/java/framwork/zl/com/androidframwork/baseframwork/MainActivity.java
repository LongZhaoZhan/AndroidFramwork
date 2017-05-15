package framwork.zl.com.androidframwork.baseframwork;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import java.lang.reflect.Method;

import framwork.zl.com.androidframwork.R;

/**
 * 邮件首页
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    /**
     * 网上说重写这个方法可以展示出menu图标
     * 如果需要展示图标，请使用
     * popUpwindow、popupmenu
     * spinner、menu、submenu、contextMenu
     * @param featureId
     * @param menu
     * @return
     */
    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (featureId == Window.FEATURE_ACTION_BAR && menu != null) {
            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
                try {
                    Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (Exception e) {
                }
            }
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //创建首页menu
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.write_email:
                //点击写邮件menu，跳转到编写邮件界面
                Toast.makeText(mContext,"show"+item.getTitle(),Toast.LENGTH_SHORT).show();



                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
