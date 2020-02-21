package com.dyc.service;

import com.dyc.pojo.OrderStatus;
import com.dyc.pojo.bo.SubmitOrderBO;
import com.dyc.pojo.vo.OrderVO;

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
     * @return 返回订单id,orderId   和  商户订单信息
     * @author dengyichao
     * @date 2020/2/13
     */
    public OrderVO createOrder(SubmitOrderBO submitOrderBO);

    /***
     * 方法描述 修改订单状态
     * @param orderId
     * @param orderStatus
     * @return void
     * @author dengyichao
     * @date 2020/2/14
     */
    public void updateOrderStatus(String orderId, Integer orderStatus);

    /***
     * 方法描述 查询订单状态
     * @param orderId
     * @return com.dyc.pojo.OrderStatus
     * @author dengyichao
     * @date 2020/2/15
     */
    public OrderStatus queryOrderStatusInfo(String orderId);

    /***
     * 方法描述 关闭超时未关闭订单
     * @param
     * @return void
     * @author dengyichao
     * @date 2020/2/16
     */
    public void closeOrder();
}
