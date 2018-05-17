package com.zhuye.ershoufang.data;


import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonListBean;
import com.zhuye.ershoufang.bean.LoginCode;
import com.zhuye.ershoufang.bean.SearchBean;
import com.zhuye.ershoufang.bean.UploadImgBean;
import com.zhuye.ershoufang.ui.activity.SearchActivity;

import java.io.File;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by Administrator on 2018/1/3 0003.
 */

public class CommonApi {

    public static CommonApi instance;

    private CommonApiService service;

    public CommonApi() {
        service = HttpUtils.getRetrofit(HttpUtils.getOkhttp()).create(CommonApiService.class);
    }



    public Observable<Base> getCode(String mobile){
        return service.getCode(mobile);
    }
//
//    public Observable<Base> logout(String token){
//        return service.logout(token);
//    }
//
    public static CommonApi getInstance() {
        if (instance == null)
            instance = new CommonApi();
        return instance;
    }
//    public Observable<ShenHeBean> message(String token){
//        return service.message(token);
//    }
//
//    public Observable<Code> forget_ms(String mobile,String password){
//        return service.forget_ms(mobile,password);
//    }
//    /**
//     * 获取验证码
//     * @param mobile
//     * @return
//     */
//
//    public Observable<Base> getCode(String mobile){
//        return service.getCode(mobile);
//    }
//
//    /**
//     * 手机号注册
//     * @param mobile
//     * @param password
//     * @param code
//     *
//     * @return
//     */
    public Observable<LoginCode> getRegeister(String mobile , String password, String zpassword, String  code ,int type){
        return service.getregister(mobile,password,zpassword,code,type);

        //getCode("").compose(getCode(""))
    }

    public Observable<LoginCode> login(String mobile, String password){
        return service.login(mobile,password);
    }

    private  void sub(Observable observable,BaseView baseView, int requestcode){
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new MyObserver<Base>(baseView,requestcode));
    }

    private  void sub(Observable observable,BaseView baseView, int requestcode,Boolean isShowLoding){
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new MyObserver<Base>(baseView,requestcode,isShowLoding));
    }
    public void ziliao(String token ,BaseView baseView, int requestcode){
        sub(service.ziliao(token),baseView,requestcode);;
    }

    public void modify_pass(String token ,String old_pass,String new_pass,BaseView baseView, int requestcode){
        sub(service.modify_pass(token,old_pass,new_pass),baseView,requestcode);;
    }

    public void bind_mobile(String token ,String mobile,String code,BaseView baseView, int requestcode){
        sub(service.bind_mobile(token,mobile,code),baseView,requestcode);;
    }

    public void edit_zl(String token ,String nickname,String face, int sex,BaseView baseView, int requestcode){
        sub(service.edit_zl(token,nickname,face,sex),baseView,requestcode);;
    }

    public void forget(String mobile ,String code,BaseView baseView, int requestcode){
        sub(service.forget(mobile,code),baseView,requestcode);;
    }

    public void set_passport(String mobile, String password,BaseView baseView, int requestcode){
        sub(service.set_passport(mobile,password),baseView,requestcode);
    }

    public void third_logint( int login_type, String openid,String nickname,String face,BaseView baseView, int requestcode){
        sub(service.third_logint(login_type,openid,nickname,face),baseView,requestcode);
    }

    public void my_question(String token,int page,BaseView baseView, int requestcode){
        sub(service.my_question(token,page),baseView,requestcode);
    }


    public void questionfabu(String token,String question, String intro,BaseView baseView, int requestcode){
        sub(service.questionfabu(token,question,intro),baseView,requestcode);
    }

    public void del_question(int question_id,BaseView baseView, int requestcode){
        sub(service.del_question(question_id),baseView,requestcode);
    }

    public void area(String city,BaseView baseView, int requestcode){
        sub(service.area(city),baseView,requestcode);
    }


    public void province(BaseView baseView, int requestcode,Boolean isShowLoding){
        sub(service.province(),baseView,requestcode,isShowLoding);
    }

    public void xiaji(String parent_id,BaseView baseView, int requestcode,Boolean isShowLoding){
        sub(service.xiaji(parent_id),baseView,requestcode,isShowLoding);
    }


    public void sellhouselists(String token,int page,int cate_id,BaseView baseView, int requestcode){
        sub(service.sellhouselists(token,page,cate_id),baseView,requestcode);
    }
    public void sijicity(BaseView baseView, int requestcode){
        sub(service.sijicity(),baseView,requestcode);
    }
    public void select(int cate_id,BaseView baseView, int requestcode,Boolean b){
        sub(service.select(cate_id),baseView,requestcode,b);
    }

    public void del_house(String token,int cate_id,BaseView baseView, int requestcode){
        sub(service.del_house(token,cate_id),baseView,requestcode);
    }

    public void img(String token,List<File> imageFileList,BaseView baseView, int requestcode){
        MultipartBody.Builder builder = new MultipartBody.Builder();

        for (File file : imageFileList) {
            // TODO: 16-4-2  这里为了简单起见，没有判断file的类型
            RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), file);
            builder.addFormDataPart("file", file.getName(), requestBody);
        }

        builder.setType(MultipartBody.FORM);
        MultipartBody multipartBody = builder.build();
