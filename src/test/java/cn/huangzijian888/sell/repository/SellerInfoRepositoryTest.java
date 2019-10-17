package cn.huangzijian888.sell.repository;

import cn.huangzijian888.sell.dataobject.SellerInfo;
import cn.hutool.core.util.RandomUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: huangzijian888
 * @date: 2019/10/17 17:10
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SellerInfoRepositoryTest {

    @Autowired
    SellerInfoRepository sellerInfoRepository;

    @Test
    public void save() {
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(RandomUtil.randomNumbers(8));
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");
        sellerInfo.setOpenid("abc");

        SellerInfo result = sellerInfoRepository.save(sellerInfo);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByOpenid() {
        SellerInfo result = sellerInfoRepository.findByOpenid("abc");
        Assert.assertEquals("abc", result.getOpenid());
    }
}