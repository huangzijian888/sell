package cn.huangzijian888.sell.service.impl;

import cn.huangzijian888.sell.dto.OrderDTO;
import cn.huangzijian888.sell.service.OrderService;
import cn.huangzijian888.sell.service.PushMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author: huangzijian888
 * @date: 2019/10/18 02:36
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PushMessageServiceImplTest {

    @Autowired
    PushMessageService pushMessageService;

    @Autowired
    OrderService orderService;

    @Test
    public void orderStatus() {
        OrderDTO orderDTO = orderService.findOne("1571314651321961846");
        pushMessageService.orderStatus(orderDTO);

    }
}