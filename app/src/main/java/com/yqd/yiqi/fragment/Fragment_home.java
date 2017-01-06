package com.yqd.yiqi.fragment;

import android.view.View;

import com.finesdk.fragment.BaseFragment;
import com.finesdk.http.OkHttpUtil;
import com.finesdk.util.common.LogUtil;
import com.finesdk.view.RefreshListView;
import com.yqd.yiqi.Fragment_home_bean;
import com.yqd.yiqi.R;
import com.yqd.yiqi.adapter.Fragment_home_adapter;
import com.yqd.yiqi.entity.TitleAD;
import com.yqd.yiqi.entity.TitleADBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/1/4.
 */

public class Fragment_home extends BaseFragment {
    private RefreshListView refreshListView;
    private View header;
    private Fragment_home_adapter adapter;
    @Override
    protected int getResource() {
        return R.layout.fragment_home;
    }

    @Override
    protected void beforeInitView() {
        getHomeTitle();
    }


    private void getHomeTitle(){
        //首页广告
        List<OkHttpUtil.Param> params = new ArrayList();
        params.add(new OkHttpUtil.Param("action","getownerinfo"));
        params.add(new OkHttpUtil.Param("cityId","2"));
        OkHttpUtil.post("http://appapi.17house.com/AppManagerApi.php?version=1&action=getownerinfo&cityId=2&model=android",new OkHttpUtil.ResultCallback() {
            @Override
            public void onSuccess(Object response) {
                LogUtil.e("首页广告"+response.toString());
            }

            @Override
            public void onFailure(Exception e) {

            }
        },params);
        //首页数据
        params = new ArrayList();
        params.add(new OkHttpUtil.Param("action","getownerinfo"));
        params.add(new OkHttpUtil.Param("cityId","2"));
        OkHttpUtil.post("http://bbs.17house.com/motnt/index.php?a=appindex&c=index&id=1218226&uuid=86305803367590&pageSize=10&uid=1633055&m=misc&type=3&page=1&haspermission=yes&model=android&sessionToken=6U49kCYKE260RqvPqEdFsBGskNQStKhm&app_version=android_com.aiyiqi.galaxy_1.1",new OkHttpUtil.ResultCallback() {
            @Override
            public void onSuccess(Object response) {
                TitleADBean bean = (TitleADBean)response;
                TitleAD titleAD = (TitleAD) bean.getData();
                LogUtil.e("首页数据"+titleAD);
            }

            @Override
            public void onFailure(Exception e) {

            }
        },params);
    }
    @Override
    protected void initView(View rootView) {
        refreshListView = findViewByIdNoCast(R.id.refreshListView_home);
        header = View.inflate(getContext(),R.layout.refreshlistview_home_header,null);
    }

    @Override
    protected void initData() {
        List<Fragment_home_bean> list =new ArrayList<>();
        for (int i = 0 ; i<100;i++){
            Fragment_home_bean bean = new Fragment_home_bean();
            bean.setTv("数据"+i);
            list.add(bean);
        }
        adapter = new Fragment_home_adapter(list,getContext());
        refreshListView.addHeaderView(header);
        refreshListView.setAdapter(adapter);
        refreshListView.completeRefresh();
    }

    @Override
    public void onClick(View view) {

    }
}
