package com.dyc.controller.center;

import com.dyc.controller.BaseController;
import com.dyc.pojo.Orders;
import com.dyc.service.center.MyOrdersService;
import com.dyc.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



/**
 * @description:
 * @author: dengyichao
 * @createDate: 2020/2/16
 * @version: 1.0
 */
@Api(value = "用户中心我的订单", tags = "用户中心我的订单相关接口")
@RestController
@RequestMapping("myorders")
public class MyOrdersController extends BaseController {

//    @Autowired
//    private MyOrdersService myOrdersService;

    @ApiOperation(value = "查询订单列表", notes = "查询订单列表", httpMethod = "POST")
    @PostMapping("query")
    public JSONResult query(
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestParam String userId,
            @ApiParam(name = "orderStatus", value = "订单状态", required = false)
            @RequestParam Integer orderStatus,
            @ApiParam(name = "page", value = "查询下一页的第几页", required = false)
            @RequestParam Integer page,
            @ApiParam(name = "pageSize", value = "分页每一页的条数", required = false)
            @RequestParam Integer pageSize){
        if(StringUtils.isBlank(userId)){
            return JSONResult.errorMsg(null);
        }
        if(page == null){
            page = 1;
        }
        if(pageSize == null){
            pageSize = COMMON_PAGE_SIZE;
        }
        PagedGridResult grid = myOrdersService.queryMyOrders(userId, orderStatus, page, pageSize);
        return JSONResult.ok(grid);
    }

    // 商家发货没有后端，所以这个接口仅仅只是用于模拟
    @ApiOperation(value="商家发货", notes="商家发货", httpMethod = "GET")
    @GetMapping("/deliver")
    public JSONResult deliver(
            @ApiParam(name = "orderId", value = "订单id", required = true)
            @RequestParam String orderId) throws Exception {

        if (StringUtils.isBlank(orderId)) {
            return JSONResult.errorMsg("订单ID不能为空");
        }
        myOrdersService.updateDeliverOrderStatus(orderId);
        return JSONResult.ok();
    }

    @ApiOperation(value="用户确认收货", notes="用户确认收货", httpMethod = "POST")
    @PostMapping("/confirmReceive")
    public JSONResult confirmReceive(
            @ApiParam(name = "orderId", value = "订单id", required = true)
            @RequestParam String orderId,
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestParam String userId) throws Exception {

        JSONResult checkResult = checkUserOrder(userId, orderId);
        if(checkResult.getStatus() != HttpStatus.OK.value()){
            return checkResult;
        }
        boolean res = myOrdersService.updateReceiveOrderStatus(orderId);
        if(!res){
            return JSONResult.errorMsg("订单确认收货失败！");
        }
        return JSONResult.ok();
    }

    @ApiOperation(value="用户删除订单", notes="用户删除订单", httpMethod = "POST")
    @PostMapping("/delete")
    public JSONResult delete(
            @ApiParam(name = "orderId", value = "订单id", required = true)
            @RequestParam String orderId,
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestParam String userId) throws Exception {

        JSONResult checkResult = checkUserOrder(userId, orderId);
        if(checkResult.getStatus() != HttpStatus.OK.value()){
            return checkResult;
        }
        boolean res = myOrdersService.deleteOrder(userId, orderId);
        if(!res){
            return JSONResult.errorMsg("订单删除失败！");
        }


        return JSONResult.ok();
    }





}