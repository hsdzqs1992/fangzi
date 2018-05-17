package com.zhuye.ershoufang.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/10 0010.
 */

public class KanFangDetailBean {
    /**
     * id : 看房id
     * user_id : 用户id
     * loupan_id : 楼盘id
     * photo : 图片
     * title : 标题
     * youlie : ["优劣"]
     * leixing : ["类型"]
     * mobile : 联系方式
     * start_time : 开始时间戳
     * guize : 规则
     * sm : 免责声明
     * addr : 地址
     * youhui : null
     * create_time : 创建时间
     * count : 报名人数
     * start_date : 开始日期
     * loupan : {"newhouse_id":"新房id","title":"新房标题","price":"单价","area":"区","business":"街道","mianji":"面积","select":"房源种类 1住宅 2别墅 3商业 4复式","is_onsale":"房源类型 1期房未收 2期房在售 3期房已售完","img":"图片"}
     */

    private String id;
    private String user_id;
    private String loupan_id;
    private String photo;
    private String title;
    private String mobile;
    private String start_time;
    private String guize;
    private String sm;
    private String addr;
    private Object youhui;
    private String create_time;
    private String count;
    private String start_date;
    private LoupanBean loupan;
    private List<String> youlie;
    private List<String> leixing;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getLoupan_id() {
        return loupan_id;
    }

    public void setLoupan_id(String loupan_id) {
        this.loupan_id = loupan_id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getGuize() {
        return guize;
    }

    public void setGuize(String guize) {
        this.guize = guize;
    }

    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Object getYouhui() {
        return youhui;
    }

    public void setYouhui(Object youhui) {
        this.youhui = youhui;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public LoupanBean getLoupan() {
        return loupan;
    }

    public void setLoupan(LoupanBean loupan) {
        this.loupan = loupan;
    }

    public List<String> getYoulie() {
        return youlie;
    }

    public void setYoulie(List<String> youlie) {
        this.youlie = youlie;
    }

    public List<String> getLeixing() {
        return leixing;
    }

    public void setLeixing(List<String> leixing) {
        this.leixing = leixing;
    }

    public static class LoupanBean {
        /**
         * newhouse_id : 新房id
         * title : 新房标题
         * price : 单价
         * area : 区
         * business : 街道
         * mianji : 面积
         * select : 房源种类 1住宅 2别墅 3商业 4复式
         * is_onsale : 房源类型 1期房未收 2期房在售 3期房已售完
         * img : 图片
         */

        private String newhouse_id;
        private String title;
        private String price;
        private String area;
        private String business;
        private String mianji;
        private String select;
        private String is_onsale;
        private String img;

        public String getNewhouse_id() {
            return newhouse_id;
        }

        public void setNewhouse_id(String newhouse_id) {
            this.newhouse_id = newhouse_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getBusiness() {
            return business;
        }

        public void setBusiness(String business) {
            this.business = business;
        }

        public String getMianji() {
            return mianji;
        }

        public void setMianji(String mianji) {
            this.mianji = mianji;
        }

        public String getSelect() {
            return select;
        }

        public void setSelect(String select) {
            this.select = select;
        }

        public String getIs_onsale() {
            return is_onsale;
        }

        public void setIs_onsale(String is_onsale) {
            this.is_onsale = is_onsale;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }
    }
}
