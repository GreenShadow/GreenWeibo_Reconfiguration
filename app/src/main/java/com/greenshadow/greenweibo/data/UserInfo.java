package com.greenshadow.greenweibo.data;

public class UserInfo {
    // User basic info
    public long id = -1;
    public String idstr = ""; // string for id
    public String created_at = "";
    public String screen_name = ""; // user nick name
    public String name = ""; // alias
    public String description = "";
    public String gender = ""; // user sex : m - Male; f - Female; n - Unknown
    public String lang = ""; // user's current language
    public int online_status = -1; // 0 - offline; 1 - online
    public WeiboInfo status = null; // the latest Weibo from this user

    // Avatar
    public String profile_image_url; // avatar (China) 50 * 50
    public String avatar_large; // avatar 180 * 180
    public String avatar_hd; // avatar hd

    // Verified account
    public boolean verified; // is verified user
    public boolean verified_reason;

    // User location
    public int province; // province id
    public int city; // city id
    public String location;
    public boolean geo_enabled;

    // About count
    public int followers_count; // 粉丝数
    public int friends_count; // 关注数
    public int statuses_count; // 微博数
    public int bi_followers_count; // 互粉数
    public int favourites_count;

    // About me
    public boolean follow_me;
    public int remark;

    // Other link or account
    public String url; // user blog link
    public String profile_url; // user profile link
    public String domain; // user custom url
    public String weihao; // 微号

    // Privacy
    public boolean allow_all_act_msg; // allow private messages from every one
    public boolean allow_all_comment; // allow comments from every one

    // Un-supported filed
    public boolean following; // un-supported
    public int verified_type; // un-supported
}
