package com.zhuye.ershoufang.data;


import com.zhuye.ershoufang.bean.AnswerBean;
import com.zhuye.ershoufang.bean.AnswerBean2;
import com.zhuye.ershoufang.bean.AreaBean;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.BidderDetailBean;
import com.zhuye.ershoufang.bean.ChanPinBean;
import com.zhuye.ershoufang.bean.ChuZuListBean;
import com.zhuye.ershoufang.bean.CityBean;
import com.zhuye.ershoufang.bean.Common2Bean;
import com.zhuye.ershoufang.bean.Common3Bean;
import com.zhuye.ershoufang.bean.Common5Bean;
import com.zhuye.ershoufang.bean.CommonBean;
import com.zhuye.ershoufang.bean.CommonListBean;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.DaiBean;
import com.zhuye.ershoufang.bean.FaBuListBean;
import com.zhuye.ershoufang.bean.FaBuListBean2;
import com.zhuye.ershoufang.bean.FaBuSelectBean;
import com.zhuye.ershoufang.bean.FanZiDetail;
import com.zhuye.ershoufang.bean.FangChanBean;
import com.zhuye.ershoufang.bean.FangZiBean;
import com.zhuye.ershoufang.bean.HomeBean;
import com.zhuye.ershoufang.bean.HomeJinBean;
import com.zhuye.ershoufang.bean.JiaJuDetailBean;
import com.zhuye.ershoufang.bean.JingJiRSettingBean;
import com.zhuye.ershoufang.bean.JingJiRenBean;
import com.zhuye.ershoufang.bean.KanFangBean;
import com.zhuye.ershoufang.bean.KanFangDetailBean;
import com.zhuye.ershoufang.bean.LiuPaiBean;
import com.zhuye.ershoufang.bean.LoginCode;
import com.zhuye.ershoufang.bean.LoginCodeBean;
import com.zhuye.ershoufang.bean.LouBean;
import com.zhuye.ershoufang.bean.LouPanBean;
import com.zhuye.ershoufang.bean.LouPanBeans;
import com.zhuye.ershoufang.bean.MaiChuBean;
import com.zhuye.ershoufang.bean.MeKanFangBean;
import com.zhuye.ershoufang.bean.MianBean;
import com.zhuye.ershoufang.bean.MybidderBean;
import com.zhuye.ershoufang.bean.PaiMaiBean;
import com.zhuye.ershoufang.bean.PersonBean;
import com.zhuye.ershoufang.bean.PersonInfoBean;
import com.zhuye.ershoufang.bean.QiJianDianBean;
import com.zhuye.ershoufang.bean.QiTeBean;
import com.zhuye.ershoufang.bean.QuBean;
import com.zhuye.ershoufang.bean.UploadImgBean;
import com.zhuye.ershoufang.bean.WenDaBean;
import com.zhuye.ershoufang.bean.WenDadetailBean;
import com.zhuye.ershoufang.bean.XiaoQuBean;
import com.zhuye.ershoufang.bean.XiaoQuBean2;
import com.zhuye.ershoufang.bean.XiaoXiBean;
import com.zhuye.ershoufang.bean.XinFangBean;
import com.zhuye.ershoufang.bean.XinFangDetailBean;
import com.zhuye.ershoufang.bean.ZhiDingBean;
import com.zhuye.ershoufang.bean.ZhuangxiuJiaJuBean;
import com.zhuye.ershoufang.bean.ZiLiaoBean;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;

import static com.zhuye.ershoufang.data.NetWorkUrl.QUESTIONINDEX;

/**
 * Created by Administrator on 2018/1/3 0003.
 */

public interface CommonApiService {




//    /**
//     * 退登
//     * @param token
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("index.php/home/passport/logout")
//    Observable<Base>  logout(@Field("token") String token);
//
    /**
     * 订单详情
     * @param token
     * @param order_id
     * @return
     */

     //todo  泛型的处理
    @Deprecated
    @FormUrlEncoded
    @POST(NetWorkUrl.BASE)
     <T> Observable<T>  order_detail(@Field("token") String token, @Field("order_id") int order_id);



//
    @FormUrlEncoded
    @POST("index.php/App/passport/code")
    Observable<Base> getCode(@Field("mobile") String mobile);


//  0普通用户 1经纪人 2房产商 3家居商 4装修商
    @FormUrlEncoded
    @POST(NetWorkUrl.REGEIST)
    Observable<LoginCode>  getregister(@Field("mobile") String mobile
            , @Field("password") String password, @Field("zpassword") String zpassword, @Field("code") String code, @Field("type") int type);

    /**
     * 提交资料
     * @param token
     * @param true_name 真实姓名
     * @param card 身份证号
     * @param card_img 身份证图片位置
     * @param main_business 经纪人-主营业务 0住宅 1商业地产
     * @param scope_work 经纪人--工作范围
     * @param license 营业执照--开发资质证书图片位置
     * @return
     */
    @FormUrlEncoded
    @POST("index.php/App/passport/user_data")
    Observable<Base>  user_data(@Field("token") String token
            , @Field("true_name") String true_name
            , @Field("card") String card
            , @Field("card_img") String card_img
            , @Field("main_business") int main_business
            , @Field("scope_work") String scope_work
            , @Field("license") String license
            , @Field("city_id") String city_id
            , @Field("shop") String shop);


    @FormUrlEncoded
    @POST(QUESTIONINDEX)
    Observable<CommonListBean<WenDaBean>>  questionindex(@Field("type") int type
            , @Field("page") int page);


    @FormUrlEncoded
    @POST(NetWorkUrl.SUB_ANSWER)
    Observable<Base>  sub_answer(@Field("question_id") int question_id
            , @Field("content") String content
            , @Field("token") String token
    );

    /**
     *
     * @param login_type  1表示微信 2表示qq
     * @param openid
     * @param nickname
     * @param face
     * @return
     */
    @FormUrlEncoded
    @POST(NetWorkUrl.THIRD_LOGINT)
    Observable<LoginCodeBean>  third_logint(@Field("login_type") int login_type
            , @Field("openid") String openid
            , @Field("nickname") String nickname
            , @Field("face") String face
          );

//     Observable<Base>

