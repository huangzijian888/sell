package cn.huangzijian888.sell.controller;

import cn.huangzijian888.sell.config.ProjectUrlConfig;
import cn.huangzijian888.sell.dto.OrderDTO;
import cn.huangzijian888.sell.enums.ResultEnum;
import cn.huangzijian888.sell.exception.SellException;
import cn.huangzijian888.sell.service.OrderService;
import cn.huangzijian888.sell.service.PayService;
import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author: huangzijian888
 * @date: 2019/10/15 05:02
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                               Map<String, Object> map) throws WxPayException {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        WxPayMpOrderResult result = null;
        try {
            result = payService.create(orderDTO);

        } catch (WxPayException e) {
            map.put("msg", e.getErrCodeDes());
            map.put("url", projectUrlConfig.getSell());
            return new ModelAndView("common/error", map);

        }
        map.put("payResponse", result);
        map.put("returnUrl", returnUrl);

        return new ModelAndView("pay/create", map);
    }

    @PostMapping("/notify/order")
    public ModelAndView notify(@RequestBody String notifyData) throws WxPayException {
        payService.notify(notifyData);
        return new ModelAndView("pay/success");
    }
}
