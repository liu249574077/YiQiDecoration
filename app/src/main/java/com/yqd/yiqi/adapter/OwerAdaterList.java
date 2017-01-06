package com.yqd.yiqi.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.finesdk.imageload.ImageLoader;
import com.finesdk.util.common.LogUtil;
import com.yqd.yiqi.R;
import com.yqd.yiqi.adapter.ViewHolder.ViewHolder;
import com.yqd.yiqi.entity.EssenceEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/1/6.
 */

public class OwerAdaterList extends BaseAdapter implements View.OnClickListener {
    private Context context;
    private List<EssenceEntity.DataBean> datas;
    private String type=null;
    private ImageLoader imageLoader;
    public void setDatas(List<EssenceEntity.DataBean> datas) {
        this.datas = datas;
    }

    public OwerAdaterList(Context context) {
        this.context = context;
        imageLoader=ImageLoader.getInstance();
    }

    @Override
    public int getCount() {
        return datas==null?0:datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas==null?null:datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        //if (convertView==null){
            convertView=View.inflate(context, R.layout.ower_listitem,null);
            viewHolder=new ViewHolder();
            viewHolder.image_title= (SimpleDraweeView) convertView.findViewById(R.id.image_title);
            viewHolder.tv_name= (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.tv_attribute= (TextView) convertView.findViewById(R.id.tv_attribute);
            viewHolder.tv_title= (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.tv_type= (TextView) convertView.findViewById(R.id.tv_type);
            viewHolder.image_main= (SimpleDraweeView) convertView.findViewById(R.id.image_main);
            viewHolder.tv_from= (TextView) convertView.findViewById(R.id.tv_from);
            viewHolder.tv_time= (TextView) convertView.findViewById(R.id.tv_time);
            viewHolder.image_zan= (ImageView) convertView.findViewById(R.id.image_zan);
            viewHolder.tv_msg= (TextView) convertView.findViewById(R.id.tv_msg);
            viewHolder.image_share= (ImageView) convertView.findViewById(R.id.image_share);
            convertView.setTag(viewHolder);
       /* }
        else {
            viewHolder= (ViewHolder) convertView.getTag();
        }*/
//        viewHolder.image_title= (ImageView) convertView.findViewById(R.id.image_title);
        viewHolder.tv_name.setText(datas.get(position).getAuthor());

        switch (datas.get(position).getHouseInfo().getLayout()){
            case 1:
                type="一室一厅";
                break;
            case 2:
                type="两室一厅";
                break;
            case 3:
                type="三室一厅";
                break;
            case 4:
                type="三室两厅";
                break;
        }
        viewHolder.tv_attribute.setText(type+datas.get(position).getHouseInfo().getArea()+"平");
        viewHolder.tv_title.setText(datas.get(position).getSubject());
        viewHolder.tv_type.setText(datas.get(position).getTags().get(0).getTagname());
        LogUtil.d("tag",viewHolder.image_main.toString());
        if (datas.get(position).getAttachments()!=null){
        imageLoader.disPlayImage(viewHolder.image_main,datas.get(position).getAttachments().get(0));}
        else {
            imageLoader.disPlayImage(viewHolder.image_main,null);
        }
        viewHolder.tv_from.setText(datas.get(position).getFname());
        viewHolder.tv_time.setText(datas.get(position).getDateline());
        viewHolder.tv_msg.setText(datas.get(position).getReplies());
//        viewHolder.image_share= (ImageView) convertView.findViewById(R.id.image_share);
       imageLoader.disPlayImage(viewHolder.image_title,datas.get(position).getAvtUrl());
        return convertView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            
        }
    }
}
