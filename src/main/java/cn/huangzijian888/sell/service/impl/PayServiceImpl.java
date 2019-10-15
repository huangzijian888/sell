package cn.huangzijian888.sell.service.impl;

import cn.huangzijian888.sell.dto.OrderDTO;
import cn.huangzijian888.sell.service.PayService;
import com.alibaba.fastjson.JSON;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
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
    private BestPayServiceImpl bestPayService;

    @Override
    public PayResponse create(OrderDTO orderDTO) {
        PayRequest payRequest = new PayRequest();
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("【微信支付】发起支付，request={}", JSON.toJSONString(payRequest));

        PayResponse payResponse = bestPayService.pay(payRequest);
        log.info("【微信支付】发起支付，response={}", JSON.toJSONString(payResponse));
        return payResponse;
    }

    @Override
    public PayResponse notify(String notifyData) {
        PayResponse payResponse = bestPayService.asyncNotify(notifyData);
        log.info("【微信支付】异步通知，payResponse={}", JSON.toJSONString(payResponse));
        return payResponse;
    }
}
