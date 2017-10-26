package com.zl.framwork;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;

import com.zl.framwork.baseframwork.BaseActivity;
import com.zl.framwork.constants.Constant;
import com.zl.framwork.fragment.DraggedGridViewFragment;
import com.zl.framwork.fragment.HomePageFragment;

/**
 * 邮件首页
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(null == savedInstanceState){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            HomePageFragment fragment = new HomePageFragment();
            fragmentTransaction.replace(R.id.content,fragment, Constant.HOME_FRAGMENT_TAG);
            fragmentTransaction.commit();
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //创建首页menu
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //进入可拖动的gridview界面
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (item.getItemId()){
            case R.id.drag_grid_view:
                //第一种情况
//                FragmentTransaction tx = fm.beginTransaction();
//                tx.replace(R.id.id_content, fTwo, "TWO");
//                tx.addToBackStack(null);
//                tx.commit();
                //第二种情况
//                FragmentTransaction tx = fm.beginTransaction();
//                tx.hide(this);
//                tx.add(R.id.id_content , fThree, "THREE");
//                tx.replace(R.id.id_content, fThree, "THREE");
//                tx.addToBackStack(null);
//                tx.commit();
                DraggedGridViewFragment dragGVFragment = new DraggedGridViewFragment();
                fragmentTransaction.replace(R.id.content,dragGVFragment,Constant.DRAG_GRIDVIEW_TAG);
                fragmentTransaction.addToBackStack(null);
                break;
        }
        fragmentTransaction.commit();
        return true;
    }


}