    @FormUrlEncoded
    @POST("index.php/App/passport/login")
    Observable<LoginCode> login(@Field("mobile") String mobile, @Field("password") String password);


    @FormUrlEncoded
    @POST(NetWorkUrl.MY_QUESTION)
    Observable<CommonListBean<WenDaBean>> my_question(@Field("token") String token, @Field("page") int page);

    /**
     * 我的问答--发布
     * @param token
     * @param question 	问题
     * @param intro 	问题描述
     * @return
     */
    @FormUrlEncoded
    @POST(NetWorkUrl.QUESTIONFABU)
    Observable<Base> questionfabu(@Field("token") String token, @Field("question") String question,
                                           @Field("intro") String intro);

    @FormUrlEncoded
    @POST(NetWorkUrl.DEL_QUESTION)
    Observable<Base> del_question(@Field("question_id") int question_id);

    @FormUrlEncoded
    @POST(NetWorkUrl.QUESTIONDETAIL)
    Observable<CommonObjectBean<WenDadetailBean>> questiondetail(@Field("question_id") int question_id);

    @FormUrlEncoded
    @POST(NetWorkUrl.ANSWER)
    Observable<CommonObjectBean<AnswerBean<AnswerBean2>>> answer(@Field("question_id") int question_id
    , @Field("page") int page);

    @FormUrlEncoded
    @POST(NetWorkUrl.ZILIAO)
    Observable<ZiLiaoBean> ziliao(@Field("token") String token);


    @FormUrlEncoded
    @POST(NetWorkUrl.AREA)
    Observable<AreaBean> area(@Field("city") String city);

    @FormUrlEncoded
    @POST(NetWorkUrl.MODIFY_PASS)
    Observable<Base> modify_pass(@Field("token") String token,
                                 @Field("old_pass") String old_pass,
                                 @Field("new_pass") String new_pass);

    @FormUrlEncoded
    @POST(NetWorkUrl.BIND_MOBILE)
    Observable<Base> bind_mobile(@Field("token") String token,
                                 @Field("mobile") String mobile,
                                 @Field("code") String code);

    /**
     *
     * @param token
     * @param nickname
     * @param face
     * @param sex 1男 2女
     * @return
     */
    @FormUrlEncoded
    @POST(NetWorkUrl.EDIT_ZL)
    Observable<Base> edit_zl(@Field("token") String token,
                                 @Field("nickname") String nickname,
                                 @Field("face") String face,
                              @Field("sex") int sex);


    @FormUrlEncoded
    @POST(NetWorkUrl.FORGET)
    Observable<Base> forget(@Field("mobile") String mobile, @Field("code") String code);

    @FormUrlEncoded
    @POST(NetWorkUrl.SET_PASSPORT)
    Observable<Base> set_passport(@Field("mobile") String mobile, @Field("password") String password);


    /**
     *
     * @param token
     * @param page
     * @param cate_id /3:二手房 6：写字楼 7：商铺 8：工业厂房
     * @return
     */
    @FormUrlEncoded
    @POST(NetWorkUrl.SELLHOUSELISTS)
    Observable<FaBuListBean> sellhouselists(@Field("token") String token, @Field("page") int page,
                                            @Field("cate_id") int cate_id);
    @FormUrlEncoded
    @POST(NetWorkUrl.SELLHOUSELISTS)
    Observable<CommonListBean<FaBuListBean2>> sellhouselists2(@Field("token") String token, @Field("page") int page,
                                                              @Field("cate_id") int cate_id);

    @GET(NetWorkUrl.SIJICITY)
    Observable<Base> sijicity();


    @GET(NetWorkUrl.PROVINCE)
    Observable<CityBean> province();

    @GET(NetWorkUrl.XIAOQU)
    Observable<CommonListBean<XiaoQuBean>> xiaoqu();

    @FormUrlEncoded
    @POST(NetWorkUrl.XIAJI)
    Observable<CityBean> xiaji(
            @Field("parent_id") String parent_id);

    @Multipart
    @POST(NetWorkUrl.IMG)
    Observable<ResponseBody> img(
            @Path("token") String token,
            @PartMap() MultipartBody file);

    /**
     * 3：卖房--住宅 6：卖房--写字楼 7：卖房--商铺 8：卖房--工业厂房 4：出租--住宅 12：出租--写字楼 13：出租--商铺 10：出租--工业厂房
     * @param cate_id
     * @return
     */
    @FormUrlEncoded
    @POST(NetWorkUrl.SELECT)
    Observable<FaBuSelectBean> select(
            @Field("cate_id") int cate_id);


    @FormUrlEncoded
    @POST(NetWorkUrl.VIEW)
    Observable<FanZiDetail> view(
            @Field("life_id") int life_id);


    @FormUrlEncoded
    @POST(NetWorkUrl.DEL_HOUSE)
    Observable<Base> del_house( @Field("token") String token,
            @Field("life_id") int life_id);


    @FormUrlEncoded
    @POST(NetWorkUrl.CHUZULISTS)
    Observable<ChuZuListBean> chuzulists(@Field("token") String token,
                                        @Field("page") int page, @Field("cate_id") int cate_id);



    @FormUrlEncoded
    @POST(NetWorkUrl.FABU)
    Observable<Base> fabu(@Field("token") String token, @Field("title") String title,
                                  @Field("cate_id") int cate_id,@Field("city_id") String city_id,
                                  @Field("area_id") String area_id,@Field("business_id") String business_id,
                                  @Field("lng") String lng,@Field("lat") String lat,

                                  @Field("addr") String addr,@Field("xiaoqu") String xiaoqu,
                                  @Field("contact") String contact,@Field("mobile") String mobile,

                                  @Field("text1") String text1,@Field("text2") String text2,

                                  @Field("text3") String text3,@Field("text4") String text4,//

                                  @Field("num1") String num1,@Field("num2") String num2,
                                  @Field("num3") String num3,@Field("num4") String num4,

                                  @Field("select1") String select1,@Field("select2") String select2,
                                  @Field("select3") String select3,@Field("select4") String select4,
                                  @Field("select5") String select5,@Field("select6") String select6,

                                  @Field("fj_select5") String fj_select5,@Field("fj_select6") String fj_select6,

                                  @Field("detail") String detail,
                                    @Field("dd") String dd,//
                                  @Field("photo") String photo,
                                    @Field("ph") String ph,//
                                  @Field("pph") String pph//
    );


