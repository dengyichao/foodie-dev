package com.dyc.controller;

import com.dyc.enums.PayMethod;
import com.dyc.pojo.UserAddress;
import com.dyc.pojo.bo.AddressBO;
import com.dyc.pojo.bo.SubmitOrderBO;
import com.dyc.service.AddressService;
import com.dyc.service.OrderService;
import com.dyc.utils.CookieUtils;
import com.dyc.utils.JSONResult;
import com.dyc.utils.MobileEmailUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(value = "订单相关", tags = {"订单相关的api接口"})
@RequestMapping("orders")
@RestController
public class OrdersController extends BaseController{

    final static Logger logger = LoggerFactory.getLogger(OrdersController.class);

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "用户下单", notes = "用户下单", httpMethod = "POST")
    @PostMapping("/create")
    public JSONResult create(@RequestBody SubmitOrderBO submitOrderBO, HttpServletRequest request, HttpServletResponse response){
        logger.info(submitOrderBO.toString());
        if(submitOrderBO.getPayMethod() != PayMethod.WEIXIN.type
        && submitOrderBO.getPayMethod() != PayMethod.ALIPAY.type){
            return JSONResult.errorMsg("支付方式不支持");
        }
        // 1. 创建订单
        String orderId = orderService.createOrder(submitOrderBO);
        // 2. 创建订单以后，移除购物车中已结算（已提交）的商品
        // TODO 整合redis之后，完善购物车中的已结算商品清除，并且同步到前端的cookie
//        CookieUtils.setCookie(request,response,FOODIE_SHOPCART,"",true);

        // 3. 向支付中心发送当前订单,用于保存支付中心的订单数据

        return JSONResult.ok(orderId);
    }


}
