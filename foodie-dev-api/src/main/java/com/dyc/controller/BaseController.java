package com.dyc.controller;

import org.springframework.stereotype.Controller;

import java.io.File;

@Controller
public class BaseController {
    // 购物车cookie
    public static final String FOODIE_SHOPCART = "shopcart";

    public static final Integer COMMON_PAGE_SIZE = 10;
    public static final Integer PAGE_SIZE = 20;

    // 支付中心的调用地址
    String paymentUrl = "http://localhost:8089/foodie-payment/payment/createMerchantOrder";		// produce

    // 微信支付成功 -> 支付中心 -> 天天吃货
    //                      -> 回调通知的url
    String payReturnUrl = "http://localhost:8088/orders/notifyMerchantOrderPaid";

    // 用户上传头像的位置
    public static final String IMAGE_USER_FACE_LOCATION = "F:"+ File.separator+"code"+File.separator+"foodie-dev"+File.separator+"images"+File.separator+"foodie"+File.separator+"faces";
}
