package com.runshoptechnology.runshop.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Ryder
 * create at 2018/4/12 10:38
 * package name:com.runshoptechnology.runshop.bean
 * description: 商品的实体类
 **/
public class GoodsBean implements Parcelable {

    /**
     * id : 1
     * categoryId : 5
     * name : 联想（Lenovo）拯救者14.0英寸游戏本（i7-4720HQ 4G 1T硬盘 GTX960M 2G独显 FHD IPS屏 背光键盘）黑
     * imgUrl : http://7mno4h.com2.z0.glb.qiniucdn.com/s_recommend_55c1e8f7N4b99de71.jpg
     * price : 5979
     * sale : 8654
     */

    private int id;
    private int categoryId;
    private String name;
    private String imgUrl;
    private int price;
    private int sale;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "GoodsBean{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", price=" + price +
                ", sale=" + sale +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.categoryId);
        dest.writeString(this.name);
        dest.writeString(this.imgUrl);
        dest.writeInt(this.price);
        dest.writeInt(this.sale);
    }

    public GoodsBean() {
    }

    protected GoodsBean(Parcel in) {
        this.id = in.readInt();
        this.categoryId = in.readInt();
        this.name = in.readString();
        this.imgUrl = in.readString();
        this.price = in.readInt();
        this.sale = in.readInt();
    }

    public static final Creator<GoodsBean> CREATOR = new Creator<GoodsBean>() {
        @Override
        public GoodsBean createFromParcel(Parcel source) {
            return new GoodsBean(source);
        }

        @Override
        public GoodsBean[] newArray(int size) {
            return new GoodsBean[size];
        }
    };
}
