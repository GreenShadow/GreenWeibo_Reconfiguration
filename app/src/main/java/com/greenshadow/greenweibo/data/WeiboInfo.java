package com.greenshadow.greenweibo.data;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class WeiboInfo {
    public long created_at;
    public long id;
    public String idstr;
    public long mid;

    public String text;
    public String source;
    public String thumbnail_pic;
    public String bmiddle_pic;
    public String original_pic;
    public String pic_ids; // multi pic id
    public GeoInfo geo;

    public String visible; // 微博的可见性，返回分组信息

    public boolean favorited;
    public boolean truncated; // 是否被截断

    public UserInfo user;
    public WeiboInfo retweeted_status; // origin Weibo
    public int reposts_count; // forward count
    public int comments_count;
    public int attitudes_count; // like count

    public String ad;

    public int mlevel; // un-supported

    public static WeiboInfo parse(String json) {
        WeiboInfo result = new WeiboInfo();
        JSONObject origin = JSONObject.parseObject(json);
        JSONArray weiboArray = origin.getJSONArray("statuses");

        return result;
    }
}
