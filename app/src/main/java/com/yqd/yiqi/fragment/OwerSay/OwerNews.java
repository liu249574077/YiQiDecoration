package com.yqd.yiqi.fragment.OwerSay;

import android.view.View;
import android.widget.ListView;

import com.finesdk.fragment.BaseFragment;
import com.finesdk.http.OkHttpUtil;
import com.google.gson.Gson;
import com.yqd.yiqi.R;
import com.yqd.yiqi.adapter.NewsAdatpter;
import com.yqd.yiqi.entity.NewsEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/6.
 */

public class OwerNews extends BaseFragment {
    private NewsEntity newsEntity;
    private ListView news_list;
    private List<NewsEntity.DataBean> dataBeens;
    private NewsAdatpter newsAdatpter;
    @Override
    protected int getResource() {
        return R.layout.ower_news;
    }

    @Override
    protected void beforeInitView() {
        newsEntity=new NewsEntity();
        final Gson gson=new Gson();
        dataBeens=new ArrayList<>();
        newsAdatpter=new NewsAdatpter(getContext());
        OkHttpUtil.get("http://bbs.17house.com/motnt/index.php?a=allThread&c=forumThreadList&uuid=86305803367590&pageSize=10&cityName=%E6%88%90%E9%83%BD&m=forum&page=1&haspermission=yes&model=android&sessionToken=&app_version=android_com.aiyiqi.galaxy_1.1\n", new OkHttpUtil.ResultCallback() {
            @Override
            public void onSuccess(Object response) {
                newsEntity=gson.fromJson(response.toString(),NewsEntity.class);
                dataBeens=newsEntity.getData();
                newsAdatpter.setDataBeens(dataBeens);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }

    @Override
    protected void initView(View rootView) {
        news_list=findViewByIdNoCast(R.id.news_lv);
    }

    @Override
    protected void initData() {
        news_list.setAdapter(newsAdatpter);
    }

    @Override
    public void onClick(View v) {

    }
}
