package com.runshoptechnology.runshop.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.runshoptechnology.runshop.R;
import com.runshoptechnology.runshop.base.BaseFragment;
import com.runshoptechnology.runshop.utils.StartActivityUtil;
import com.runshoptechnology.runshop.widget.TopBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import butterknife.BindView;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;

/**
 * @author Ryder
 * create at 2018/4/10 11:53
 * package name:com.runshoptechnology.runshop.fragment
 * description: 首页的fragment
 **/
public class HomeFragment extends BaseFragment {

    @BindView(R.id.home_fragment_topbar)
    TopBar homeTopbar;

    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        super.initView();
        homeTopbar.setLeftButtonNoPic();
        homeTopbar.setRightTextGone();
        homeTopbar.setSearchVisiable(true);
        homeTopbar.setSearchListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toasty.info(getContext(), "点击了搜索框").show();
            }
        });
//        refreshLayout.autoRefresh();//第一次进入触发自动刷新，演示效果
        refreshLayout.setEnableHeaderTranslationContent(false);
        refreshLayout.setPrimaryColorsId(R.color.blue_color, R.color.orange, R.color.yellow, R.color.green);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                    Toasty.info(getContext(),"下拉刷新").show();
            }
        });
    }

    @Override
    protected View setTopView() {
        return homeTopbar;
    }

    public HomeFragment() {
    }

    @OnClick()
    public void onClick() {
//        StartActivityUtil.GoLoginActivity(getActivity(), new Bundle());
    }


}
