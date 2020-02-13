package com.dyc.service;

import com.dyc.pojo.bo.SubmitOrderBO;

/**
 * @description:
 * @author: dengyichao
 * @createDate: 2020/2/13
 * @version: 1.0
 */
public interface OrderService {

    /***
     * 方法描述 创建订单相关信息
     * @param submitOrderBO
     * @return java.lang.String 返回订单id,orderId
     * @author dengyichao
     * @date 2020/2/13
     */
    public String createOrder(SubmitOrderBO submitOrderBO);
}
