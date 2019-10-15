package cn.huangzijian888.sell.service;

import cn.huangzijian888.sell.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;

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
     */
    PayResponse create(OrderDTO orderDTO);
}
