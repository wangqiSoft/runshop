package com.runshoptechnology.runshop.bean;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by WQ on 2017/4/7.
 */

public class RequestBean implements Serializable {

    //    private Map<String, String> header;
    private Map<String, Object> body = new HashMap<>();
    private String token;
    private String sign;
    private String devToken;

    public RequestBean() {
        sign = "";
        token = "";
        try {
//          sign = StringUtils.getBase64(StringUtils.encoderByMd5Two(token));
//          LogUtils.e("测试数据 == " + StringUtils.getBase64(StringUtils.encoderByMd5Two("{\"gender\":1,\"city\":\"石家庄市\",\"nickName\":\"呆齐\",\"birth\":\"2017-06-19\",\"id\":\"30\",\"avatar\":\"avatar/20170629/d519675376df41108b8fe901f66d122b.jpg\",\"rows\":10,\"blessing\":\"傻逼是汪齐！！\"}" + "JT704iysinqHYwy5")));
        } catch (Exception e) {
            devToken = "";
        }
    }

    /**
     * 添加请求数据
     *
     * @param key
     * @param value
     */
    public void addParams(String key, Object value) {
        if (body == null) {
            body = new HashMap<String, Object>();
        }
        if (key.equals("sign")) {
            sign = value + "";
            body.put("sign", sign);
        } else if (key.equals("token")) {
            token = "" + value;
            body.put("token", token);
        } else {
            body.put(key, value);
        }
//        if (!token.equals("")) {
//            JSONObject jsonObject = new JSONObject(body);
//            String content = jsonObject.toString() + token;
//            sign = StringUtils.getBase64(StringUtils.encoderByMd5Two(jsonObject.toString() + token));
//            LogUtils.e("测试数据 == " + content+"        " + sign);
//
//        }
    }


    //清除所有添加的参数
    public void clearAllParams() {
        if (null == body) {
            body = new HashMap<String, Object>();
        }
        if (body.size() > 0) {
            body.clear();
        }
    }

    //清除添加某个key的参数
    public void clearParam(String key) {
        if (null == body) {
            body = new HashMap<String, Object>();
        }
        if (body.size() > 0 && body.containsKey(key)) {
            body.remove(key);
        }
    }

    @Override
    public String toString() {
        return "RequestBean{" + token + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
