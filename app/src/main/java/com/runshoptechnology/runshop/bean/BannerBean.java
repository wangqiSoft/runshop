package com.runshoptechnology.runshop.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Ryder
 * create at 2018/4/12 10:30
 * package name:com.runshoptechnology.runshop.bean
 * description: 轮播图的实体类
 **/
public class BannerBean implements Parcelable{

    /**
     * id : 1
     * name : 音箱狂欢
     * imgUrl : http://7mno4h.com2.z0.glb.qiniucdn.com/5608f3b5Nc8d90151.jpg
     * type : 1
     */

    private int id;
    private String name;
    private String imgUrl;
    private int type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BannerBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.imgUrl);
        dest.writeInt(this.type);
    }

    public BannerBean() {
    }

    protected BannerBean(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.imgUrl = in.readString();
        this.type = in.readInt();
    }

    public static final Creator<BannerBean> CREATOR = new Creator<BannerBean>() {
        @Override
        public BannerBean createFromParcel(Parcel source) {
            return new BannerBean(source);
        }

        @Override
        public BannerBean[] newArray(int size) {
            return new BannerBean[size];
        }
    };
}
