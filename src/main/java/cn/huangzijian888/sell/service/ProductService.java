package cn.huangzijian888.sell.service;

import cn.huangzijian888.sell.dataobject.ProductInfo;
import cn.huangzijian888.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author: huangzijian888
 * @date: 2019/10/13 16:36
 */
public interface ProductService {

    /**
     * 根据商品id查询商品
     *
     * @param productId
     * @return
     */
    ProductInfo findOne(String productId);

    /**
     * 查询在架商品
     *
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询所有商品
     *
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 保存商品
     *
     * @param productInfo
     * @return
     */
    ProductInfo save(ProductInfo productInfo);

    /**
     * 加库存
     *
     * @param cartDTOList
     */
    void increaseStock(List<CartDTO> cartDTOList);

    /**
     * 减库存
     *
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);

}
