package mvc.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhengsr.viewpagerlib.GlideManager;
import com.zhengsr.viewpagerlib.bean.PageBean;
import com.zhengsr.viewpagerlib.callback.PageHelperListener;
import com.zhengsr.viewpagerlib.indicator.TransIndicator;
import com.zhengsr.viewpagerlib.view.BannerViewPager;
import com.zl.framwork.R;
import com.zl.framwork.utils.LogUtil;
import com.zl.framwork.utils.ToastUtil;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mvc.BaseFragment;
import mvc.activity.CityChooseActivity;
import mvc.activity.SearchActivity;
import mvc.adapter.HomeListAdapter;
import mvc.bean.HomeInfo;
import mvc.bean.LoopBean;
import mvc.decoration.HomeItemDecoration;
import mvc.receiver.GDLocation;

/**
 * 作者：zhaolong
 * 日期：2017/10/27
 * 邮箱：longzhao2@gmail.com
 * 电话：15209866017
 * todo ==>>> 首页
 */

public class HomeFragment extends BaseFragment{

    private View view;
    @BindView(R.id.home_list_rv)
    RecyclerView homeRecyclerView;//首页列表

    @BindView(R.id.home_title_city_name)
    public TextView cityChoose;//城市选择控件入口
    @BindView(R.id.home_title_search)
    TextView movieSearch;//搜索入口
    private GDLocation gdLocation;
    private List<HomeInfo> homeList;

    private static final Integer[] RES = {R.drawable.guide1,R.drawable.guide2,R.drawable.guide3,
            R.drawable.guide4 };

    private static final String[] RESURL = {
            "http://img.mukewang.com/54bf7e1f000109c506000338-590-330.jpg",
            "http://upload.techweb.com.cn/2015/0114/1421211858103.jpg",
            "http://img1.cache.netease.com/catchpic/A/A0/A0153E1AEDA115EAE7061A0C7EBB69D2.jpg",
            "http://image.tianjimedia.com/uploadImages/2015/202/27/57RF8ZHG8A4T_5020a2a4697650b89" +
                    "c394237ba9ffbb45fe8555a2cbec-6O6nmI_fw658.jpg"};

