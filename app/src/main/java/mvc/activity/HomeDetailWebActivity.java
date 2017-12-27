package mvc.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.zl.framwork.R;
import com.zl.framwork.utils.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import mvc.BaseActivity;

/**
 * 日期：2017/12/15
 * 时间：8:43
 * zhaolong
 */

public class HomeDetailWebActivity extends BaseActivity {

    @BindView(R.id.home_detail_web)
    WebView homeDetailWeb;
    private String title;
    private String url;

    public static void startAction(Context context, String title, String url) {
        Intent intent = new Intent(context, HomeDetailWebActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_detail_web);
        ButterKnife.bind(this);
        initData();
        initWebView();

    }

    private void initData() {
        try {
            title = getIntent().getStringExtra("title");
            url = getIntent().getStringExtra("url");
        }catch (Exception e){
            LogUtil.getInstance().e("首页详情页标题+url获取异常="+e.getMessage());
        }
    }

    private void initWebView() {
        WebSettings webSettings = homeDetailWeb.getSettings();

    }


}