    @FormUrlEncoded
    @POST(NetWorkUrl.ESFABU)
    Observable<Base> esfabu(@Field("token") String token,
                            @Field("title") String title,
                            @Field("addr") String addr,
                            @Field("xiaoqu_id") String xiaoqu_id,
                          @Field("contact") String contact,@Field("mobile") String mobile,
                            @Field("text1") String text1,@Field("text2") String text2,
                          @Field("text3") String text3,@Field("text4") String text4,
                            @Field("num1") String num1,@Field("num2") String num2,
                          @Field("num3") String num3,@Field("num4") String num4,
                            @Field("select1") String select1,@Field("select2") String select2,
                          @Field("select3") String select3,@Field("select4") String select4,
                          @Field("select5") String select5,
                            @Field("fj_select5") String fj_select5,
                            @Field("detail") String detail,
                            @Field("dd") String dd,
                          @Field("photo") String photo,@Field("ph") String ph,
                          @Field("pph") String pph);





    @FormUrlEncoded
    @POST(NetWorkUrl.CZFABU)
    Observable<Base> czfabu(@Field("token") String token,
                            @Field("title") String title,
                            @Field("addr") String addr,
                            @Field("xiaoqu_id") String xiaoqu_id,
                            @Field("contact") String contact,
                            @Field("mobile") String mobile,
                            @Field("text1") String text1,@Field("text2") String text2,

                            @Field("text3") String text3,@Field("text4") String text4,//
                            @Field("num1") String num1,@Field("num2") String num2,

                            @Field("num3") String num3,@Field("num4") String num4,//

                            @Field("select1") String select1,@Field("select2") String select2,
                            @Field("select3") String select3,@Field("select4") String select4,
                            @Field("select5") String select5,


                            @Field("fj_select5") String fj_select5,
                            @Field("detail") String detail,

                            @Field("photo") String photo,
                            @Field("yaoqiu") String yaoqiu
                            );





    @FormUrlEncoded
    @POST(NetWorkUrl.EDIT)
    Observable<Base> edit(@Field("life_id") String life_id, @Field("title") String title,
                                  @Field("cate_id") int cate_id,@Field("city_id") int city_id,
                                  @Field("area_id") int area_id,@Field("business_id") int business_id,
                                  @Field("lng") String lng,@Field("lat") String lat,
                                  @Field("addr") String addr,@Field("xiaoqu") String xiaoqu,
                                  @Field("contact") String contact,@Field("mobile") String mobile,
                                  @Field("text1") String text1,@Field("text2") String text2,
                                  @Field("text3") String text3,@Field("text4") String text4,
                                  @Field("num1") String num1,@Field("num2") String num2,
                                  @Field("num3") String num3,@Field("num4") String num4,
                                  @Field("select1") String select1,@Field("select2") String select2,
                                  @Field("select3") String select3,@Field("select4") String select4,
                                  @Field("select5") String select5,@Field("select6") String select6,
                                  @Field("fj_select5") String fj_select5,@Field("fj_select6") String fj_select6,
                                  @Field("detail") String detail,@Field("dd") String dd,
                                  @Field("photo") String photo,@Field("ph") String ph,
                                  @Field("pph") String pph);



    @FormUrlEncoded
    @POST(NetWorkUrl.CHUZUFABU)
    Observable<Base> chuzufabu( @Field("token") String token,@Field("life_id") String life_id, @Field("title") String title,
                          @Field("cate_id") int cate_id,
                               @Field("city_id") String city_id,
                                @Field("area_id") String area_id,
                               @Field("business_id") String business_id,
                          @Field("lng") String lng,@Field("lat") String lat,

                          @Field("addr") String addr,@Field("xiaoqu") String xiaoqu,

                          @Field("contact") String contact,@Field("mobile") String mobile,

                          @Field("text1") String text1,@Field("text2") String text2,
                          @Field("text3") String text3,@Field("text4") String text4,

                          @Field("num1") String num1,@Field("num2") String num2,
                          @Field("num3") String num3,@Field("num4") String num4,

                          @Field("select1") String select1,@Field("select2") String select2,
                          @Field("select3") String select3,@Field("select4") String select4,
                          @Field("select5") String select5,@Field("select6") String select6,

                          @Field("fj_select5") String fj_select5,@Field("fj_select6") String fj_select6,

                          @Field("detail") String detail,@Field("dd") String dd,
                          @Field("photo") String photo,@Field("yaoqiu") String yaoqiu);



    @FormUrlEncoded
    @POST(NetWorkUrl.WMALL_FABU)
    Observable<Base> wmall_fabu(@Field("token") String token, @Field("num1") String num1,
                               @Field("xiaoqu") String xiaoqu,@Field("text1") String text1,
                               @Field("text2") String text2,@Field("text3") String text3,
                               @Field("num2") String num2,@Field("city_id") String city_id,
                               @Field("area_id") String area_id,@Field("business_id") String business_id
                               );

    @FormUrlEncoded
    @POST(NetWorkUrl.QZU)
    Observable<Base> qzu(@Field("token") String token, @Field("num1") String num1,
                                @Field("xiaoqu") String xiaoqu,@Field("text1") String text1,
                                @Field("text2") String text2,@Field("text3") String text3,

                                @Field("num2") String num2,@Field("num3") String num3,
                         @Field("num4") String num4,
                         @Field("select1") String select1,@Field("select2") String select2,
                         @Field("select3") String select3,@Field("select4") String select4,
                         @Field("city_id") String city_id,
                         @Field("area_id") String area_id,@Field("business_id") String business_id
                        ,  @Field("contact") String contact,
                         @Field("mobile") String mobile,@Field("type") String type,@Field("addr") String addr

    );

