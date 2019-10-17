package cn.huangzijian888.sell.repository;

import cn.huangzijian888.sell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: huangzijian888
 * @date: 2019/10/17 17:09
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {

    /**
     * 根据openid查询卖家信息
     *
     * @param openid
     * @return
     */
    SellerInfo findByOpenid(String openid);
}
