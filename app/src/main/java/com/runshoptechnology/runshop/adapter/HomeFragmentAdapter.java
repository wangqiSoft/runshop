package com.runshoptechnology.runshop.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.StringUtils;
import com.bumptech.glide.Glide;
import com.runshoptechnology.runshop.R;
import com.runshoptechnology.runshop.bean.BannerBean;
import com.runshoptechnology.runshop.bean.GoodsBean;
import com.runshoptechnology.runshop.bean.NewsBean;
import com.runshoptechnology.runshop.widget.MarqueeTextView;
import com.wangqiSoft.smartimageslider.Indicators.PagerIndicator;
import com.wangqiSoft.smartimageslider.SliderLayout;
import com.wangqiSoft.smartimageslider.SliderTypes.BaseSliderView;
import com.wangqiSoft.smartimageslider.SliderTypes.DefaultSliderView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
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
    private BaseSliderView.OnSliderClickListener bannerOnclickListener;


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
        if (viewType == TYPE_HEADER) {
            return new headerHolder(mLayoutInflater.inflate(R.layout.homefragment_headerview, parent, false));
        } else if (viewType == TYPE_CATEGORY) {
            return new headerHolder(mLayoutInflater.inflate(R.layout.homefragment_category, parent, false));
        } else if (viewType == TYPE_DISCOUNT) {
            return new headerHolder(mLayoutInflater.inflate(R.layout.homefragment_discount, parent, false));
        } else
            return new headerHolder(mLayoutInflater.inflate(R.layout.homefragment_normal, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof headerHolder) {
            ((headerHolder) holder).notice_tv.setText("恭喜张同学买一瓶送一瓶连续中奖8瓶");
            ((headerHolder) holder).sliderLayout.clearSlider();
            for (int i = 0; i < 5; i++) {
                DefaultSliderView sliderView = new DefaultSliderView(mAc);
                sliderView.image("http://7mno4h.com2.z0.glb.qiniucdn.com/5608f3b5Nc8d90151.jpg");
                sliderView.setScaleType(BaseSliderView.ScaleType.CenterCrop);
                sliderView.empty(R.mipmap.home_special_place_holder);
                if (null != bannerOnclickListener) {
                    sliderView.setOnSliderClickListener(bannerOnclickListener);
                }
                ((headerHolder) holder).sliderLayout.addSlider(sliderView);
            }
            ((headerHolder) holder).sliderLayout.setPresetTransformer(SliderLayout.Transformer.Default);
            ((headerHolder) holder).sliderLayout.setCustomIndicator(((headerHolder) holder).pagerIndicator);
            ((headerHolder) holder).pagerIndicator.onPageSelected(0);
        }
//        else if (holder instanceof ImageViewHolder) {
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
    public class headerHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.home_specital_topic_slider)
        SliderLayout sliderLayout;
        @BindView(R.id.main_notice_tv)
        MarqueeTextView notice_tv;
        @BindView(R.id.home_specital_topic_slider_indicator)
        PagerIndicator pagerIndicator;

        public headerHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * 分类的holder
     */
    public class categoryHolder extends RecyclerView.ViewHolder {
        public categoryHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * 折扣的holder
     */
    public class discountHolder extends RecyclerView.ViewHolder {
        public discountHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * 普通商品的holder
     */
    public class normalHolder extends RecyclerView.ViewHolder {
        public normalHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * 设置轮播图的点击事件
     *
     * @param bannerOnclick
     */
    public void setBannerOnclick(BaseSliderView.OnSliderClickListener bannerOnclick) {
        if (null != bannerOnclick)
            bannerOnclickListener = bannerOnclick;
    }

}