    @FormUrlEncoded
    @POST(NetWorkUrl.WPERMIT_FABU)
    Observable<Base> wpermit_fabu(@Field("token") String token, @Field("cate_id") String num1,
                         @Field("mobile") String mobile,@Field("detail") String detail,
                         @Field("code") String code,


                         @Field("city_id") String city_id,
                         @Field("area_id") String area_id,@Field("business_id") String business_id
            ,  @Field("contact") String contact,
                         @Field("audit") String audit

    );

    //
//
//
//    @FormUrlEncoded
//    @POST("index.php/home/passport/login")
//    Observable<PhoneLoginCde>  passLogin(@Field("mobile") String mobile
//            , @Field("password") String password, @Field("type") int type);
//
//
//    @FormUrlEncoded
//    @POST("index.php/home/passport/code_login")
//    Observable<PhoneLoginCde>  codelogin(@Field("mobile") String mobile
//            , @Field("code") String code, @Field("type") int type);
//
    @Multipart
    @POST("index.php/App/index/upimg")
    Observable<UploadImgBean>  upimg(@Part("token") RequestBody description
            , @Part MultipartBody.Part file);



    //拍卖
    @FormUrlEncoded
    @POST(NetWorkUrl.BIDDER_FABU)
    Observable<Base> bidder_fabu(@Field("token") String token
            ,@Field("city_id") String city_id,
                          @Field("area_id") String area_id,@Field("business_id") String business_id,
                          @Field("lng") String lng,@Field("lat") String lat,
                          @Field("addr") String addr,@Field("num1") String num1,
                          @Field("bz_money") String bz_money,@Field("jia_money") String jia_money,
                          @Field("pg_money") String pg_money,@Field("qp_money") String qp_money,
                          @Field("ys_time") String ys_time,@Field("jp_time") String jp_time,
                          @Field("start_time") String start_time,@Field("photo") String photo,
                          @Field("cate_id") int cate_id,@Field("xiaoqu") String xiaoqu);



    @FormUrlEncoded
    @POST(NetWorkUrl.MY_BIDDER)
    Observable<CommonListBean<MybidderBean>> my_bidder(@Field("token") String token
            , @Field("page") int page, @Field("type") int type);


    @FormUrlEncoded
    @POST(NetWorkUrl.EDIT_VIEW)
    Observable<LiuPaiBean> edit_view(@Field("token") String token
            , @Field("id") int id);

    @FormUrlEncoded
    @POST(NetWorkUrl.SUB_EDIT)
    Observable<Base> sub_edit(@Field("token") String token
            ,@Field("city_id") String city_id,
                                 @Field("area_id") String area_id,@Field("business_id") String business_id,
                                 @Field("lng") String lng,@Field("lat") String lat,
                                 @Field("addr") String addr,@Field("num1") String num1,
                                 @Field("bz_money") String bz_money,@Field("jia_money") String jia_money,
                                 @Field("pg_money") String pg_money,@Field("qp_money") String qp_money,
                                 @Field("ys_time") String ys_time,@Field("jp_time") String jp_time,
                                 @Field("start_time") String start_time,@Field("photo") String photo,
                                 @Field("cate_id") int cate_id,@Field("xiaoqu") String xiaoqu
                              ,@Field("id") int id);



    @FormUrlEncoded
    @POST(NetWorkUrl.WSELL_FABU)
    Observable<Base> wsell_fabu(@Field("token") String token
            ,@Field("xiaoqu") String xiaoqu,
                                @Field("num1") String num1,
                                        @Field("num2") String num2,
                                        @Field("text1") String text1,
                                        @Field("text2") String text2,
                                        @Field("text3") String text3,
                                        @Field("menpai") String menpai,
                                        @Field("num3") String num3,
                                        @Field("num4") String num4,
                                        @Field("select3") String select3,
                                        @Field("select1") String select1,
                                        @Field("select2") String select2
            ,@Field("city_id") String city_id,
                              @Field("area_id") String area_id,@Field("business_id") String business_id,
                              @Field("contact") String contact,@Field("mobile") String mobile,
                              @Field("audit") String audit,
                              @Field("cate_id") String cate_id,@Field("photo") String photo,@Field("addr") String addr
                             );


    @FormUrlEncoded
    @POST(NetWorkUrl.MY_WTBIDDER)
    Observable<PaiMaiBean> my_wtbidder(@Field("token") String token
            , @Field("page") int page);

    @FormUrlEncoded
    @POST(NetWorkUrl.WTSELL)
    Observable<CommonListBean<QiTeBean>> wtsell(@Field("token") String token
            , @Field("page") int page , @Field("cate_id") int cate_id);

    @FormUrlEncoded
    @POST(NetWorkUrl.QTWT)
    Observable<CommonListBean<QiTeBean>> qtwt(@Field("token") String token
            , @Field("page") int page , @Field("cate_id") int cate_id);

    @FormUrlEncoded
    @POST(NetWorkUrl.WDAIKUAN)
    Observable<CommonListBean<QiTeBean>> wdaikuan(@Field("token") String token
            , @Field("page") int page , @Field("cate_id") int cate_id);

    @FormUrlEncoded
    @POST(NetWorkUrl.BIDDER_BOND)
    Observable<PaiMaiBean> bidder_bond(@Field("token") String token
            , @Field("page") int page);

    @FormUrlEncoded
    @POST(NetWorkUrl.BIDDER_TX)
    Observable<PaiMaiBean> bidder_tx(@Field("token") String token
            , @Field("page") int page);

