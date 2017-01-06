package com.yqd.yiqi.fragment;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.finesdk.fragment.BaseFragment;
import com.yqd.yiqi.R;
import com.yqd.yiqi.adapter.OwerAdapter;
import com.yqd.yiqi.fragment.OwerSay.OwerEssence;
import com.yqd.yiqi.fragment.OwerSay.OwerNews;
import com.yqd.yiqi.fragment.OwerSay.OwerPlate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/1/4.
 */

public class Fragment_community extends BaseFragment {
    private ImageView search_imager;
    private List<Fragment> fragments;
    private List<Integer> strings;
    private TabLayout ower_tabLayout;
    private ViewPager ower_viewPager;
    private OwerAdapter owerAdapter;
    @Override
    protected int getResource() {
        return R.layout.fragment_community;
    }

    @Override
    protected void beforeInitView() {
        fragments=new ArrayList<>();
        strings=new ArrayList<>();
        fragments.add(new OwerEssence());
        fragments.add(new OwerNews());
        fragments.add(new OwerPlate());
        strings.add(R.string.essence);
        strings.add(R.string.news);
        strings.add(R.string.plate);
    }

    @Override
    protected void initView(View rootView) {
        ower_tabLayout=findViewByIdNoCast(R.id.tablayout_title);
        ower_viewPager=findViewByIdNoCast(R.id.viewpager_ower);
        search_imager=findViewByIdNoCast(R.id.image_search);

    }

    @Override
    protected void initData() {
        owerAdapter=new OwerAdapter(this.getChildFragmentManager());
        owerAdapter.setFragments(fragments);
        ower_viewPager.setAdapter(owerAdapter);
        ower_tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        ower_tabLayout.setupWithViewPager(ower_viewPager,false);
        for (int i = 0; i <fragments.size() ; i++) {
            ower_tabLayout.getTabAt(i).setText(strings.get(i));
        }
    }

    @Override
    public void onClick(View view) {

    }
}