//        Map<String, RequestBody> images = new HashMap<String, RequestBody>();
//        //一般参数
////        images.put("visit_type", RequestBody.create(AppConstant.MEDIA_TYPE_TEXT, visit_type));
////        images.put("demand", RequestBody.create(AppConstant.MEDIA_TYPE_TEXT, demand));
////        images.put("dept_id", RequestBody.create(AppConstant.MEDIA_TYPE_TEXT, depart_id));
////        images.put("visitor_id", RequestBody.create(AppConstant.MEDIA_TYPE_TEXT, visitor_id+""));
////        images.put("expect_date", RequestBody.create(AppConstant.MEDIA_TYPE_TEXT, expect_time));
////        images.put("expert_name", RequestBody.create(AppConstant.MEDIA_TYPE_TEXT, expert));
////        images.put("hosp_id", RequestBody.create(AppConstant.MEDIA_TYPE_TEXT, hosp_id));
////        images.put("content", RequestBody.create(AppConstant.MEDIA_TYPE_TEXT, history));
//        //文件（注意与上面的不同）
//        if(imageFileList != null && !imageFileList.isEmpty()) {
//            for (File file:imageFileList){
//                images.put("files\";filename=\""+file.getName(), RequestBody.create(AppConstant.MEDIA_TYPE_JPG, file));
//            }
//        }
        sub(service.img(token,multipartBody),baseView,requestcode);
    }

    public void view(int life_id,BaseView baseView, int requestcode){
        sub(service.view(life_id),baseView,requestcode);
    }

    public void chuzulists(String token,
                          int page,int cate_id,BaseView baseView, int requestcode){
        sub(service.chuzulists(token,page,cate_id),baseView,requestcode);
    }

    public void questionindex(int type,
                           int page,BaseView baseView, int requestcode){
        sub(service.questionindex(type,page),baseView,requestcode);
    }

    public void fabu( String token,  String title,
                      int cate_id,  String city_id,
                      String area_id,  String business_id,
                  String lng,  String lat,
                      String addr,  String xiaoqu,
                      String contact, String mobile,
                      String text1,  String text2,
                      String text3,  String text4,
                      String num1, String num2,
                      String num3, String num4,
                      String select1, String select2,
                      String select3,  String select4,
                      String select5,  String select6,
                      String fj_select5,  String fj_select6,
                     String detail,  String dd,
                      String photo,  String ph,
                      String pph, BaseView baseView, int requestcode){
        sub(service.fabu(token,title,cate_id,city_id
        ,area_id,business_id,lng,lat
        ,addr,xiaoqu,contact,mobile,text1,text2,text3,text4,num1,num2,num3,num4,select1,select2,select3,select4,select5,select6,fj_select5,fj_select6
        ,detail,dd,photo,ph,pph),baseView,requestcode);
    }

    public void edit( String life_id,  String title,
                      int cate_id,  int city_id,
                      int area_id,  int business_id,
                      String lng,  String lat,
                      String addr,  String xiaoqu,
                      String contact, String mobile,
                      String text1,  String text2,
                      String text3,  String text4,
                      String num1, String num2,
                      String num3, String num4,
                      String select1, String select2,
                      String select3,  String select4,
                      String select5,  String select6,
                      String fj_select5,  String fj_select6,
                      String detail,  String dd,
                      String photo,  String ph,
                      String pph, BaseView baseView, int requestcode){
        sub(service.edit(life_id,title,cate_id,city_id
                ,area_id,business_id,lng,lat
                ,addr,xiaoqu,contact,mobile,text1,text2,text3,text4,num1,num2,num3,num4,select1,select2,select3,select4,select5,select6,fj_select5,fj_select6
                ,detail,dd,photo,ph,pph),baseView,requestcode);
    }



    public void chuzufabu( String life_id,  String title,
                      int cate_id,  int city_id,
                      int area_id,  int business_id,
                      String lng,  String lat,
                      String addr,  String xiaoqu,
                      String contact, String mobile,
                      String text1,  String text2,
                      String text3,  String text4,
                      String num1, String num2,
                      String num3, String num4,
                      String select1, String select2,
                      String select3,  String select4,
                      String select5,  String select6,
                      String fj_select5,  String fj_select6,
                      String detail,  String dd,
                      String photo,  String yaoqiu
                     , BaseView baseView, int requestcode){
        sub(service.chuzufabu(life_id,title,cate_id,city_id
                ,area_id,business_id,lng,lat
                ,addr,xiaoqu,contact,mobile,text1,text2,text3,text4,num1,num2,num3,num4,select1,select2,select3,select4,select5,select6,fj_select5,fj_select6
                ,detail,dd,photo,yaoqiu),baseView,requestcode);
    }


    public void bidder_fabu(  String token
            , String city_id,
                             String area_id,String business_id,
                             String lng, String lat,
                             String addr,String num1,
                            String bz_money,String jia_money,
                             String pg_money, String qp_money,
                             String ys_time,String jp_time,
                             String start_time,String photo,
                             int cate_id, String xiaoqu, BaseView baseView, int requestcode){
        sub(service.bidder_fabu(token,city_id
                ,area_id,business_id,lng,lat
                ,addr,num1,bz_money,jia_money,pg_money,qp_money,ys_time,jp_time,start_time,
                photo,cate_id,xiaoqu),baseView,requestcode);
    }


    public void my_bidder(String token,int page,int type,BaseView baseView,int requestcode){
        sub(service.my_bidder(token,page,type),baseView,requestcode);
    }

    public void edit_view(String token,int id,BaseView baseView,int requestcode){
        sub(service.edit_view(token,id),baseView,requestcode);
    }

    public void sub_edit (  String token
            , String city_id,
                            String area_id,String business_id,
                              String lng, String lat,
                              String addr,String num1,
                              String bz_money,String jia_money,
                              String pg_money, String qp_money,
                              String ys_time,String jp_time,
                              String start_time,String photo,
                              int cate_id, String xiaoqu,int id, BaseView baseView, int requestcode){
        sub(service.sub_edit(token,city_id
                ,area_id,business_id,lng,lat
                ,addr,num1,bz_money,jia_money,pg_money,qp_money,ys_time,jp_time,start_time,
                photo,cate_id,xiaoqu,id),baseView,requestcode);
    }

    public void my_wtbidder(String token,int page,BaseView baseView,int requestcode){
        sub(service.my_wtbidder(token,page),baseView,requestcode);
    }

    public void xiaoqu(BaseView baseView,int requestcode,Boolean b){
        sub(service.xiaoqu(),baseView,requestcode,b);
    }
    public void bidder_bond(String token,int page,BaseView baseView,int requestcode){
        sub(service.bidder_bond(token,page),baseView,requestcode);
    }

    public void bidder_tx(String token,int page,BaseView baseView,int requestcode){
        sub(service.bidder_tx(token,page),baseView,requestcode);
    }

    public void my_mallbidder(String token,int page,BaseView baseView,int requestcode){
        sub(service.my_mallbidder(token,page),baseView,requestcode);
    }


    public void wmall_fabu( String token, String num1,
                            String xiaoqu,  String text1,
                            String text2,  String text3,
                        String num2,  String city_id,
                         String area_id,  String business_id, BaseView baseView, int requestcode){
        sub(service.wmall_fabu(token,num1,xiaoqu,text1,text2,text3,num2,city_id,area_id,business_id),baseView,requestcode);
    }

    /**
     *
     * @param token
     * @param num1
     * @param xiaoqu
     * @param text1
     * @param text2
     * @param text3
     * @param num2
     * @param num3
     * @param num4
     * @param select1
     * @param select2
     * @param select3
     * @param select4
     * @param city_id
     * @param area_id
     * @param business_id
     * @param contact
     * @param mobile
     * @param type
     * @param baseView
     * @param requestcode
     */
    public void qzu( String token,  String num1,
                     String xiaoqu,  String text1,
                     String text2,  String text3,

                            String num2, String num3,
                          String num4,
                           String select1, String select2,
                          String select3,  String select4,
                           String city_id,
                           String area_id,String business_id,
          String contact,
                           String mobile,  String type,String addr, BaseView baseView, int requestcode,Boolean isShowLoding){
        sub(service.qzu(token,num1,xiaoqu,text1,text2,text3,num2,num3,num4,select1,select2,select3,select4,city_id,area_id,business_id,contact
        ,mobile,type,addr),baseView,requestcode,isShowLoding);
    }