    @FormUrlEncoded
    @POST(NetWorkUrl.MY_MALLBIDDER)
    Observable<PaiMaiBean> my_mallbidder(@Field("token") String token
            , @Field("page") int page);
//
//
//    /**
//     *
//     * @param name
//     * @param card1
//     * @param card2
//     * @param license
//     * @param driving_book
//     * @param cord  油卡
//     * @param encode 无车司机-加盟商代码
//     * @param type   0无车司机|货主-个人 1有车司机|货主-公司288
//     * @param face
//     * @param token
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("index.php/home/passport/user_messsage")
//    Observable<Code>  user_messsage(@Field("name") String name
//            , @Field("card1") String card1, @Field("card2") String card2, @Field("license") String license, @Field("driving_book") String driving_book
//            , @Field("cord") String cord
//            , @Field("encode") String encode, @Field("type") String type
//            , @Field("face") String face
//            , @Field("token") String token);
//
//
//    /**
//     * 用户审核信息
//     * @param token
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("index.php/home/passport/message")
//    Observable<ShenHeBean>  message(@Field("token") String token);
//
//
//    /**
//     * 个人信息
//     * @param token
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("index.php/home/commonpart/user_info")
//    Observable<UserInfoBean>  user_info(@Field("token") String token);
//
//
//    /**
//     * 个人信息编辑
//     * @param token
//     * @param province_id
//     * @param city_id
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("index.php/home/commonpart/edit_info")
//    Observable<Code>  edit_info(@Field("token") String token, @Field("province_id") int province_id,
//                                @Field("city_id") int city_id,
//                                @Field("start_city") int start_city,
//                                @Field("end_city") int end_city);
//
//
//    /**
//     * 更换手机号--原手机号获取
//     * @param token
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("index.php/home/commonpart/mobile")
//    Observable<MobileBean>  getmobile(@Field("token") String token);
//
//
//    /**
//     * 忘记密码
//     * @param mobile   手机号
//     * @param password  新密码
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("index.php/home/passport/forget_ms")
//    Observable<Code>  forget_ms(@Field("mobile") String mobile, @Field("password") String password);
//
//    /**
//     * 忘记密码-短信验证
//     * @param mobile
//     * @param code 验证码
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("index.php/home/passport/forget_code")
//    Observable<Code>  forget_code(@Field("mobile") String mobile, @Field("code") String code);
//
//    /**
//     * 更换手机号--填写新手机号
//     * @param token
//     * @param mobile
//     * @param code
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("index.php/home/commonpart/new_mobile")
//    Observable<Code>  new_mobile(@Field("token") String token, @Field("mobile") String mobile, @Field("code") String code);
//
//
//    /**
//     * 城市-三级
//     * @param
//     * @return
//     */
//   //
//    @FormUrlEncoded
//    @POST("index.php/home/commonpart/city")
//    Observable<CitysBean>  city(@Field("type") Integer type);
//
//    /**
//     * 个人中心---客服
//     * @param token
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("index.php/home/ownercenter/server")
//    Observable<MobileBean>  server(@Field("token") String token);
//
//    /**
//     *  邀请好友
//     * @param token
//     * @param type  1表示安卓 2表示苹果
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("index.php/home/owner/invate")
//    Observable<InvateBean>  invate(@Field("token") String token, @Field("type") int type);
//
//
//    /**
//     * 发布-判断是否已交保证金
//     * @param token
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("index.php/home/owner/bond")
//    Observable<JiaoFouBean>  jiaofou(@Field("token") String token);
//
//    /**
//     * 发布--配送说明
//     * @return
//     */
//    @POST("index.php/home/owner/hade_model")
//    Observable<PeiSongBean>  hade_model();
//
//
//    /**
//     * 发布--货物类型
//     * @return
//     */
//    @POST("index.php/home/owner/goodtype")
//    Observable<PeiSongBean>  goodtype();
//
//
//    /**
//     * 发布--车辆要求
//     * @return
//     */
//    @POST("index.php/home/owner/commander_models")
//    Observable<PeiSongBean>  commander_models();
//
//
//    /**
//     *   发布
//     * @param token
//     * @param type_id 货物类型
//     * @param weight 货物重量
//     * @param car_require  车辆要求
//     * @param car_info  车辆细节描述
//     * @param price  运费
//     * @param invoice  1表示发票有 0没有
//     * @param mobile 手机号
//     * @param hand_mode  配送说明----装卸方式id
//     * @param time  	装车时间
//     * @param start_provinceid 始发地省id
//     * @param start_cityid  始发地市id
//     * @param start_areaid  始发地区域id
//     * @param end_provinceid 目的地省id
//     * @param end_cityid 目的地市id
//     * @param end_areaid 目的地区域id
//     * @param remark 配送说明---备注
//     * @param typeid_bz 货物类型备注
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("index.php/home/owner/fabu")
//    Observable<Base>  fabu(@Field("token") String token
//            , @Field("type_id[]") List<String> type_id
//            , @Field("weight") Float weight
//            , @Field("car_require[]") List<String> car_require
//            , @Field("car_info") String car_info
//            , @Field("price") Float price
//            , @Field("invoice") int invoice
//            , @Field("mobile") String mobile
//            , @Field("hand_mode[]") List<String> hand_mode
//            , @Field("time") String time
//            , @Field("start_provinceid") int start_provinceid
//            , @Field("start_cityid") int start_cityid
//            , @Field("start_areaid") int start_areaid
//            , @Field("end_provinceid") int end_provinceid
//            , @Field("end_cityid") int end_cityid
//            , @Field("end_areaid") int end_areaid
//            , @Field("remark") String remark
//            , @Field("typeid_bz") String typeid_bz
//    );
//
//
//    /**
//     * 钱包--消费记录
//     * @param token
//     * @param page
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("index.php/home/ownercenter/consumption")
//    Observable<XiaoFeiBean>  consumption(@Field("token") String token, @Field("page") int page);
//
//
//    /**
//     * 钱包--线下充值
//     * @param token
//     * @param page
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("index.php/home/ownercenter/recharge")
//    Observable<RechargeBean>  recharge(@Field("token") String token, @Field("page") int page);
//
//
//    /**
//     * 个人中心--message--我的消息
//     * @param token
//     * @param
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("index.php/home/ownercenter/news")
//    Observable<LiuYanBean>  liuyanmessage(@Field("token") String token);
//
//
//    /**
//     * 个人中心--message--系统消息
//     * @param token
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("index.php/home/ownercenter/system_news")
//    Observable<SystemMessage>  system_news(@Field("token") String token);
//
//
//    /**
//     * 司机大厅
//     * @param page
//     * @param start_city
//     * @param end_city
//     * @param array 定制搜索数组
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("index.php/home/joincenter/driver")
//    Observable<DaTingBean>  driver(@Field("page") int page, @Field("start_city") Integer start_city, @Field("end_city") Integer end_city, @Field("array[]") List<Integer> array);
//
//
//    /**
//     * 司机大厅--定制搜索
//     * @return
//     */
//    @POST("index.php/home/joincenter/select")
//    Observable<PeiSongBean>  select();
//
//
//    /**
//     * 司机大厅--详情
//     * @param token
//     * @param uid  司机id
//     * @param car_id  车辆id
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("index.php/home/joincenter/driver_detail")
//    Observable<DriverDetailBean>  driver_detail(@Field("token") String token, @Field("uid") int uid, @Field("car_id") int car_id);
//
//
//    /**
//     * 个人中心--货物信息
//     * @param page
//     * @param type  0未接单 1已接单
//     * @param token
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("index.php/home/ownercenter/goods")
//    Observable<GoodsDeailBean>  goods(@Field("page") int page, @Field("type") int type, @Field("token") String token);
//
//
//    /**
//     * 个人中心--货物详情
//     * @param good_id 货物信息id
//     * @param token
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("index.php/home/ownercenter/good_detail")
//    Observable<GoodsBean>  good_detail(@Field("good_id") int good_id, @Field("token") String token);
//
//
//    /**
//     * 货主端--订单列表
//     * @param page
//     * @param token
//     * @param state 	1表示全部 2表示待付款 3表示进行中 4表示待确认 5表示历史订单
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("index.php/home/ownerorder/order")
//    Observable<OrderBean>  order(@Field("page") int page, @Field("token") String token, @Field("state") int state);
//
//
//    /**
//     * 货主--查看过磅单
//     * @param order_id 订单id
//     * @param token
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("index.php/home/ownerorder/view_weight")
//    Observable<BangDanBean>  view_weight(@Field("order_id") int order_id, @Field("token") String token);
//
//
//    /**
//     * 订单进程
//     * @param order_id
//     * @param token
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("index.php/home/ownerorder/order_process")
//    Observable<XingChengBean>  order_process(@Field("order_id") int order_id, @Field("token") String token);
//
//
//    /**
//     * 货主--修改订单价格
//     * @param order_id
//     * @param token
//     * @param price
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("index.php/home/ownerorder/modify_price")
//    Observable<Code>  modify_price(@Field("order_id") int order_id, @Field("token") String token
//            , @Field("price") float price);
//
//
//    /**
//     * 取消订单
//     * @param token
//     * @param order_id
//     * @param type 1表示司机端取消订单 2表示货主端取消订单
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("index.php/home/ownerorder/cancel_order")
//    Observable<Code>  cancel_order(@Field("token") String token, @Field("order_id") int order_id, @Field("type") int type);

