package com.runshoptechnology.runshop.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Ryder
 * create at 2018/4/12 10:32
 * package name:com.runshoptechnology.runshop.bean
 * description: 新闻的实体类
 **/
public class NewsBean implements Parcelable {
    /**
     * id : 1
     * content : 恭喜张同学买一瓶送一瓶连续中奖8瓶
     */

    private int id;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "NewsBean{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.content);
    }

    public NewsBean() {
    }

    protected NewsBean(Parcel in) {
        this.id = in.readInt();
        this.content = in.readString();
    }

    public static final Creator<NewsBean> CREATOR = new Creator<NewsBean>() {
        @Override
        public NewsBean createFromParcel(Parcel source) {
            return new NewsBean(source);
        }

        @Override
        public NewsBean[] newArray(int size) {
            return new NewsBean[size];
        }
    };
}
