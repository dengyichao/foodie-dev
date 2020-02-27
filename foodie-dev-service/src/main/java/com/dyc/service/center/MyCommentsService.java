package com.dyc.service.center;

import com.dyc.pojo.OrderItems;
import com.dyc.pojo.Users;
import com.dyc.pojo.bo.center.OrderItemsCommentBO;
import com.dyc.utils.PagedGridResult;

import java.util.List;

/**
 * @description:
 * @author: dengyichao
 * @createDate: 2020/2/27
 * @version: 1.0
 */
public interface MyCommentsService {
    /***
     * 方法描述 根据订单id查询关联的商品
     * @param orderId
     * @return java.util.List<com.dyc.pojo.OrderItems>
     * @author dengyichao
     * @date 2020/2/27
     */
    public List<OrderItems> queryPendingComment(String orderId);
    
    /***
     * 方法描述 保存用户的评论
     * @param orderId
     * @param userId
     * @param commentList
     * @return void
     * @author dengyichao
     * @date 2020/2/27
     */
    public void saveComments(String orderId, String userId, List<OrderItemsCommentBO> commentList);

    /***
     * 方法描述 我的评价查询，分页
     * @param userId
     * @param page
     * @param pageSize
     * @return com.dyc.utils.PagedGridResult
     * @author dengyichao
     * @date 2020/2/27
     */
    public PagedGridResult queryMyComments(String userId, Integer page, Integer pageSize);
}