    @FormUrlEncoded
    @POST(NetWorkUrl.DATA)
    Observable<CommonObjectBean<JingJiRenBean>> data(
            @Field("token") String token);


    @FormUrlEncoded
    @POST(NetWorkUrl.JINJIRENSE)
    Observable<CommonObjectBean<JingJiRSettingBean>> jinjirense(
            @Field("token") String token);

    @FormUrlEncoded
    @POST(NetWorkUrl.SUB_SET)
    Observable<Base> sub_set(@Field("token") String token, @Field("shop_face") String shop_face, @Field("shop") String shop);

    @FormUrlEncoded
    @POST(NetWorkUrl.DINGWEI)
    Observable<CommonObjectBean<QuBean>> dingwei(
            @Field("city") String city,@Field("area") String area);

    @FormUrlEncoded
    @POST(NetWorkUrl.INDEX)
    Observable<CommonListBean<Common3Bean>> index(
            @Field("cate_id") String cate_id,@Field("area_id") String area_id,
            @Field("page") int page,@Field("business_id") String business_id,
            @Field("price1") String price1,@Field("price2") String price2,
            @Field("select1") String select1,@Field("yonghu") String yonghu,
            @Field("key") String key);


    @FormUrlEncoded
    @POST(NetWorkUrl.BIDDER_LIST)
    Observable<Base> bidder_list(
            @Field("cate_id") String cate_id,@Field("area_id") String area_id,
            @Field("page") int page);

    @FormUrlEncoded
    @POST(NetWorkUrl.BIDDER_DETAIL)
    Observable<BidderDetailBean> bidder_detail(
            @Field("id") String id,@Field("token") String token);

    @FormUrlEncoded
    @POST(NetWorkUrl.REMIND)
    Observable<Base> remind(
            @Field("id") String id,@Field("token") String token);

    @FormUrlEncoded
    @POST(NetWorkUrl.CJ_BIDDER)
    Observable<Base> cj_bidder(
            @Field("id") String id,@Field("token") String token);

    @FormUrlEncoded
    @POST(NetWorkUrl.AGENT_LIST)
    Observable<CommonListBean<HomeJinBean>> agent_list(
            @Field("page") int page,@Field("area_id") String area_id,@Field("yjbi") String yjbi);

    @FormUrlEncoded
    @POST(NetWorkUrl.ZHUANGXIU)
    Observable<CommonListBean<ZhuangxiuJiaJuBean>> zhuangxiu(
            @Field("page") int page);

    @FormUrlEncoded
    @POST(NetWorkUrl.JIAJU)
    Observable<CommonListBean<ZhuangxiuJiaJuBean>> jiaju(
            @Field("page") int page);


    @FormUrlEncoded
    @POST(NetWorkUrl.DETAIL)
    Observable<CommonObjectBean<ZhuangxiuJiaJuBean>> detail(
            @Field("id") int id);

