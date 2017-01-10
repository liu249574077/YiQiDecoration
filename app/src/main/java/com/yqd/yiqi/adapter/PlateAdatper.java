package com.yqd.yiqi.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yqd.yiqi.R;
import com.yqd.yiqi.entity.PlateEntity;

import java.util.List;


/**
 * Created by Administrator on 2017/1/10.
 */

public class PlateAdatper extends RecyclerView.Adapter<PlateAdatper.MyViewHolder> {

    private List<PlateEntity.DataBean> dataBeens;
    private Context context;

    public void setDataBeens(List<PlateEntity.DataBean> dataBeens) {
        this.dataBeens = dataBeens;
    }

    public PlateAdatper(Context context) {
        this.context = context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.platerecy_item,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PlateEntity.DataBean dataBean=new PlateEntity.DataBean();
        dataBean=dataBeens.get(position);
        holder.setdata(dataBean);
    }

    @Override
    public int getItemCount() {
        return dataBeens.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private SimpleDraweeView sdv;
        private TextView tv1;
        private TextView tv2;
        public MyViewHolder(View itemView) {
            super(itemView);
            sdv= (SimpleDraweeView) itemView.findViewById(R.id.recy_sdv);
            tv1= (TextView) itemView.findViewById(R.id.recy_tv);
            tv2= (TextView) itemView.findViewById(R.id.recy_tv2);
        }

        public void setdata(PlateEntity.DataBean data) {
            sdv.setImageURI(data.getIcon());
            tv1.setText(data.getTitle());
            tv2.setText("总贴："+data.getThreadsnum());
        }
    }
}
