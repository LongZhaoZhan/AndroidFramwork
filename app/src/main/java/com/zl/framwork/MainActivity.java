package com.zl.framwork;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.ImageView;
import android.widget.TextView;

import com.zl.framwork.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mvc.BaseActivity;
import mvc.constants.Constant;
import mvc.fragment.CinemaFragment;
import mvc.fragment.HomeFragment;
import mvc.fragment.MineFragment;
import mvc.fragment.MovieFragment;
import mvc.fragment.ShowFragment;

/**
 * mvc 仿猫眼电影app主页
 */
public class MainActivity extends BaseActivity {

    @BindViews({R.id.tab_home_iv , R.id.tab_movie_iv , R.id.tab_cinema_iv , R.id.tab_show_iv , R.id.tab_mine_iv})
    public List<ImageView> tabImgList;
    @BindViews({R.id.tab_home_tv , R.id.tab_movie_tv , R.id.tab_cinema_tv , R.id.tab_show_tv , R.id.tab_mine_tv})
    public List<TextView> tabTvList;
    private List<Fragment> fList = new ArrayList<>();//所有activity的集合

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //绑定视图
        ButterKnife.bind(this);
        //设置默认fragment
        if(null == savedInstanceState){
            setFragmentByTag(Constant.HOME_FRAGMENT_TAG);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        FragmentManager fm = getSupportFragmentManager();
        List<Fragment> list = fm.getFragments();
        if(null != list && list.size()>0){
            fList.addAll(list);
        }
    }

    /**
     * 切换设置fragment
     * @param tag
     */
    private void setFragmentByTag(String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment tagF = fragmentManager.findFragmentByTag(tag);

        if(null == tagF){
            addFragmentByTag(tag);
        }

        //遍历数组，展示我们传递tag的fragment
        if(null != fList && fList.size()>0){
            for (Fragment f : fList){
                if(tag.equals(f.getTag())){
                    fragmentTransaction.show(f);
                }else{
                    fragmentTransaction.hide(f);
                }
            }
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    /**
     * 首次添加各个fragment
     * @param tag
     */
    private void addFragmentByTag(String tag){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (tag){
            case Constant.HOME_FRAGMENT_TAG:
                HomeFragment homeF = new HomeFragment();
                fList.add(homeF);
                fragmentTransaction.add(R.id.content,homeF,Constant.HOME_FRAGMENT_TAG);
                break;
            case Constant.MOVIE_FRAGMENT_TAG:
                MovieFragment movieF = new MovieFragment();
                fList.add(movieF);
                fragmentTransaction.add(R.id.content,movieF,Constant.MOVIE_FRAGMENT_TAG);
                break;
            case Constant.CINEMA_FRAGMENT_TAG:
                CinemaFragment cinemaF = new CinemaFragment();
                fList.add(cinemaF);
                fragmentTransaction.add(R.id.content,cinemaF,Constant.CINEMA_FRAGMENT_TAG);
                break;
            case Constant.SHOW_FRAGMENT_TAG:
                ShowFragment showF = new ShowFragment();
                fList.add(showF);
                fragmentTransaction.add(R.id.content,showF,Constant.SHOW_FRAGMENT_TAG);
                break;
            case Constant.MINE_FRAGMENT_TAG:
                MineFragment mineF = new MineFragment();
                fList.add(mineF);
                fragmentTransaction.add(R.id.content,mineF,Constant.MINE_FRAGMENT_TAG);
                break;
            default:
                break;
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    @OnClick(R.id.tab_home_ll)
    public void showHome(){
        LogUtil.getInstance().i("切换home");
        setFragmentByTag(Constant.HOME_FRAGMENT_TAG);
    }

    @OnClick(R.id.tab_movie_ll)
    public void showMovie(){
        setFragmentByTag(Constant.MOVIE_FRAGMENT_TAG);
        LogUtil.getInstance().i("切换movie");
    }

    @OnClick(R.id.tab_cinema_ll)
    public void showCinema(){
        setFragmentByTag(Constant.CINEMA_FRAGMENT_TAG);
        LogUtil.getInstance().i("切换cinema");
    }

    @OnClick(R.id.tab_show_ll)
    public void showS(){
        setFragmentByTag(Constant.SHOW_FRAGMENT_TAG);
        LogUtil.getInstance().i("切换演出");
    }

    @OnClick(R.id.tab_mine_ll)
    public void showMine(){
        setFragmentByTag(Constant.MINE_FRAGMENT_TAG);
        LogUtil.getInstance().i("切换mine");
    }

}