    @FormUrlEncoded
    @POST(NetWorkUrl.JIAJU_SHOP)
    Observable<CommonObjectBean<QiJianDianBean>> jiaju_shop(
            @Field("id") int id,@Field("page") int page);


    @FormUrlEncoded
    @POST(NetWorkUrl.PRO_DETAIL)
    Observable<CommonObjectBean<JiaJuDetailBean>> pro_detail(
            @Field("id") int id);

    @FormUrlEncoded
    @POST(NetWorkUrl.MALL_DETAIL)
    Observable<CommonObjectBean<FangZiBean>> mall_detail(
            @Field("life_id") String life_id);
    @FormUrlEncoded
    @POST(NetWorkUrl.PHOSE_DETAIL)
    Observable<CommonObjectBean<MaiChuBean>> phose_detail(
            @Field("life_id") String life_id);

    @FormUrlEncoded
    @POST(NetWorkUrl.DAIKUAN_DETAIL)
    Observable<CommonObjectBean<DaiBean>> daikuan_detail(
            @Field("life_id") String life_id);

    @FormUrlEncoded
    @POST(NetWorkUrl.JIAJULISTS)
    Observable<CommonListBean<ChanPinBean>> jiajulists(
            @Field("token") String token,@Field("page") int page);

    @FormUrlEncoded
    @POST(NetWorkUrl.JIAJUVIEW)
    Observable<CommonObjectBean<ChanPinBean>> jiajuview(
            @Field("id") int id);

    @FormUrlEncoded
    @POST(NetWorkUrl.JIAJUFABU)
    Observable<Base> jiajufabu(
                    @Field("token") String token,@Field("photo") String photo,@Field("title") String title
                    ,@Field("intro") String intro);

    @FormUrlEncoded
    @POST(NetWorkUrl.JIAJUEDIT)
    Observable<Base> jiajuedit(
            @Field("token") String token,@Field("photo") String photo,@Field("title") String title
            ,@Field("intro") String intro
            ,@Field("id") String id);

    @FormUrlEncoded
    @POST(NetWorkUrl.JIAJUDELETE)
    Observable<Base> jiajudelete(
            @Field("id") String id);

    @FormUrlEncoded
    @POST(NetWorkUrl.VIEW_LIST)
    Observable<CommonListBean<KanFangBean>> view_list( @Field("token") String token,
            @Field("page") int page);

    @FormUrlEncoded
    @POST(NetWorkUrl.NEWHOUSE)
    Observable<CommonListBean<XinFangBean>> newhouse(
            @Field("area_id") int area_id,
            @Field("business_id") int business_id,
            @Field("price1") int price1,
            @Field("price2") int price2,
            @Field("select") int select);

    @FormUrlEncoded
    @POST(NetWorkUrl.VIEW_BM)
    Observable<CommonListBean<XinFangBean>> view_bm(
            @Field("token") String token,
            @Field("view_id") int view_id,
            @Field("mobile") String mobile,
            @Field("code") int code);

    @FormUrlEncoded
    @POST(NetWorkUrl.VIEW_DETAIL)
    Observable<CommonObjectBean<KanFangDetailBean>> view_detail(
            @Field("id") String id);

    @FormUrlEncoded
    @POST(NetWorkUrl.FANGCHANDATA)
    Observable<CommonObjectBean<FangChanBean>> fangchandata(
            @Field("token") String token);


    @FormUrlEncoded
    @POST(NetWorkUrl.NEWHOUSE_LIST)
    Observable<CommonListBean<LouPanBean>> newhouse_list(
            @Field("token") String token,@Field("page") int page);

    @FormUrlEncoded
    @POST(NetWorkUrl.MIANVIEW_LIST)
    Observable<CommonListBean<MeKanFangBean>> mianview_list(
            @Field("token") String token,@Field("page") int page);


    @FormUrlEncoded
    @POST(NetWorkUrl.NEWHOUSEFABU)
    Observable<Base> newhousefabu(@Field("token") String token,
                                  @Field("city_id") String city_id,
                                  @Field("area_id") String area_id,@Field("business_id") String business_id,

            @Field("select") String select,
            @Field("price") String price,
            @Field("is_onsale") String is_onsale,
            @Field("youhui") String youhui,
            @Field("youhui_starttime") String youhui_starttime,
            @Field("youhui_endtime") String youhui_endtime,
            @Field("address") String address,
            @Field("jdate") String jdate,
            @Field("kdate") String kdate,
            @Field("peizhi") String peizhi,
            @Field("lng") String lng,
            @Field("lat") String lat,
            @Field("huxing") String huxing,
            @Field("xiaoguo") String xiaoguo,
            @Field("shijing") String shijing,
            @Field("peitao") String peitao,
            @Field("guihua") String guihua,
            @Field("jiaotong") String jiaotong,
            @Field("mianji") String mianji,
            @Field("title") String title,
            @Field("mobile") String mobile
    );


    @FormUrlEncoded
    @POST(NetWorkUrl.VIEW_FABU)
    Observable<Base> view_fabu(@Field("token") String token,
                                  @Field("loupan_id") String loupan_id,
                                  @Field("photo") String photo,
                               @Field("title") String title,
                               @Field("youlie") String youlie,
                               @Field("leixing") String leixing,

                               @Field("mobile") String mobile,
                               @Field("start_time") String start_time,
                               @Field("guize") String guize,

                               @Field("sm") String sm,
                               @Field("addr") String addr,
                               @Field("youhui") String youhui

    );

    @FormUrlEncoded
    @POST(NetWorkUrl.HOMEINDEX)
    Observable<CommonObjectBean<HomeBean>> homeindex(@Field("area_id") String area_id
    );

    @FormUrlEncoded
    @POST(NetWorkUrl.NEWHOUSE_DETAIL)
    Observable<CommonObjectBean<XinFangDetailBean>> newhouse_detail(@Field("id") String id
    );

    @FormUrlEncoded
    @POST(NetWorkUrl.VIEW_LOUPAN)
    Observable<CommonListBean<LouPanBeans>> view_loupan(@Field("token") String token
    );

