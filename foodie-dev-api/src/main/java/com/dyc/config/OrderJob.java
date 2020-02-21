package com.dyc.config;

import com.dyc.service.OrderService;
import com.dyc.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: dengyichao
 * @createDate: 2020/2/16
 * @version: 1.0
 */
@Component
public class OrderJob {

    @Autowired
    private OrderService orderService;

    /**
     * 使用定时任务关闭超期未支付订单，会存在弊端：
     *     1. 会有时间差，程序不严谨
     *          10:39下单，11:00检查不足一个小时，12:00检查，超过1小时多余39分钟
     *     2. 不支持集群的
     *          单机没毛病，使用集群后就会有多个定时任务了
     *          解决方案：只使用一台计算机节点，单独用来运行所有的定时任务
     *     3. 会对数据库全表搜索，极其影响数据库性能：select * from order_status where order_status = 10;
     * 定时任务，且且适用于小型轻量级项目、传统项目
     *
     * 消息队列：MQ-> RabbitMQ、RocketMQ、Kafka、ZeroMQ...
     *      延迟队列 (任务)
     *          10:12分下订单,未付款状态，11:12分检查，如果当前状态还是10，则直接关闭订单即可
     */
//    @Scheduled(cron = "0/3 * * * * ?")
//    @Scheduled(cron = "* * 0/1 * * ?")
    public void autoCloseOrder(){
        orderService.closeOrder();
        System.out.println("执行定时任务，当时时间为：" + DateUtil.getCurrentDateString(DateUtil.DATETIME_PATTERN));
    }
}
