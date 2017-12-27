package mvc.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.zl.framwork.R;
import com.zl.framwork.utils.LogUtil;
import com.zl.framwork.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mvc.BaseActivity;

/**
 * 作者：zhaolong
 * 日期：2017/10/27
 * 邮箱：longzhao2@gmail.com
 * 电话：15209866017
 * TODO=> 系统全局搜索界面
 */

public class SearchActivity extends BaseActivity{

    public static void startAction(Context context){
        context.startActivity(new Intent(context,SearchActivity.class));
    }

    @BindView(R.id.search_et)
    public EditText searchEt;
    @BindView(R.id.search_parent)
    public LinearLayout parentView;
    @BindView(R.id.search_content_rv)
    public RecyclerView searchContentRv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sys_search);
        ButterKnife.bind(this);
        //设置view
        initEtView();
    }

    /**
     * 初始化搜索框
     */
    private void initEtView() {
        searchEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    /**
     * 初始化RecyclerView
     */
    private void initRv(){

    }

    @OnClick(R.id.search_cancle_tv)
    public void cancle(){
//        finish();
        Snackbar snackbar = Snackbar.make(parentView,"是否对删除的内容进行撤回？",Snackbar.LENGTH_LONG);
        snackbar.setActionTextColor(getResources().getColor(R.color.colorPrimary));
        View v = snackbar.getView();
        v.setBackgroundResource(R.color.touming);
        snackbar.setAction("撤回", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showShort(SearchActivity.this,"撤回成功!");
                    }
                })
                .addCallback(new Snackbar.Callback(){
                    @Override
                    public void onShown(Snackbar sb) {
                        super.onShown(sb);
                        LogUtil.getInstance().i("已经展示出来了~~~~");
                    }
                    @Override
                    public void onDismissed(Snackbar transientBottomBar, int event) {
                        super.onDismissed(transientBottomBar, event);
                        ToastUtil.showShort(SearchActivity.this,"已关闭!");
                    }
                });

        snackbar.show();
    }

    /**
     * 根据搜素条件
     * 发送搜索报文
     * 返回结果，更新adapter
     * @param condition
     */
    private void searchByCondition(String condition){



    }


}