    private static final String[] TEXT = {"图像处理","LSB开发","游戏开发","梦想"};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(null ==savedInstanceState){
            view = inflater.inflate(R.layout.fragment_home, container, false);
            LogUtil.getInstance().i("创建首页fragment");
            ButterKnife.bind(this,view);
            initHeadView();
            initView();
            startLocation();
            return view;
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void initHeadView() {

        //配置数据
        List<LoopBean> loopBeens = new ArrayList<>();
        for (int i = 0; i < TEXT.length; i++) {
            LoopBean bean2 = new LoopBean();
            bean2.res = RES[i];
            bean2.text = TEXT[i];
            loopBeens.add(bean2);
        }

        View headView = View.inflate(getActivity(), R.layout.home_fragment_head,null);
        BannerViewPager transBannerViewPager = (BannerViewPager) headView.findViewById(R.id.loop_viewpager_arc);
        TransIndicator transIndicator = (TransIndicator) headView.findViewById(R.id.bottom_trans_layout);

        //配置pagerbean，这里主要是为了viewpager的指示器的作用，注意记得写上泛型
        PageBean bean = new PageBean.Builder<LoopBean>()
                .setDataObjects(loopBeens)
                .setIndicator(transIndicator)
                .builder();

        transBannerViewPager.setPageListener(bean, R.layout.arc_loop_layout, new PageHelperListener() {
            @Override
            public void getItemView(View view, Object data) {

                ImageView imageView = (ImageView) view.findViewById(R.id.arc_icon);

                final LoopBean bean = (LoopBean) data;

                new GlideManager.Builder()
                        .setContext(getActivity())
                        .setImgSource(bean.res)
                        .setLoadingBitmap(R.mipmap.ic_launcher)
                        .setImageView(imageView)
                        .builder();

                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getActivity(), bean.text, Toast.LENGTH_SHORT).show();
                    }
                });
                //如若你要设置点击事件，也可以直接通过这个view 来设置，或者图片的更新等等
            }
        });


    }

    /**
     * 设置view
     */
    private void initView() {
          //设置textview可滑动
//        cityChoose.setMovementMethod(ScrollingMovementMethod.getInstance());
        //设置RecyclerView刷新、轮播、头布局、列表数据
        initData();

        HomeListAdapter homeAdapter = new HomeListAdapter(getActivity(),homeList);

        //设置视图管理器
        homeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //设置分割器
        homeRecyclerView.addItemDecoration(new HomeItemDecoration(getActivity(),HomeItemDecoration.VERTICAL_LIST));

        //设置适配器
        homeRecyclerView.setAdapter(homeAdapter);


//        homeRecyclerView.addView(headView);

    }

    /**
     * 初始化数据
     * 手动塞数据
     */
    private void initData() {
        homeList = new ArrayList<>();
        HomeInfo homeInfo1 = new HomeInfo("http://www.qqzhi.com/uploadpic/2014-09-03/181938680.jpg","http://c.hiphotos.baidu.com/image/h%3D220/sign=10fa5c28fbd3572c79e29bdeba126352/e850352ac65c10384968c503bb119313b17e89d8.jpg","https://www.zhihu.com/question/39974807/answer/256025617","闹灾荒的时候","闹灾荒的时候，和珅在给灾民的米汤里撒了一把沙子， 这其中包含着什么经济学原理？");
        homeList.add(homeInfo1);
        HomeInfo homeInfo2 = new HomeInfo("http://img3.duitang.com/uploads/item/201602/27/20160227192212_SmNWM.jpeg","http://d.hiphotos.baidu.com/image/pic/item/86d6277f9e2f0708e32c5bc1e024b899a801f2c2.jpg","https://www.zhihu.com/question/23599061/answer/253903047","真的很多人在华强北被骗吗？","做为一个华强北有实体店。又有网店的商家。觉得很无辜，有时和别人说有实体店，问在哪里？华强北，华强北水深吖。我想说，毕竟那里也是最专业的嘛。而且真的做长久生意的人，哪里会以骗为生呢。就算别人卖翻新的，那也是有诚信的在做，告诉下家，这就是翻新的，很少会没信誉的。");
        homeList.add(homeInfo2);
        HomeInfo homeInfo3 = new HomeInfo("http://img0.imgtn.bdimg.com/it/u=3100950617,3071583171&fm=214&gp=0.jpg","http://e.hiphotos.baidu.com/image/pic/item/023b5bb5c9ea15ce12fafec8bf003af33b87b2de.jpg","https://www.zhihu.com/question/30758136/answer/255465737","你是什么时候发现赚钱如此容易?","混日子，是混不出一个光明的前途的。省吃俭用，永远买不起房子。人在江湖，你想发财，简单。有本事，社会上的钱任你取，没有本事，出来混，别人给你多少钱，就是多少钱。有的人，这辈子啥都自己说了算；有的人这辈子啥都是别人说了算。我们打工只用每天想着把自己手头的事做好，打工100%没有风险，反正每个月到手二三千块，饿不死就行。只是现实生活高房价高物价，谁又甘心于平淡。有些人觉得够吃够喝就行，那么拼干嘛？能多睡一会就睡一会，能多玩一会就多玩一会。他们整个青春期就是用来扯淡或睡觉的。等有天他们老了不得不从事低级的、乏味的、甚至无聊透顶的工作。想起任志强的一句话。");
        homeList.add(homeInfo3);
        HomeInfo homeInfo4 = new HomeInfo("http://img3.imgtn.bdimg.com/it/u=2770691011,100164542&fm=27&gp=0.jpg","http://e.hiphotos.baidu.com/image/pic/item/574e9258d109b3de28c538a9c5bf6c81810a4cfd.jpg","https://www.zhihu.com/question/67590846/answer/256069545","如何评价苏州「巨型大闸蟹」的建筑设计水平？","当然，一个学建筑的来看这个大闸蟹建筑，肯定会觉得啼笑皆非，这算个屁建筑，这么写实。\n" + "\n" +"但是对于一个外行人来说大闸蟹建筑也算挺新鲜稀奇的，毕竟世界第一的大闸蟹建筑～哇～建的真的就像大闸蟹一样～");
        homeList.add(homeInfo4);

        for (int i = 0 ; i < 50 ; i++){
            homeList.add(homeInfo1);
            homeList.add(homeInfo2);
            homeList.add(homeInfo3);
            homeList.add(homeInfo4);
        }

    }

    /**
     * 开始定位
     */
    private void startLocation() {
        //发起定位，设置具体城市位置
        gdLocation = GDLocation.getInstance();
        gdLocation.startLocation(new MyCallBack(this));
    }

    @OnClick(R.id.home_title_search_rl)
    public void search(){
        ToastUtil.showShort(getActivity(),"搜索");
        //跳转到搜索界面
        SearchActivity.startAction(getActivity());
    }

    @OnClick(R.id.home_title_city_ll)
    public void cityChoose(){
        ToastUtil.showShort(getActivity(),"城市选择");
        CityChooseActivity.startAction(getActivity());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        gdLocation.destroyLocation();
        //回收recycleView
        if(null != view){
            view.destroyDrawingCache();
            view = null;
        }
    }

    /**
     * 弱引用高德地图定位
     * 防止内存泄漏
     */
    public static class MyCallBack implements GDLocation.LocationCallBack{
        private final WeakReference<HomeFragment> weakReference;
        public MyCallBack(HomeFragment fragment){
            this.weakReference = new WeakReference<HomeFragment>(fragment);
        }
        @Override
        public void success(String result) {
            //设置定位成功结果的值
            weakReference.get().cityChoose.setText(result);
        }
        @Override
        public void failed(String berrorInfo) {
            ToastUtil.showShort(weakReference.get().getActivity(),"定位失败~请点击重试");
        }
    }

}
