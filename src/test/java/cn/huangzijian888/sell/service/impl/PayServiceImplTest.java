package cn.huangzijian888.sell.service.impl;

import cn.huangzijian888.sell.dto.OrderDTO;
import cn.huangzijian888.sell.service.OrderService;
import cn.huangzijian888.sell.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: huangzijian888
 * @date: 2019/10/15 06:06
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = orderService.findOne("1571072561140799304");
        payService.create(orderDTO);
    }
}