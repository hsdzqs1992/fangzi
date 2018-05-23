package com.zhuye.ershoufang.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/21 0021.
 */

public class XinFangDetailBean {
    /**
     * id : 新房id
     * uid : 用户id
     * title : 标题
     * city_id : 城市id
     * area_id : 区域id
     * business_id : 街道id
     * price : 单价
     * kdate : 开盘时间
     * jdate : 交房时建
     * select : 房源种类 1住宅 2商铺 3写字楼 4工业厂房
     * mobile : 手机号
     * create_time : 创建时间戳
     * address : 详细地址
     * lng : 经度
     * lat : 纬度
     * is_onsale : 房源类型 1期房未收 2期房在售 3期房已售完
     * youhui : 优惠
     * youhui_starttime : 优惠开始时间
     * youhui_endtime : 优惠结束时间
     * peizhi : 配置
     * mianji : 面积
     * audit : 1
     * area_name : 区名
     * business_name : 街道
     * img : 图片
     * huxing : [{"huxing":"户型","img":"图片","hx_area":"面积","miaoshu":"描述"}]
     * photo : [{"img":"图片","type":"类型 1效果图 2实景图 3规划图 4配套图 5交通图","count":"总数"},{"img":"2017/05/23/thumb_59241f31df65f.png","type":"3","count":"3"},{"img":"2017/05/23/thumb_59241f4099c7a.png","type":"2","count":"2"},{"img":"2017/05/24/thumb_5924f274cd844.png","type":"3","count":"3"},{"img":"2017/05/24/thumb_5924f27eb0ab0.png","type":"2","count":"2"},{"img":"2017/07/17/thumb_596c8af081761.jpg","type":"1","count":"4"},{"img":"2017/06/01/thumb_592fe041d59f8.png","type":"1","count":"4"},{"img":"2017/06/01/thumb_592fe0471d535.png","type":"1","count":"4"},{"img":"2017/06/01/thumb_592fe03bbfb04.png","type":"1","count":"4"}]
     * pinglun_count : 评论总数
     * pinglun : [{"comment":"评论内容","face":"头像","nickname":"昵称"},{"comment":"楼盘很不错，环境优美，适合居住。。","face":null,"nickname":null},{"comment":"楼盘很不错，环境优美，适合居住。。","face":null,"nickname":null}]
     */

    private String id;
    private String uid;
    private String title;
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
    private String peizhi;
    private String mianji;
    private String audit;
    private String area_name;
    private String business_name;
    private String img;
    private String pinglun_count;
    private List<HuxingBean> huxing;
    private List<PhotoBean> photo;
    private List<PinglunBean> pinglun;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getPeizhi() {
        return peizhi;
    }

    public void setPeizhi(String peizhi) {
        this.peizhi = peizhi;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPinglun_count() {
        return pinglun_count;
    }

    public void setPinglun_count(String pinglun_count) {
        this.pinglun_count = pinglun_count;
    }

    public List<HuxingBean> getHuxing() {
        return huxing;
    }

    public void setHuxing(List<HuxingBean> huxing) {
        this.huxing = huxing;
    }

    public List<PhotoBean> getPhoto() {
        return photo;
    }

    public void setPhoto(List<PhotoBean> photo) {
        this.photo = photo;
    }

    public List<PinglunBean> getPinglun() {
        return pinglun;
    }

    public void setPinglun(List<PinglunBean> pinglun) {
        this.pinglun = pinglun;
    }

    public static class HuxingBean {
        /**
         * huxing : 户型
         * img : 图片
         * hx_area : 面积
         * miaoshu : 描述
         */

        private String huxing;
        private String img;
        private String hx_area;
        private String miaoshu;

        public String getHuxing() {
            return huxing;
        }

        public void setHuxing(String huxing) {
            this.huxing = huxing;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getHx_area() {
            return hx_area;
        }

        public void setHx_area(String hx_area) {
            this.hx_area = hx_area;
        }

        public String getMiaoshu() {
            return miaoshu;
        }

        public void setMiaoshu(String miaoshu) {
            this.miaoshu = miaoshu;
        }
    }

    public static class PhotoBean {
        /**
         * img : 图片
         * type : 类型 1效果图 2实景图 3规划图 4配套图 5交通图
         * count : 总数
         */

        private String img;
        private String type;
        private String count;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }
    }

    public static class PinglunBean {
        /**
         * comment : 评论内容
         * face : 头像
         * nickname : 昵称
         */

        private String comment;
        private String face;
        private String nickname;

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }
    }
}
