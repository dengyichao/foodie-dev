package com.dyc.controller;

import com.dyc.enums.OrderStatusEnum;
import com.dyc.enums.PayMethod;
import com.dyc.pojo.OrderStatus;
import com.dyc.pojo.UserAddress;
import com.dyc.pojo.bo.AddressBO;
import com.dyc.pojo.bo.SubmitOrderBO;
import com.dyc.pojo.vo.MerchantOrdersVO;
import com.dyc.pojo.vo.OrderVO;
import com.dyc.service.AddressService;
import com.dyc.service.OrderService;
import com.dyc.utils.CookieUtils;
import com.dyc.utils.JSONResult;
import com.dyc.utils.MobileEmailUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation(value = "用户下单", notes = "用户下单", httpMethod = "POST")
    @PostMapping("/create")
    public JSONResult create(@RequestBody SubmitOrderBO submitOrderBO, HttpServletRequest request, HttpServletResponse response){
        logger.info(submitOrderBO.toString());
        if(submitOrderBO.getPayMethod() != PayMethod.WEIXIN.type
        && submitOrderBO.getPayMethod() != PayMethod.ALIPAY.type){
            return JSONResult.errorMsg("支付方式不支持");
        }
        // 1. 创建订单

        OrderVO orderVO = orderService.createOrder(submitOrderBO);
        String orderId = orderVO.getOrderId();


        // 2. 创建订单以后，移除购物车中已结算（已提交）的商品
        // TODO 整合redis之后，完善购物车中的已结算商品清除，并且同步到前端的cookie
//        CookieUtils.setCookie(request,response,FOODIE_SHOPCART,"",true);
/*  微信支付过程，暂且屏蔽, 没有企业资质 (┬＿┬)
        // 3. 向支付中心发送当前订单,用于保存支付中心的订单数据
        MerchantOrdersVO merchantOrdersVO = orderVO.getMerchantOrdersVO();
        merchantOrdersVO.setReturnUrl(payReturnUrl);

        // 为了方面测试，所有的支付金额都统一改成1分钱
        merchantOrdersVO.setAmount(1);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        // 支付中心  企业资质的账号密码，这里是模拟，并不能真实使用
        headers.add("dycUserId","dyc");
        headers.add("password","dyc");
        HttpEntity<MerchantOrdersVO> entity = new HttpEntity<>(merchantOrdersVO,headers);
        ResponseEntity<JSONResult> responseEntity = restTemplate.postForEntity(paymentUrl, entity, JSONResult.class);
        JSONResult paymentResult = responseEntity.getBody();
        if(paymentResult.getStatus() != 200){
            return JSONResult.errorMsg("支付中心订单创建失败，请联系管理员！");
        }*/
        return JSONResult.ok(orderId);
    }

    @PostMapping("/notifyMerchantOrderPaid")
    public Integer notifyMerchantOrderPaid(String merchantOrderId){
        orderService.updateOrderStatus(merchantOrderId, OrderStatusEnum.WAIT_DELIVER.type);
        return HttpStatus.OK.value();
    }

    @PostMapping("/getPaidOrderInfo")
    public JSONResult getPaidOrderInfo(@RequestParam String orderId){
        /**
         * 在微信或支付宝扫描支付后，支付异步通知到我们的支付中心，
         * 支付中心在通过 restTemplate调取该类中的 notifyMerchantOrderPaid 方法修改本地订单状态
         *
         * 前端每三秒会来查询下该接口（模拟的京东支付页面），
         * 判断该订单是否被支付，
         *
         * 在这里由于没有企业资质，我在这里直接调取 notifyMerchantOrderPaid 方法修改订单状态为已支付，
         * 也就是说支付页面三秒没有操作，就会直接显示支付成功
         */
        this.notifyMerchantOrderPaid(orderId);


        OrderStatus orderStatus = orderService.queryOrderStatusInfo(orderId);
        return JSONResult.ok(orderStatus);
    }

}
