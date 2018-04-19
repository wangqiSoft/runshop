package com.runshoptechnology.runshop.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.runshoptechnology.runshop.R;
import com.runshoptechnology.runshop.adapter.HomeFragmentAdapter;
import com.runshoptechnology.runshop.base.BaseFragment;
import com.runshoptechnology.runshop.bean.BannerBean;
import com.runshoptechnology.runshop.bean.GoodsBean;
import com.runshoptechnology.runshop.bean.NewsBean;
import com.runshoptechnology.runshop.utils.StartActivityUtil;
import com.runshoptechnology.runshop.widget.TopBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.wangqiSoft.smartimageslider.SliderTypes.BaseSliderView;

import java.util.ArrayList;
import java.util.List;

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

    @BindView(R.id.home_recy)
    RecyclerView homeRecy;

    private HomeFragmentAdapter homeFragmentAdapter;
    private List<GoodsBean> goodsBeans;
    private List<BannerBean> bannerBeans;
    private List<NewsBean> newsBeans;


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


        refreshLayout.setEnableHeaderTranslationContent(false);
        refreshLayout.setPrimaryColorsId(R.color.blue_color, R.color.orange, R.color.yellow, R.color.green);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                Toasty.info(getContext(), "下拉刷新").show();
                refreshLayout.finishRefresh(3000);
            }
        });
        goodsBeans = new ArrayList<>();
        bannerBeans = new ArrayList<>();
        newsBeans = new ArrayList<>();
        homeFragmentAdapter = new HomeFragmentAdapter(goodsBeans,bannerBeans,newsBeans,getContext(),getActivity());
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        homeRecy.setLayoutManager(manager);
        homeRecy.setAdapter(homeFragmentAdapter);
        homeFragmentAdapter.setBannerOnclick(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView baseSliderView) {
                Toasty.info(getContext(),"点击了轮播图 ，url = "+baseSliderView.getUrl());

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