//
//    /**
//     * 登录--账户密码
//     * @param mobile
//     * @param password
//     * @return
//     */
//
//    public Observable<PhoneLoginCde> passLogin(String mobile , String password){
//        return service.passLogin(mobile,password,2);
//    }
//
//    /**
//     * 短信登录
//     * @param mobile
//     * @param code
//     * @return
//     */
//    public Observable<PhoneLoginCde> codelogin(String mobile ,String code){
//        return service.codelogin(mobile,code,2);
//    }
//
    /**
     * 图片上传
     * @param token
     * @param filepath 图片路径
     * @return
     */
    public Observable<UploadImgBean> upimg(String token , File filepath){
        File file = filepath;
        RequestBody bod = RequestBody.create(MediaType.parse("multipart/form-data"),token);
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("file", file.getName(), requestFile);
        return service.upimg(bod,body);
    }

    public Observable<UploadImgBean> upimg(String token , List<File> filepath){
        File file = filepath.get(0);
        RequestBody bod = RequestBody.create(MediaType.parse("multipart/form-data"),token);
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("file", file.getName(), requestFile);
        return service.upimg(bod,body);
    }
//
    public Observable<Base> user_data(String token,String true_name,String card
   , String card_img,int main_business,String scope_work,String license,String city_id,String shop){
        return service.user_data(token,true_name,card,card_img,main_business,scope_work,license,city_id,shop);
    }



    public CommonListBean<SearchBean> getSearchData(String content, int page, SearchActivity searchActivity, int first) {
        return null;
    }
