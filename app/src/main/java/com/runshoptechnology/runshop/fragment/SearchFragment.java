package com.runshoptechnology.runshop.fragment;

import android.view.View;

import com.runshoptechnology.runshop.R;
import com.runshoptechnology.runshop.base.BaseFragment;
import com.runshoptechnology.runshop.widget.TopBar;

import butterknife.BindView;

/**
 * @author Ryder
 * create at 2018/4/10 11:59
 * package name:com.runshoptechnology.runshop.fragment
 * description: 搜索的fragment
 **/
public class SearchFragment extends BaseFragment {
    @BindView(R.id.fragment_search_topbar)
    TopBar searchTopbar;

    public SearchFragment() {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_search;
    }

    @Override
    protected void initView() {
        super.initView();
        searchTopbar.setLeftButtonNoPic();
        searchTopbar.setTitle(R.string.search_name);
        searchTopbar.setRightTextGone();
    }

    @Override
    protected View setTopView() {
        return searchTopbar;
    }
}
