package com.yqd.yiqi.fragment.OwerSay;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.finesdk.fragment.BaseFragment;
import com.finesdk.http.OkHttpUtil;
import com.finesdk.util.common.LogUtil;
import com.google.gson.Gson;
import com.yqd.yiqi.R;
import com.yqd.yiqi.adapter.PlateAdatper;
import com.yqd.yiqi.entity.PlateEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/6.
 */

public class OwerPlate extends BaseFragment {
    private TextView plate_forum;
    private RecyclerView paltearea_recy;
    private PlateEntity entity;
    private List<List<PlateEntity.DataBean>> dataBeens;
    private List<PlateEntity.DataBean> dataBeen_list1;
    private PlateAdatper plateAdatper;
    private RecyclerView paltother_recy;
    private List<PlateEntity.DataBean> dataBeen_list2;
    private PlateAdatper plateAdatper1;
    @Override
    protected int getResource() {
        return R.layout.ower_plate;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        plate_forum=findViewByIdNoCast(R.id.plate_forum);
        paltearea_recy=findViewByIdNoCast(R.id.paltearea_recy);
        paltother_recy=findViewByIdNoCast(R.id.paltother_recy);

    }

    @Override
    protected void initData() {
        entity=new PlateEntity();
        dataBeens=new ArrayList<>();
        dataBeen_list1=new ArrayList<>();
        plateAdatper=new PlateAdatper(getContext());
        dataBeen_list2=new ArrayList<>();
        plateAdatper1=new PlateAdatper(getContext());
        OkHttpUtil.get("http://bbs.17house.com/motnt/index.php?a=miscForum&uuid=86305803367590&cityName=%E6%88%90%E9%83%BD&m=misc&haspermission=yes&cityId=2&model=android&sessionToken=&app_version=android_com.aiyiqi.galaxy_1.1", new OkHttpUtil.ResultCallback() {
            @Override
            public void onSuccess(Object response) {
                String str=(String)response;
                Gson gson=new Gson();
                entity=gson.fromJson(response.toString(),PlateEntity.class);
                dataBeens=entity.getData();
                dataBeen_list1=dataBeens.get(0);
                plate_forum.setText(dataBeen_list1.get(0).getTitle().substring(0,1)+"装修总论坛");
                GridLayoutManager gl=new GridLayoutManager(getContext(),2);
                paltearea_recy.setLayoutManager(gl);
                plateAdatper.setDataBeens(dataBeen_list1);
                paltearea_recy.setAdapter(plateAdatper);
                GridLayoutManager gl1=new GridLayoutManager(getContext(),2);
                paltother_recy.setLayoutManager(gl1);
                dataBeen_list2=dataBeens.get(1);
                plateAdatper1.setDataBeens(dataBeen_list2);
                paltother_recy.setAdapter(plateAdatper1);

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
