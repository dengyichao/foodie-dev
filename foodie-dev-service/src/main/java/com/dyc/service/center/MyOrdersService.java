package com.dyc.service.center;

import com.dyc.pojo.Orders;
import com.dyc.pojo.vo.OrderStatusCountsVO;
import com.dyc.utils.PagedGridResult;

public interface MyOrdersService {
    /***
     * 方法描述 查询我的订单列表
     * @param userId
     * @param orderStatus
     * @param page
     * @param pageSize
     * @return com.dyc.utils.PagedGridResult
     * @author dengyichao
     * @date 2020/2/23
     */
    public PagedGridResult queryMyOrders(String userId, Integer orderStatus, Integer page, Integer pageSize);
    
    /***
     * 方法描述 订单状态 --> 商家发货
     * @param orderId
     * @return void
     * @author dengyichao
     * @date 2020/2/23
     */
    public void updateDeliverOrderStatus(String orderId);

    /***
     * 方法描述 查询我的订单
     * @param userId
     * @param orderId
     * @return com.dyc.pojo.Orders
     * @author dengyichao
     * @date 2020/2/23
     */
    public Orders queryMyOrder(String userId, String orderId);

    /***
     * 方法描述 更新订单状态 -> 确认收货
     * @param orderId
     * @return boolean
     * @author dengyichao
     * @date 2020/2/23
     */
    public boolean updateReceiveOrderStatus(String orderId);

     /***
      * 方法描述 删除订单(逻辑删除)
      * @param userId
      * @param orderId
      * @return boolean
      * @author dengyichao
      * @date 2020/2/23
      */
    public boolean deleteOrder(String userId, String orderId);

    /***
     * 方法描述 查询用户订单数
     * @param userId
     * @return void
     * @author dengyichao
     * @date 2020/2/29
     */
    public OrderStatusCountsVO getOrderStatusCounts(String userId);

    /***
     * 方法描述 获得分页的订单动向
     * @param userId
     * @param page
     * @param pageSize
     * @return com.dyc.utils.PagedGridResult
     * @author dengyichao
     * @date 2020/2/29
     */
    public PagedGridResult getOrdersTrend(String userId,
                                          Integer page,
                                          Integer pageSize);
}
