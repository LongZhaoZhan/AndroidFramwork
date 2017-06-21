package com.zl.framwork.http;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.zl.framwork.baseframwork.MyBaseApplication;
import com.zl.framwork.utils.LogUtil;

/**
 * 作者：${zhaolong} on 2017/6/18 23:01
 * 邮箱：127124zhao@gmail.com
 */

public class VolleyUtil {

    public void sendVolleyStrPost(){

        RequestQueue requestQueue = Volley.newRequestQueue(MyBaseApplication.myApplication);
        StringRequest stringRequest = new StringRequest("http://www.baidu.com", new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                LogUtil.getInstance().i("volley请求成功=string结果=" + s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                LogUtil.getInstance().i("volley请求失败=string结果=" + volleyError.getMessage());
            }
        });
        requestQueue.add(stringRequest);
    }







}
