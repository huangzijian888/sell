package cn.huangzijian888.sell.service;

import cn.huangzijian888.sell.dto.OrderDTO;

/**
 * 消息推送
 *
 * @author: huangzijian888
 * @date: 2019/10/18 02:20
 */
public interface PushMessageService {

    /**
     * 订单状态变更消息
     *
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
