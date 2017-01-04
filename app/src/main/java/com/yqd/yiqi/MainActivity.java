package com.yqd.yiqi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.finesdk.activity.BaseActivity;
import com.finesdk.util.display.DrawableUtil;
import com.yqd.yiqi.fragment.Fragment_community;
import com.yqd.yiqi.fragment.Fragment_discoverty;
import com.yqd.yiqi.fragment.Fragment_home;
import com.yqd.yiqi.fragment.Fragment_my;

public class MainActivity extends BaseActivity {

    private LinearLayout shouye;
    private TextView tv_shouye;
    private LinearLayout xiaoxi;
    private TextView tv_xiaoxi;
    private LinearLayout wode;
    private TextView tv_wode;
    private LinearLayout yezhushuo;
    private TextView tv_yezhushuo;
    private int current_item;
    private int[] select_box;
    private int[] normal_box;
    private TextView[] tv_box;
    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        shouye = findViewByIdNoCast(R.id.shouye);
        xiaoxi = findViewByIdNoCast(R.id.xiaoxi);
        yezhushuo = findViewByIdNoCast(R.id.yezhushuo);
        wode = findViewByIdNoCast(R.id.wode);

        tv_shouye = findViewByIdNoCast(R.id.tv_shouye);
        tv_xiaoxi = findViewByIdNoCast(R.id.tv_xiaoxi);
        tv_yezhushuo = findViewByIdNoCast(R.id.tv_yezhushuo);
        tv_wode = findViewByIdNoCast(R.id.tv_wode);
    }

    @Override
    public void initData() {
        setOnClick(shouye,xiaoxi,yezhushuo,wode);
        select_box = new int[]{R.drawable.main_tab_home_selected,R.drawable.main_tab_discovery_selected,R.drawable.main_tab_msg_selected,R.drawable.main_tab_my_selected};
        normal_box = new int[]{R.drawable.main_tab_home_normal,R.drawable.main_tab_discovery_normal,R.drawable.main_tab_msg_normal,R.drawable.main_tab_my_normal};
        tv_box = new TextView[]{tv_shouye,tv_yezhushuo,tv_xiaoxi,tv_wode};
        current_item = 0;
        setFragment(0);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.shouye:
                if (current_item == 0){
                    return;
                }else {
                    DrawableUtil.drawableTop(this,tv_shouye,select_box[0]);
                    DrawableUtil.drawableTop(this,tv_box[current_item],normal_box[current_item]);
                    setFragment(0);
                    current_item = 0;
                }
            break;

            case R.id.yezhushuo:
                if (current_item == 1){
                    return;
                }else {
                    DrawableUtil.drawableTop(this,tv_yezhushuo,select_box[1]);
                    DrawableUtil.drawableTop(this,tv_box[current_item],normal_box[current_item]);
                    setFragment(1);
                    current_item = 1;
                }
                break;

            case R.id.xiaoxi:
                if (current_item == 2){
                    return;
                }else {
                    DrawableUtil.drawableTop(this,tv_xiaoxi,select_box[2]);
                    DrawableUtil.drawableTop(this,tv_box[current_item],normal_box[current_item]);
                    setFragment(2);
                    current_item = 2;
                }
                break;

            case R.id.wode:
                if (current_item == 3){
                    return;
                }else {
                    DrawableUtil.drawableTop(this,tv_wode,select_box[3]);
                    DrawableUtil.drawableTop(this,tv_box[current_item],normal_box[current_item]);
                    setFragment(3);
                    current_item = 3;
                }
                break;

        }
    }
    private Fragment fragment;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private void setFragment(int position){
        if (position == 0){
            fragment = new Fragment_home();
        }else if(position == 1){
            fragment = new Fragment_community();
        }else if(position == 2){
            fragment = new Fragment_discoverty();
        }else if(position == 3){
            fragment = new Fragment_my();
        }

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.fragment,fragment);
        ft.commit();
    }
}
