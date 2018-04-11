package com.runshoptechnology.runshop.fragment;

import android.view.View;

import com.runshoptechnology.runshop.R;
import com.runshoptechnology.runshop.base.BaseFragment;
import com.runshoptechnology.runshop.widget.TopBar;

import butterknife.BindView;

/**
 * @author Ryder
 * create at 2018/4/10 12:01
 * package name:com.runshoptechnology.runshop.fragment
 * description: 购物车的fragment
 **/
public class ChartFragment extends BaseFragment {
    @BindView(R.id.chart_topbar)
    TopBar chartTopbar;

    public ChartFragment() {
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_chart;
    }

    @Override
    protected void initView() {
        super.initView();
        chartTopbar.setLeftButtonNoPic();
        chartTopbar.setTitle(R.string.chart_name);
        chartTopbar.setRightTextGone();
    }

    @Override
    protected View setTopView() {
        return chartTopbar;
    }
}
