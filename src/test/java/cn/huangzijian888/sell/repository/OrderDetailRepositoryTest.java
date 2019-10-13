package cn.huangzijian888.sell.repository;

import cn.huangzijian888.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: huangzijian888
 * @date: 2019/10/13 22:50
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail(
                "123456710",
                "1212313",
                "皮皮虾",
                "232312",
                new BigDecimal(53.9),
                2,
                "http://hidf.jpg");
        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetail = repository.findByOrderId("1212312");
        Assert.assertNotEquals(0, orderDetail.size());
    }
}