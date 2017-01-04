package com.yqd.yiqi.fragment;

import android.view.View;

import com.finesdk.fragment.BaseFragment;
import com.finesdk.view.RefreshListView;
import com.yqd.yiqi.R;

/**
 * Created by admin on 2017/1/4.
 */

public class Fragment_home extends BaseFragment {
    private RefreshListView refreshListView;
    private View header;
    @Override
    protected int getResource() {
        return R.layout.fragment_home;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        refreshListView = findViewByIdNoCast(R.id.refreshListView_home);
        header = View.inflate(getContext(),R.layout.refreshlistview_home_header,null);
    }

    @Override
    protected void initData() {
        refreshListView.addHeaderView(header);

    }

    @Override
    public void onClick(View view) {

    }
}
