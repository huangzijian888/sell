package cn.huangzijian888.sell.service;

import cn.huangzijian888.sell.dto.OrderDTO;
import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

/**
 * @author: huangzijian888
 * @date: 2019/10/15 05:12
 */
public interface PayService {
    /**
     * 创建支付
     *
     * @param orderDTO
     * @return
     * @throws WxPayException
     */
    WxPayMpOrderResult create(OrderDTO orderDTO) throws WxPayException;

    /**
     * 微信支付回调
     *
     * @param notifyData
     * @return
     */
    PayResponse notify(String notifyData);

    /**
     * 退款
     *
     * @param orderDTO
     * @return
     */
    RefundResponse refund(OrderDTO orderDTO);
}
