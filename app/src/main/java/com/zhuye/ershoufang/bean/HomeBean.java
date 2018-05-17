package com.zhuye.ershoufang.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/14 0014.
 */

public class HomeBean {
    private List<String> adv;
    private List<NewhouseBean> newhouse;
    private List<SellBean> sell;
    private List<AgentBean> agent;
    private List<RentingBean> renting;
    private List<LoveBean> love;

    public List<String> getAdv() {
        return adv;
    }

    public void setAdv(List<String> adv) {
        this.adv = adv;
    }

    public List<NewhouseBean> getNewhouse() {
        return newhouse;
    }

    public void setNewhouse(List<NewhouseBean> newhouse) {
        this.newhouse = newhouse;
    }

    public List<SellBean> getSell() {
        return sell;
    }

    public void setSell(List<SellBean> sell) {
        this.sell = sell;
    }

    public List<AgentBean> getAgent() {
        return agent;
    }

    public void setAgent(List<AgentBean> agent) {
        this.agent = agent;
    }

    public List<RentingBean> getRenting() {
        return renting;
    }

    public void setRenting(List<RentingBean> renting) {
        this.renting = renting;
    }

    public List<LoveBean> getLove() {
        return love;
    }

    public void setLove(List<LoveBean> love) {
        this.love = love;
    }

    public static class NewhouseBean {
        /**
         * id : 新房id
         * title : 标题
         * area_name : 区域
         * business_name : 街道
         * price : 单价
         * mianji : 面积
         * is_onsale : 房源类型 1期房未售 2期房在售 3期房已售完
         * select : 房源种类 1住宅 2商铺 3写字楼 4工业厂房
         * photo : ["图片","2017/07/11/thumb_59647e802b646.png","2017/07/11/thumb_59647ed72793d.png"]
         */

        private String id;
        private String title;
        private String area_name;
        private String business_name;
        private String price;
        private String mianji;
        private String is_onsale;
        private String select;
        private List<String> photo;

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

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getMianji() {
            return mianji;
        }

        public void setMianji(String mianji) {
            this.mianji = mianji;
        }

        public String getIs_onsale() {
            return is_onsale;
        }

        public void setIs_onsale(String is_onsale) {
            this.is_onsale = is_onsale;
        }

        public String getSelect() {
            return select;
        }

        public void setSelect(String select) {
            this.select = select;
        }

        public List<String> getPhoto() {
            return photo;
        }

        public void setPhoto(List<String> photo) {
            this.photo = photo;
        }
    }

    public static class SellBean {
        /**
         * life_id : 二手房id
         * photo : 图片
         * xiaoqu : 小区
         * title : 标题
         * num1 : 售价
         * num2 : 面积
         * area_name : 区
         * business_name : 街道
         * select1 : 房屋类型
         * select5 : ["房屋优劣"]
         */

        private String life_id;
        private String photo;
        private String xiaoqu;
        private String title;
        private String num1;
        private String num2;
        private String area_name;
        private String business_name;
        private String select1;
        private List<String> select5;

        public String getLife_id() {
            return life_id;
        }

        public void setLife_id(String life_id) {
            this.life_id = life_id;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getXiaoqu() {
            return xiaoqu;
        }

        public void setXiaoqu(String xiaoqu) {
            this.xiaoqu = xiaoqu;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getNum1() {
            return num1;
        }

        public void setNum1(String num1) {
            this.num1 = num1;
        }

        public String getNum2() {
            return num2;
        }

        public void setNum2(String num2) {
            this.num2 = num2;
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

        public String getSelect1() {
            return select1;
        }

        public void setSelect1(String select1) {
            this.select1 = select1;
        }

        public List<String> getSelect5() {
            return select5;
        }

        public void setSelect5(List<String> select5) {
            this.select5 = select5;
        }
    }

    public static class AgentBean {
        /**
         * user_id : 经纪人id
         * nickname : 经纪人昵称
         * face : 头像
         * score : 评分
         * area_name : 区
         * business_name : 街道
         */

        private String user_id;
        private String nickname;
        private String face;
        private String score;
        private String area_name;
        private String business_name;

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
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
    }

    public static class RentingBean {
        /**
         * life_id : 租房id
         * photo : 图片
         * xiaoqu : 小区
         * title : 标题
         * num1 : 租金
         * num2 : 面积
         * area_name : 区
         * business_name : 街道
         * select1 : 房屋类型
         * select5 : ["配套设置","空调"]
         */

        private String life_id;
        private String photo;
        private String xiaoqu;
        private String title;
        private String num1;
        private String num2;
        private String area_name;
        private String business_name;
        private String select1;
        private List<String> select5;

        public String getLife_id() {
            return life_id;
        }

        public void setLife_id(String life_id) {
            this.life_id = life_id;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getXiaoqu() {
            return xiaoqu;
        }

        public void setXiaoqu(String xiaoqu) {
            this.xiaoqu = xiaoqu;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getNum1() {
            return num1;
        }

        public void setNum1(String num1) {
            this.num1 = num1;
        }

        public String getNum2() {
            return num2;
        }

        public void setNum2(String num2) {
            this.num2 = num2;
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

        public String getSelect1() {
            return select1;
        }

        public void setSelect1(String select1) {
            this.select1 = select1;
        }

        public List<String> getSelect5() {
            return select5;
        }

        public void setSelect5(List<String> select5) {
            this.select5 = select5;
        }
    }

    public static class LoveBean {
        /**
         * life_id : 猜你喜欢-出租商铺id
         * title : 名称
         * photo : 图片
         * num1 : 租金
         * num2 : 面积
         * area_name : 区
         * business_name : 街道
         * select1 : 状态
         * select5 : ["配套设置","货梯","停车位"]
         */

        private String life_id;
        private String title;
        private String photo;
        private String num1;
        private String num2;
        private String area_name;
        private String business_name;
        private String select1;
        private List<String> select5;

        public String getLife_id() {
            return life_id;
        }

        public void setLife_id(String life_id) {
            this.life_id = life_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getNum1() {
            return num1;
        }

        public void setNum1(String num1) {
            this.num1 = num1;
        }

        public String getNum2() {
            return num2;
        }

        public void setNum2(String num2) {
            this.num2 = num2;
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

        public String getSelect1() {
            return select1;
        }

        public void setSelect1(String select1) {
            this.select1 = select1;
        }

        public List<String> getSelect5() {
            return select5;
        }

        public void setSelect5(List<String> select5) {
            this.select5 = select5;
        }
    }
}