    @FormUrlEncoded
    @POST(NetWorkUrl.ACTIVITY)
    Observable<CommonListBean<CommonBean>> activity(@Field("area_id") String area_id,@Field("type") int type,@Field("page") int page
            );


    @FormUrlEncoded
    @POST(NetWorkUrl.INDEXNEWHOUSE)
    Observable<CommonListBean<Common2Bean>>
    indexnewhouse(@Field("area_id") String area_id,
                  @Field("business_id") String business_id,
                   @Field("price1") String price1,
                  @Field("price2") String price2,
                  @Field("select") int select,
                  @Field("page") int page
    );


    @FormUrlEncoded
    @POST(NetWorkUrl.INDEXNEWHOUSE)
    Observable<CommonListBean<Common5Bean>>
    indexnewhouse2(@Field("area_id") String area_id,
                  @Field("business_id") String business_id,
                  @Field("price1") String price1,
                  @Field("price2") String price2,
                  @Field("select") int select,
                  @Field("page") int page,
                   @Field("key") String key
    );

    @FormUrlEncoded
    @POST(NetWorkUrl.NEWHOUSE_EDIT)
    Observable<CommonObjectBean<LouBean>> newhouse_edit(@Field("token") String area_id,@Field("newhouse_id") String id
    );


    @FormUrlEncoded
    @POST(NetWorkUrl.NEWHOUSE_SUB)
    Observable<Base> newhouse_sub(@Field("token") String token,
                                  @Field("newhouse_id") String newhouse_id,
                                  @Field("city_id") String city_id,
                                  @Field("area_id") String area_id,@Field("business_id") String business_id,
                                  @Field("select") String select,
                                  @Field("price") String price,
                                  @Field("is_onsale") String is_onsale,
                                  @Field("youhui") String youhui,
                                  @Field("youhui_starttime") String youhui_starttime,
                                  @Field("youhui_endtime") String youhui_endtime,
                                  @Field("address") String address,
                                  @Field("jdate") String jdate,
                                  @Field("kdate") String kdate,
                                  @Field("peizhi") String peizhi,
                                  @Field("lng") String lng,
                                  @Field("lat") String lat,
                                  @Field("huxing") String huxing,
                                  @Field("xiaoguo") String xiaoguo,
                                  @Field("shijing") String shijing,
                                  @Field("peitao") String peitao,
                                  @Field("guihua") String guihua,
                                  @Field("jiaotong") String jiaotong,
                                  @Field("mianji") String mianji,
                                  @Field("title") String title,
                                  @Field("mobile") String mobile
    );

    @FormUrlEncoded
    @POST(NetWorkUrl.HVIEW_VIEW)
    Observable<CommonObjectBean<MianBean>> hview_view(@Field("token") String area_id, @Field("id") String id
    );


    @FormUrlEncoded
    @POST(NetWorkUrl.VIEW_SUB)
    Observable<Base> view_sub(@Field("token") String token,
                              @Field("loupan_id") String loupan_id,
                              @Field("photo") String photo,
                              @Field("title") String title,
                              @Field("youlie") String youlie,
                              @Field("leixing") String leixing,
                              @Field("mobile") String mobile,
                              @Field("start_time") String start_time,
                              @Field("guize") String guize,
                              @Field("sm") String sm,
                              @Field("addr") String addr,
                              @Field("youhui") String youhui,
                              @Field("id") String id
    );


    @FormUrlEncoded
    @POST(NetWorkUrl.MESSAGE)
    Observable<CommonObjectBean<PersonInfoBean>> message(@Field("token") String token
    );

    @GET(NetWorkUrl.JUAN)
    Observable<CommonListBean<ZhiDingBean>> juan();


    @FormUrlEncoded
    @POST(NetWorkUrl.RENZHENG)
    Observable<CommonObjectBean<PersonBean>> renzheng(
            @Field("token") String token);

    @FormUrlEncoded
    @POST(NetWorkUrl.CHANGE_MOBILE)
    Observable<Base> change_mobile(
            @Field("mobile") String mobile,
            @Field("code") String code);

    @FormUrlEncoded
    @POST(NetWorkUrl.NEW_MOBILE)
    Observable<Base> new_mobile(
            @Field("token") String token,
            @Field("mobile") String mobile,
            @Field("code") String code);

    @FormUrlEncoded
    @POST(NetWorkUrl.SUB_DATA)
    Observable<Base> sub_data(@Field("token") String token,
                                  @Field("city_id") String city_id,
                                  @Field("area_id") String area_id,
                              @Field("main_business") String main_business,

                              @Field("declaration") String declaration,
                                  @Field("intro") String intro,
                              @Field("year") String year,
                                  @Field("company") String company,

                                  @Field("xiaoqu") String xiaoqu,
                                  @Field("tese") String tese,
                              @Field("yjbi") String yjbi,
                              @Field("jingli") String jingli
    );

    @FormUrlEncoded
    @POST(NetWorkUrl.COLLECT)
    Observable<Base> collect(
            @Field("token") String token,
            @Field("type") String type,
            @Field("life_id") String life_id);

    @FormUrlEncoded
    @POST(NetWorkUrl.FIND_XIAOQU)
    Observable<CommonListBean<XiaoQuBean2>> find_xiaoqu(
            @Field("area_id") String area_id,
            @Field("business_id") String business_id,
            @Field("price") String price,
            @Field("page") int page);

    @FormUrlEncoded
    @POST(NetWorkUrl.GUJI)
    Observable<Base> guji(
            @Field("mianji") String mianji,
            @Field("mobile") String mobile
           );

    @FormUrlEncoded
    @POST(NetWorkUrl.XIAOXI)
    Observable<CommonListBean<XiaoXiBean>> xiaoxi(
            @Field("token") String token,
            @Field("page") int page
    );

    @FormUrlEncoded
    @POST(NetWorkUrl.XX_DETAIL)
    Observable<CommonObjectBean<XiaoXiBean>> xx_detail(
            @Field("xiaoxi_id") String xiaoxi_id

    );
}
