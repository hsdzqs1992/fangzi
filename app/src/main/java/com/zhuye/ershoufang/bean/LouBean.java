package com.zhuye.ershoufang.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/15 0015.
 */

public class LouBean {
    /**
     * id : 楼盘id
     * title : 楼盘名称
     * uid : 用户id
     * city_id : 城市id
     * area_id : 区id
     * business_id : 街道id
     * price : 单价
     * kdate : 开盘时间
     * jdate : jdate
     * select : 房源种类 1住宅 2商铺 3写字楼 4工业厂房
     * mobile : 手机号
     * create_time : 时间戳
     * address : 详细地址
     * lng : 经度
     * lat : 纬度
     * is_onsale : 房源类型 1期房未收 2期房在售 3期房已售完
     * youhui : 优惠折扣
     * youhui_starttime : 优惠开始时
     * youhui_endtime : 优惠结束时间
     * peizhi : ["配套设置"]
     * mianji : 建筑面积
     * audit : 0
     * city_name : 市
     * area_name : 区
     * business_name : 街道
     * huxing : ["户型数组（\u201chuxing\u201d:户型 img:户型图 hx_area：户型面积 miaoshu：miaoshu）"]
     * xiaoguo : ["效果图地址","2017/06/01/thumb_592fe041d59f8.png","2017/06/01/thumb_592fe0471d535.png","2017/06/01/thumb_592fe03bbfb04.png"]
     * shijing : ["实景图地址","2017/05/24/thumb_5924f27eb0ab0.png"]
     * guihua : ["规划图地址","2017/05/23/thumb_59241f31df65f.png","2017/05/24/thumb_5924f274cd844.png"]
     * peitao : ["配套图"]
     * jiaotong : ["交通图"]
     */

    private String id;
    private String title;
    private String uid;
    private String city_id;
    private String area_id;
    private String business_id;
    private String price;
    private String kdate;
    private String jdate;
    private String select;
    private String mobile;
    private String create_time;
    private String address;
    private String lng;
    private String lat;
    private String is_onsale;
    private String youhui;
    private String youhui_starttime;
    private String youhui_endtime;
    private String mianji;
    private String audit;
    private String city_name;
    private String area_name;
    private String business_name;
    private List<String> peizhi;
    private List<String> huxing;
    private List<String> xiaoguo;
    private List<String> shijing;
    private List<String> guihua;
    private List<String> peitao;
    private List<String> jiaotong;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    public String getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(String business_id) {
        this.business_id = business_id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getKdate() {
        return kdate;
    }

    public void setKdate(String kdate) {
        this.kdate = kdate;
    }

    public String getJdate() {
        return jdate;
    }

    public void setJdate(String jdate) {
        this.jdate = jdate;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getIs_onsale() {
        return is_onsale;
    }

    public void setIs_onsale(String is_onsale) {
        this.is_onsale = is_onsale;
    }

    public String getYouhui() {
        return youhui;
    }

    public void setYouhui(String youhui) {
        this.youhui = youhui;
    }

    public String getYouhui_starttime() {
        return youhui_starttime;
    }

    public void setYouhui_starttime(String youhui_starttime) {
        this.youhui_starttime = youhui_starttime;
    }

    public String getYouhui_endtime() {
        return youhui_endtime;
    }

    public void setYouhui_endtime(String youhui_endtime) {
        this.youhui_endtime = youhui_endtime;
    }

    public String getMianji() {
        return mianji;
    }

    public void setMianji(String mianji) {
        this.mianji = mianji;
    }

    public String getAudit() {
        return audit;
    }

    public void setAudit(String audit) {
        this.audit = audit;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public List<String> getPeizhi() {
        return peizhi;
    }

    public void setPeizhi(List<String> peizhi) {
        this.peizhi = peizhi;
    }

    public List<String> getHuxing() {
        return huxing;
    }

    public void setHuxing(List<String> huxing) {
        this.huxing = huxing;
    }

    public List<String> getXiaoguo() {
        return xiaoguo;
    }

    public void setXiaoguo(List<String> xiaoguo) {
        this.xiaoguo = xiaoguo;
    }

    public List<String> getShijing() {
        return shijing;
    }

    public void setShijing(List<String> shijing) {
        this.shijing = shijing;
    }

    public List<String> getGuihua() {
        return guihua;
    }

    public void setGuihua(List<String> guihua) {
        this.guihua = guihua;
    }

    public List<String> getPeitao() {
        return peitao;
    }

    public void setPeitao(List<String> peitao) {
        this.peitao = peitao;
    }

    public List<String> getJiaotong() {
        return jiaotong;
    }

    public void setJiaotong(List<String> jiaotong) {
        this.jiaotong = jiaotong;
    }
}
