package com.yqd.yiqi.fragment.OwerSay;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.finesdk.fragment.BaseFragment;
import com.finesdk.http.OkHttpUtil;
import com.google.gson.Gson;
import com.yqd.yiqi.R;
import com.yqd.yiqi.adapter.OwerAdaterList;
import com.yqd.yiqi.entity.EssenceEntity;

import java.util.List;


/**
 * Created by Administrator on 2017/1/6.
 */

public class OwerEssence extends BaseFragment {
    private ListView essence_list;
    private OkHttpUtil essence_http;
    private EssenceEntity essenceEntity;
    private List<EssenceEntity.DataBean> dataBeens;
    @Override
    protected int getResource() {
        return R.layout.ower_essence;
    }
    @Override
    protected void beforeInitView() {
        OkHttpUtil.get("http://bbs.17house.com/motnt/index.php?a=allThread&c=forumThreadList&mode=digest&uuid=86305803367590&pageSize=10&m=forum&page=1&haspermission=yes&model=android&sessionToken=&app_version=android_com.aiyiqi.galaxy_1.1", new OkHttpUtil.ResultCallback() {
            @Override
            public void onSuccess(Object response) {
                Gson gson=new Gson();
                essenceEntity=gson.fromJson(response.toString(), EssenceEntity.class);
                dataBeens=essenceEntity.getData();
                OwerAdaterList owerAdaterList=new OwerAdaterList(getContext());
                owerAdaterList.setDatas(dataBeens);
                essence_list.setAdapter(owerAdaterList);
                Log.d("tag",dataBeens.toString());
            }

            @Override
            public void onFailure(Exception e) {
                return;
            }
        });
    }

    @Override
    protected void initView(View rootView) {
        essence_list=findViewByIdNoCast(R.id.essence_lv);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {

    }
}
