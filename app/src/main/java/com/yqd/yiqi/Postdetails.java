package com.yqd.yiqi;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.finesdk.activity.BaseActivity;
import com.finesdk.http.OkHttpUtil;
import com.google.gson.Gson;
import com.yqd.yiqi.entity.PostdetailsEntity;

import org.w3c.dom.Text;

/**
 * Created by Administrator on 2017/1/10.
 */

public class Postdetails extends BaseActivity {
    private ImageView fallback_img;
    private SimpleDraweeView title_img;
    private TextView author_tv;
    private TextView type_tv;
    private TextView follow_tv;
    private TextView title_tv;
    private TextView from_tv;
    private TextView time_tv;
    private TextView content_tv;
    private String url;
    private PostdetailsEntity postdetails;
    private PostdetailsEntity.DataBean dataBean;
    @Override
    public int getContentViewId() {
        return R.layout.postdetails_activitity;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        fallback_img=findViewByIdNoCast(R.id.fallback_img);
        title_img=findViewByIdNoCast(R.id.title_img);
        author_tv=findViewByIdNoCast(R.id.author_tv);
        type_tv=findViewByIdNoCast(R.id.type_tv);
        follow_tv=findViewByIdNoCast(R.id.follow_tv);
        title_tv=findViewByIdNoCast(R.id.title_tv);
        from_tv=findViewByIdNoCast(R.id.from_tv);
        time_tv=findViewByIdNoCast(R.id.time_tv);
        content_tv=findViewByIdNoCast(R.id.content_tv);
    }

    @Override
    public void initData() {
        Intent intent=getIntent();
        url=intent.getStringExtra("url");
        dataBean=new PostdetailsEntity.DataBean();
        OkHttpUtil.get(url, new OkHttpUtil.ResultCallback() {
            @Override
            public void onSuccess(Object response) {
                Gson gson=new Gson();
                postdetails=gson.fromJson(response.toString(), PostdetailsEntity.class);
                dataBean=postdetails.getData();
                title_img.setImageURI(dataBean.getAvtUrl());
                author_tv.setText(dataBean.getAuthor());
                title_tv.setText(dataBean.getTitle());
                from_tv.setText(dataBean.getFname());
                time_tv.setText(dataBean.getDateline());
                content_tv.setText(dataBean.getMessage().get(0).getMsg());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
