package cn.huangzijian888.sell.service.impl;

import cn.huangzijian888.sell.dataobject.SellerInfo;
import cn.huangzijian888.sell.repository.SellerInfoRepository;
import cn.huangzijian888.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: huangzijian888
 * @date: 2019/10/17 17:19
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }

}