//
//    public Observable<Code> forget_code(String mobile,String code){
//        return service.forget_code(mobile,code);
//    }
//    public Observable<Code> edit_info(String token,int province_id,int city_id,int start_city,int endcity_id){
//        return service.edit_info(token,province_id,city_id,start_city,endcity_id);
//    }
//
//    public Observable<MobileBean> getmobile(String token){
//        return service.getmobile(token);
//    }
//
//    public Observable<Code> new_mobile(String token,String mobile, String code){
//        return service.new_mobile(token,mobile,code);
//    }
//
//    public Observable<CitysBean> city(Integer type){
//        return service.city(type);
//    }
//
//    public Observable<MobileBean> server(String token){
//        return service.server(token);
//    }
//
//    public Observable<InvateBean> invate(String token){
//        return service.invate(token,1);
//    }
//
//    public Observable<XiaoFeiBean> consumption(String token, int page){
//        return service.consumption(token,page);
//    }
//
//    public Observable<RechargeBean> recharge(String token, int page){
//        return service.recharge(token,page);
//    }
//
//    public Observable<LiuYanBean> liuyanmessage(String token){
//        return service.liuyanmessage(token);
//    }
//
//    public Observable<SystemMessage> system_news(String token){
//        return service.system_news(token);
//    }
//
//    public Observable<PeiSongBean> goodtype(){
//        return service.goodtype();
//    }
//
//    public Observable<Base> fabu(String token,
//                                        List<String> type_id,Float weight,
//                                        List<String> car_require,String car_info,
//                                        Float price,int invoice,String mobile,List<String> hand_mode,String time,
//                                        int start_provinceid,int start_cityid,
//                                        int start_areaid,int end_provinceid,
//                                        int end_cityid,int end_areaid,
//                                        String remark,String typeid_bz){
//        return service.fabu(token,type_id,weight,car_require,car_info,price,invoice,mobile,hand_mode,time,start_provinceid,start_cityid,start_areaid,end_provinceid,end_cityid,end_areaid,remark,typeid_bz);
//    }
//
//
//    public Observable<PeiSongBean> commander_models(){
//        return service.commander_models();
//    }
//
//
//    public Observable<PeiSongBean> hade_model(){
//        return service.hade_model();
//    }
//
//    public Observable<DaTingBean> driver(int page,
//                                         Integer start_city, Integer end_city,
//                                         List<Integer> array){
//        return service.driver(page,start_city,end_city,array);
//    }
//
//
//    public Observable<PeiSongBean> select(){
//        return service.select();
//    }
//
//    public Observable<DriverDetailBean> driver_detail(String token, int uid, int car_id){
//        return service.driver_detail(token,uid,car_id);
//    }
//
//
//    public Observable<GoodsDeailBean> goods(int page,
//                                            int type, String token
//                                        ){
//        return service.goods(page,type,token);
//    }
//
//    public Observable<GoodsBean> good_detail(int good_id,
//                                             String token
//    ){
//        return service.good_detail(good_id,token);
//    }
//
//
//
//    public Observable<OrderBean> order(int page, String token, int type){
//        return service.order(page,token,type);
//    }
//
//    public Observable<BangDanBean> view_weight(int order_id, String token){
//        return service.view_weight(order_id,token);
//    }
//
//    public Observable<XingChengBean> order_process(int order_id, String token){
//        return service.order_process(order_id,token);
//    }
//
//    public Observable<Code> modify_price(int order_id, String token,float price){
//        return service.modify_price(order_id,token,price);
//    }
//
//    public Observable<Code> cancel_order(String token, int order_id){
//        return service.cancel_order(token,order_id,2);
//    }
//
//    public Observable<JiaoFouBean> jiaofou(String token){
//        return service.jiaofou(token);
//    }

    public void data(String token,BaseView baseView,int requestcode){
        sub(service.data(token),baseView,requestcode);
    }

    public void jinjirense(String token,BaseView baseView,int requestcode){
        sub(service.jinjirense(token),baseView,requestcode);
    }

    public void sub_set(String token,String shop_face,String shop,BaseView baseView,int requestcode){
        sub(service.sub_set(token,shop_face,shop),baseView,requestcode);
    }

    public void wpermit_fabu( String token, String num1,
                             String mobile,  String detail,
                              String code,

                             String city_id,
                              String area_id, String business_id
            ,  String contact,
                             String audit, BaseView baseView, int requestcode){
        sub(service.wpermit_fabu( token,  num1, mobile,   detail, code, city_id, area_id,  business_id,   contact, audit),baseView,requestcode);
    }

    public void dingwei(String city,String area,BaseView baseView,int requestcode){
        sub(service.dingwei(city,area),baseView,requestcode);
    }

    public void index( String cate_id,  String area_id,
                      int page,  String business_id,
                     String price1,  String price2,
                    String select1, String yonghu, BaseView baseView, int requestcode){
        sub(service.index( cate_id,  area_id, page, business_id, price1,   price2, select1,  yonghu),baseView,requestcode);
    }

    public void bidder_list( String cate_id,  String area_id,
                       int page, BaseView baseView, int requestcode){
        sub(service.bidder_list( cate_id,  area_id, page),baseView,requestcode);
    }

    public void bidder_detail( String id,  String token,
                             int page, BaseView baseView, int requestcode){
        sub(service.bidder_detail( id,  token),baseView,requestcode);
    }

    public void remind( String id,  String token,
                               int page, BaseView baseView, int requestcode){
        sub(service.remind( id,  token),baseView,requestcode);
    }
    public void cj_bidder( String id,  String token,
                        int page, BaseView baseView, int requestcode){
        sub(service.cj_bidder( id,  token),baseView,requestcode);
    }

    public void wsell_fabu(String token
            , String xiaoqu,
                          String num1,
                          String num2,
                            String text1,
                            String text2,
                           String text3,
                          String menpai,
                         String num3,
                          String num4,
                            String select3,
                          String select1,
                            String select2
            , String city_id,
                            String area_id, String business_id,
                            String contact, String mobile,
                            String audit,
                           String cate_id, String photo,String addr, BaseView baseView, int requestcode,Boolean isShowLoding){
        sub(service.wsell_fabu( token
                ,  xiaoqu, num1, num2, text1, text2, text3, menpai, num3, num4, select3, select1,
                 select2, city_id,
                 area_id, business_id,
                 contact, mobile,
                 audit,
                 cate_id, photo,addr),baseView,requestcode,isShowLoding);
    }


    /**
     *
     * @param token
     * @param page
     * @param cate_id 2卖房 3出租
     * @param baseView
     * @param requestcode
     */
    public void wtsell(   String token,
                        int page, int cate_id,BaseView baseView, int requestcode,Boolean is){
        sub(service.wtsell( token,page,cate_id),baseView,requestcode,is);
    }

    /**
     *
     * @param page
     * @param area_id 筛选区id
     * @param yjbi  价格 desc：又低到高 asc：由高到低
     * @param baseView
     * @param requestcode
     */
    public void agent_list( int page,  String area_id, String yjbi, BaseView baseView, int requestcode){
        sub(service.agent_list( page,area_id,yjbi),baseView,requestcode);
    }
    /**
     *
     * @param token
     * @param page
     * @param cate_id  1买房 4求租
     * @param baseView
     * @param requestcode
     */
    public void qtwt(String token, int page, int cate_id,BaseView baseView, int requestcode,Boolean is){
        sub(service.qtwt( token,page,cate_id),baseView,requestcode,is);
    }

    /**
     *  @param token
     * @param page
     * @param cate_id  5委托办证 6委托贷款
     * @param baseView
     * @param requestcode
     * @param b
     */
    public void wdaikuan(String token, int page, int cate_id, BaseView baseView, int requestcode, boolean b){
        sub(service.wdaikuan( token,page,cate_id),baseView,requestcode,b);
    }


    public void zhuangxiu( int page,BaseView baseView, int requestcode){
        sub(service.zhuangxiu( page),baseView,requestcode);
    }

    public void jiaju( int page,BaseView baseView, int requestcode){
        sub(service.jiaju( page),baseView,requestcode);
    }

    public void detail( int id,BaseView baseView, int requestcode){
        sub(service.detail( id),baseView,requestcode);
    }
    public void jiaju_shop( int id,int page,BaseView baseView, int requestcode){
        sub(service.jiaju_shop( id,page),baseView,requestcode);
    }
    public void pro_detail( int id,BaseView baseView, int requestcode){
        sub(service.pro_detail( id),baseView,requestcode);
    }

    public void mall_detail( String life_id,BaseView baseView, int requestcode){
        sub(service.mall_detail(life_id),baseView,requestcode);
    }
    public void phose_detail( String life_id,BaseView baseView, int requestcode){
        sub(service.phose_detail(life_id),baseView,requestcode);
    }
    public void daikuan_detail( String life_id,BaseView baseView, int requestcode){
        sub(service.daikuan_detail(life_id),baseView,requestcode);
    }

    public void jiajulists( String token,int page,BaseView baseView, int requestcode){
        sub(service.jiajulists(token,page),baseView,requestcode);
    }

    public void jiajuview( int id,BaseView baseView, int requestcode){
        sub(service.jiajuview(id),baseView,requestcode);
    }

    public void jiajufabu(String token,  String photo,  String title
            ,  String intro, BaseView baseView, int requestcode){
        sub(service.jiajufabu(token,photo,title,intro),baseView,requestcode);
    }

    public void jiajuedit(String token,  String photo,  String title
            ,  String intro,String id, BaseView baseView, int requestcode){
        sub(service.jiajuedit(token,photo,title,intro,id),baseView,requestcode);
    }

    public void jiajudelete( String id,BaseView baseView, int requestcode){
        sub(service.jiajudelete(id),baseView,requestcode);
    }

    public void esfabu( String token,
                        String title,
                         String addr,
                       String xiaoqu_id,
                        String contact, String mobile,
                        String text1, String text2,
                       String text3,String text4,
                         String num1, String num2,
                        String num3, String num4,
                         String select1, String select2,
                         String select3, String select4,
                        String select5,
                         String fj_select5,
                        String detail,
                      String dd,
                         String photo, String ph,
                    String pph,BaseView baseView, int requestcode){
        sub(service.esfabu(token,title,addr,xiaoqu_id,contact,mobile,text1,text2,text3,text4,num1,num2,num3,num4,select1,select2,select3,select4,select5,fj_select5,detail,dd,photo,ph,pph),baseView,requestcode);
    }


    public void view_list( String token,int page,BaseView baseView, int requestcode){
        sub(service.view_list(token,page),baseView,requestcode);
    }

    /**
     *
     * @param area_id
     * @param business_id
     * @param price1
     * @param price2
     * @param select  房源种类 1住宅 2别墅 3商业 4复式
     * @param baseView
     * @param requestcode
     */
    public void newhouse( int area_id,
                            int business_id,
                           int price1,
                            int price2,
                           int select,BaseView baseView, int requestcode){
        sub(service.newhouse(area_id,business_id,price1,price2,select),baseView,requestcode);
    }

    public void view_bm(  String token,
                         int view_id,
                          String mobile,
                        int code,BaseView baseView, int requestcode){
        sub(service.view_bm(token,view_id,mobile,code),baseView,requestcode);
    }


    public void view_detail( String id,BaseView baseView, int requestcode){
        sub(service.view_detail(id),baseView,requestcode);
    }


    public void fangchandata( String token,BaseView baseView, int requestcode){
        sub(service.fangchandata(token),baseView,requestcode);
    }
    public void newhouse_list( String token,int page,BaseView baseView, int requestcode){
        sub(service.newhouse_list(token,page),baseView,requestcode);
    }
    public void mianview_list( String token,int page,BaseView baseView, int requestcode){
        sub(service.mianview_list(token,page),baseView,requestcode);
    }
    public void newhousefabu( String token,
                               String city_id,
                               String area_id, String business_id,

                               String select,
                               String price,
                               String is_onsale,
                               String youhui,
                               String youhui_starttime,
                              String youhui_endtime,
                           String address,
                              String jdate,
                              String kdate,
                               String peizhi,
                              String lng,
                               String lat,
                               String huxing,
                               String xiaoguo,
                               String shijing,
                               String peitao,
                               String guihua,
                              String jiaotong,
                               String mianji,
                               String title,
                               String mobile,BaseView baseView, int requestcode){
        sub(service.newhousefabu( token, city_id, area_id, business_id, select, price, is_onsale, youhui, youhui_starttime,
                 youhui_endtime,
                 address,
                 jdate,
                 kdate,
                 peizhi,
                 lng,
                 lat,
                 huxing,
                 xiaoguo,
                 shijing,
                 peitao,
                 guihua,
                 jiaotong,
                 mianji,
                 title,
                 mobile),baseView,requestcode);
    }

    public void view_fabu(String token,
                          String loupan_id,
                           String photo,
                             String title,
                            String youlie,
                           String leixing,
                          String mobile,
                          String start_time,
                          String guize,
                          String sm,
                          String addr,
                           String youhui,BaseView baseView,int requestcode){sub(service.view_fabu( token, loupan_id, photo, title, youlie,
                 leixing,
                mobile,
                 start_time,
                 guize,
                sm,
                 addr,
                 youhui),baseView,requestcode);
    }

    public void homeindex(String area_id,BaseView baseView,int requestcode){
        sub(service.homeindex(area_id),baseView,requestcode);
    }


    public void view_loupan(String token,BaseView baseView,int requestcode){
        sub(service.view_loupan(token),baseView,requestcode);
    }

    /**
     *  1优惠活动 2刚需房
     * @param token
     * @param type
     * @param baseView
     * @param requestcode
     */
    public void activity(String token,int type,int page,BaseView baseView,int requestcode){
        sub(service.activity(token,type,page),baseView,requestcode);
    }


    /**
     *
     * @param area_id
     * @param business_id
     * @param price1
     * @param price2
     * @param select  房源种类 1住宅 2商铺 3写字楼 4工业厂房 （商铺新盘时为2 写字楼新盘为：3）
     * @param page
     * @param baseView
     * @param requestcode
     */
    public void indexnewhouse( String area_id,
                              String business_id,
                              int price1,
                              int price2,
                              int select,int page,BaseView baseView,int requestcode){
        sub(service.indexnewhouse( area_id,business_id, price1, price2, select,page),baseView,requestcode);
    }

    public void newhouse_edit(String token,String id,BaseView baseView,int requestcode){
        sub(service.newhouse_edit(token,id),baseView,requestcode);
    }

    public void newhouse_sub(String token,
                             String newhouse_id,
                             String city_id,
                             String area_id,
                            String business_id,
                              String select,
                              String price,
                            String is_onsale,
                              String youhui,
                              String youhui_starttime,
                           String youhui_endtime,
                            String address,
                     String jdate,
                            String kdate,
                             String peizhi,
                              String lng,
                             String lat,
                             String huxing,
                            String xiaoguo,
                          String shijing,
                             String peitao,
                              String guihua,
                             String jiaotong,
                             String mianji,
                              String title,
                             String mobile,
                             BaseView baseView,int requestcode){
        sub(service.newhouse_sub( token, newhouse_id, city_id, area_id, business_id, select,
                 price,
                 is_onsale,
                 youhui,
                 youhui_starttime,
                 youhui_endtime,
                 address,
                 jdate,
                 kdate,
                 peizhi,
                 lng,
                 lat,
                 huxing,
                 xiaoguo,
                 shijing,
                 peitao,
                 guihua,
                 jiaotong,
                 mianji,
                 title,
                 mobile),baseView,requestcode);
    }

    public void hview_view(String token,String id,BaseView baseView,int requestcode){
        sub(service.hview_view(token,id),baseView,requestcode);
    }


    public void view_sub(String token,
                          String loupan_id,
                          String photo,
                          String title,
                          String youlie,
                          String leixing,
                          String mobile,
                          String start_time,
                          String guize,
                          String sm,
                          String addr,
                          String youhui,
                          String id,
                         BaseView baseView,int requestcode){
        sub(service.view_sub( token, loupan_id, photo, title, youlie,
            leixing,
            mobile,
            start_time,
            guize,
            sm,
            addr,
            youhui,id),baseView,requestcode);
    }

    public void message(String token,BaseView baseView,int requestcode){
        sub(service.message(token),baseView,requestcode);
    }

    public void juan(BaseView baseView,int requestcode){
        sub(service.juan(),baseView,requestcode);
    }

    public void renzheng(String token,BaseView baseView,int requestcode,Boolean b){
        sub(service.renzheng(token),baseView,requestcode,b);
    }


    public void sub_data( String token,
                         String city_id,
                         String area_id,
                         String main_business,
                          String declaration,
                          String intro,
                         String year,
                          String company,
                          String xiaoqu,
                         String tese,
                         String yjbi,
                          String jingli,BaseView baseView,int requestcode,Boolean b){
        sub(service.sub_data( token,
                 city_id,
                 area_id,
                 main_business,
                declaration,
                 intro,
                 year,
                 company,

                 xiaoqu,
                 tese,
                 yjbi,
                 jingli),baseView,requestcode,b);
    }


    public void change_mobile( String mobile,
                               String code,BaseView baseView,int requestcode){
        sub(service.change_mobile(mobile,code),baseView,requestcode);
    }

}
