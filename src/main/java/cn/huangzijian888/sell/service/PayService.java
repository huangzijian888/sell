package cn.huangzijian888.sell.service;

import cn.huangzijian888.sell.dto.OrderDTO;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import com.github.binarywang.wxpay.bean.result.WxPayRefundResult;
import com.github.binarywang.wxpay.exception.WxPayException;

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
     * @throws WxPayException
     */
    WxPayOrderNotifyResult notify(String notifyData) throws WxPayException;

    /**
     * 退款
     *
     * @param orderDTO
     * @return
     * @throws WxPayException
     */
    WxPayRefundResult refund(OrderDTO orderDTO) throws WxPayException;
}
