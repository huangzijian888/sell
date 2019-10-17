package cn.huangzijian888.sell.service;

import cn.huangzijian888.sell.dataobject.SellerInfo;

/**
 * @author: huangzijian888
 * @date: 2019/10/17 17:18
 */
public interface SellerService {

    /**
     * 通过openid查询卖家信息
     *
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
