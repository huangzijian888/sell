package cn.huangzijian888.sell.service.impl;

import cn.huangzijian888.sell.dataobject.SellerInfo;
import cn.huangzijian888.sell.service.SellerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: huangzijian888
 * @date: 2019/10/17 17:20
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SellerServiceImplTest {

    private static final String OPENID = "abc";

    @Autowired
    private SellerService sellerService;

    @Test
    public void findSellerInfoByOpenid() {
        SellerInfo result = sellerService.findSellerInfoByOpenid(OPENID);
        Assert.assertEquals(OPENID, result.getOpenid());

    }
}