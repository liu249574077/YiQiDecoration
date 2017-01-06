package com.yqd.yiqi.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.finesdk.adapter.BaseListAdpter;
import com.yqd.yiqi.Fragment_home_bean;
import com.yqd.yiqi.R;

import java.util.List;

/**
 * Created by admin on 2017/1/4.
 */

public class Fragment_home_adapter extends BaseListAdpter<Fragment_home_bean,Fragment_home_adapter.MyViewHolder> {


    public Fragment_home_adapter(Context context) {
        super(context);
    }

    public Fragment_home_adapter(List<Fragment_home_bean> fragment_home_been, Context context) {
        super(fragment_home_been, context);
    }

    @Override
    public int getResourceId() {
        return R.layout.item_fragment_home_adapter;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent) {
        MyViewHolder holder = new MyViewHolder();
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, Fragment_home_bean fragment_home_bean, int position) {
        holder.tv = findViewByIdNoCast(R.id.item_fragment_home_tv);
        holder.tv.setText(fragment_home_bean.getTv());
    }

    class MyViewHolder extends BaseListAdpter.ViewHolder {
        TextView tv;
    }
}




