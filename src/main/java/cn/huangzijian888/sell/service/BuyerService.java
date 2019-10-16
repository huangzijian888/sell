package cn.huangzijian888.sell.service;

import cn.huangzijian888.sell.dto.OrderDTO;
import com.github.binarywang.wxpay.exception.WxPayException;

/**
 * @author: huangzijian888
 * @date: 2019/10/15 01:47
 */
public interface BuyerService {
    /**
     * 查询一个订单
     *
     * @param openid
     * @param orderId
     * @return
     */
    OrderDTO findOrderOne(String openid, String orderId);

    /**
     * 取消订单
     *
     * @param openid
     * @param orderId
     * @return
     * @throws WxPayException
     */
    OrderDTO cancelOrder(String openid, String orderId) throws WxPayException;

}
