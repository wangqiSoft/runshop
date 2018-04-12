package com.runshoptechnology.runshop.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.runshoptechnology.runshop.R;
import com.runshoptechnology.runshop.bean.BannerBean;
import com.runshoptechnology.runshop.bean.GoodsBean;
import com.runshoptechnology.runshop.bean.NewsBean;

import java.util.List;

import butterknife.ButterKnife;


/**
 * @author Ryder
 * create at 2018/4/12 10:26
 * package name:com.runshoptechnology.runshop.adapter
 * description: 首页的fragment的adapter  第一行是header，显示轮播图跟滚动新闻；第二行是显示八大分类；第三行才之后才是真正的商品的显示
 **/
public class HomeFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<GoodsBean> goodsBeans;
    private List<BannerBean> bannerBeans;
    private List<NewsBean> newsBeans;
    private Context mcontext;
    private Activity mAc;
    private LayoutInflater mLayoutInflater;
    private int TYPE_HEADER = 0;//header
    private int TYPE_CATEGORY = 1;//分类
    private int TYPE_DISCOUNT = 2;//折扣优惠的商品列表
    private int TYPE_NOMAL = 3;//正常的商品信息

    public HomeFragmentAdapter(List<GoodsBean> goodsBeans, List<BannerBean> bannerBeans, List<NewsBean> newsBeans, Context context, Activity mAc) {
        this.goodsBeans = goodsBeans;
        this.bannerBeans = bannerBeans;
        this.newsBeans = newsBeans;
        this.mcontext = context;
        this.mAc = mAc;
        this.mLayoutInflater = LayoutInflater.from(this.mcontext);
    }

    /**
     * 设置数据源
     *
     * @param goodsBeans
     * @param bannerBeans
     * @param newsBeans
     */
    public void setData(List<GoodsBean> goodsBeans, List<BannerBean> bannerBeans, List<NewsBean> newsBeans) {
        this.goodsBeans = goodsBeans;
        this.bannerBeans = bannerBeans;
        this.newsBeans = newsBeans;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER){
            return new headerHolder(mLayoutInflater.inflate(R.layout.homefragment_headerview, parent, false));
        }else if (viewType == TYPE_CATEGORY){
            return new headerHolder(mLayoutInflater.inflate(R.layout.homefragment_headerview, parent, false));
        }else if (viewType == TYPE_DISCOUNT){
            return new headerHolder(mLayoutInflater.inflate(R.layout.homefragment_headerview, parent, false));
        }else  return new headerHolder(mLayoutInflater.inflate(R.layout.homefragment_headerview, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        if (holder instanceof headerHolder) {
//            ((TextViewHolder) holder).mTextView.setText(mTitles[position]);
//        } else if (holder instanceof ImageViewHolder) {
//            ((ImageViewHolder) holder).mTextView.setText(mTitles[position]);
//        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        } else if (position == 1) {
            return TYPE_CATEGORY;
        } else if (position == 2) {
            return TYPE_DISCOUNT;
        } else return TYPE_NOMAL;
    }

    @Override
    public int getItemCount() {
        if (null == goodsBeans || goodsBeans.size() <= 0) {
            return 2;
        } else {
            return goodsBeans.size() + 2;
        }
    }

    /**
     * 头部的holder
     */
    private class headerHolder extends RecyclerView.ViewHolder {

        public headerHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * 分类的holder
     */
    private class categoryHolder extends RecyclerView.ViewHolder {
        public categoryHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * 折扣的holder
     */
    private class discountHolder extends RecyclerView.ViewHolder {
        public discountHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * 普通商品的holder
     */
    private class normalHolder extends RecyclerView.ViewHolder {
        public normalHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
