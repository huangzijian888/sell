package cn.huangzijian888.sell.service.impl;

import cn.huangzijian888.sell.dto.OrderDTO;
import cn.huangzijian888.sell.enums.ResultEnum;
import cn.huangzijian888.sell.exception.SellException;
import cn.huangzijian888.sell.service.OrderService;
import cn.huangzijian888.sell.service.PayService;
import cn.huangzijian888.sell.utils.MathUtil;
import com.alibaba.fastjson.JSON;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import com.github.binarywang.wxpay.bean.request.WxPayRefundRequest;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.WxPayRefundResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: huangzijian888
 * @date: 2019/10/15 05:12
 */
@Service
@Slf4j
public class PayServiceImpl implements PayService {

    private final String ORDER_NAME = "微信点餐订单";

    @Autowired
    private WxPayService wxService;

    @Autowired
    private OrderService orderService;

    @Override
    public WxPayMpOrderResult create(OrderDTO orderDTO) throws WxPayException {
        WxPayUnifiedOrderRequest request = new WxPayUnifiedOrderRequest();
        request.setOpenid(orderDTO.getBuyerOpenid());
        request.setBody(ORDER_NAME);
        request.setOutTradeNo(orderDTO.getOrderId());
        request.setTotalFee((int) (orderDTO.getOrderAmount().doubleValue() * 100));
        request.setSpbillCreateIp("8.8.8.8");
        request.setTradeType("JSAPI");
        WxPayMpOrderResult result = this.wxService.createOrder(request);
        log.info("【微信支付】发起支付，request={}", JSON.toJSONString(request));
        log.info("【微信支付】发起支付，response={}", JSON.toJSONString(result));
        return result;
    }

    @Override
    public WxPayOrderNotifyResult notify(String notifyData) throws WxPayException {
        final WxPayOrderNotifyResult notifyResult = this.wxService.parseOrderNotifyResult(notifyData);
        log.info("【微信支付】异步通知，payResponse={}", JSON.toJSONString(notifyResult));

        // 查询订单
        OrderDTO orderDTO = orderService.findOne(notifyResult.getOutTradeNo());

        // 判断订单是否存在
        if (orderDTO == null) {
            log.error("【微信支付】异步通知，订单不存在，orderId={}", notifyResult.getOutTradeNo());
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        // 判断金额是否一致
        if (!MathUtil.equals(notifyResult.getTotalFee(), orderDTO.getOrderAmount().doubleValue())) {
            log.error("【微信支付】异步通知，订单金额不一致，orderId={}，微信通知金额={}，系统金额={}",
                    notifyResult.getOutTradeNo(),
                    notifyResult.getTotalFee() / 100,
                    orderDTO.getOrderAmount());
            throw new SellException(ResultEnum.WXPAY_NOTIFY_MONEY_VERIFY_ERROR);
        }

        orderService.paid(orderDTO);
        return notifyResult;
    }

    @Override
    public WxPayRefundResult refund(OrderDTO orderDTO) throws WxPayException {
        WxPayRefundRequest request = new WxPayRefundRequest();
        request.setOutTradeNo(orderDTO.getOrderId());
        request.setOutRefundNo(orderDTO.getOrderId());
        request.setTotalFee((int) (orderDTO.getOrderAmount().doubleValue() * 100));
        request.setRefundFee((int) (orderDTO.getOrderAmount().doubleValue() * 100));
        log.info("【微信退款】request={}", JSON.toJSONString(request));
        WxPayRefundResult refundResult = this.wxService.refund(request);
        log.info("【微信退款】response={}", JSON.toJSONString(refundResult));
        return refundResult;
    }
}
