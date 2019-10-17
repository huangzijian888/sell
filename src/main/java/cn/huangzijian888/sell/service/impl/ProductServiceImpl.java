package cn.huangzijian888.sell.service.impl;

import cn.huangzijian888.sell.dataobject.ProductInfo;
import cn.huangzijian888.sell.dto.CartDTO;
import cn.huangzijian888.sell.enums.ProductStatusEnum;
import cn.huangzijian888.sell.enums.ResultEnum;
import cn.huangzijian888.sell.exception.SellException;
import cn.huangzijian888.sell.repository.ProductInfoRepository;
import cn.huangzijian888.sell.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author: huangzijian888
 * @date: 2019/10/13 16:40
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findById(productId).orElse(null);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void increaseStock(List<CartDTO> cartDTOList) {

        for (CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> productInfoOptional = repository.findById(cartDTO.getProductId());
            if (!productInfoOptional.isPresent()) {
                log.error("【添加库存】商品不存在，商品id={}", cartDTO.getProductId());
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfoOptional.get().getProductStock() + cartDTO.getProductQuantity();
            productInfoOptional.get().setProductStock(result);
            repository.save(productInfoOptional.get());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> productInfo = repository.findById(cartDTO.getProductId());

            if (!productInfo.isPresent()) {
                log.error("【减少库存】商品不存在，商品id={}", cartDTO.getProductId());
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.get().getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                log.error("【减少库存】库存不足，商品id={}，库存={},减少数量={}", cartDTO.getProductId(), productInfo.get().getProductStock(), cartDTO.getProductQuantity());
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.get().setProductStock(result);
            repository.save(productInfo.get());
        }
    }

    @Override
    public ProductInfo onSale(String productId) {
        Optional<ProductInfo> optional = repository.findById(productId);
        if (!optional.isPresent()) {
            log.error("【商品上架】商品不存在，商品id={}", productId);
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (optional.get().getProductStatusEnum() == ProductStatusEnum.UP) {
            log.error("【商品上架】商品已在架，商品id={},", productId);
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        optional.get().setProductStatus(ProductStatusEnum.UP.getCode());
        return repository.save(optional.get());
    }

    @Override
    public ProductInfo offSale(String productId) {
        Optional<ProductInfo> optional = repository.findById(productId);
        if (!optional.isPresent()) {
            log.error("【商品下架】商品不存在，商品id={}", productId);
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (optional.get().getProductStatusEnum() == ProductStatusEnum.DOWN) {
            log.error("【商品下架】商品已下架，商品id={},", productId);
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        optional.get().setProductStatus(ProductStatusEnum.DOWN.getCode());
        return repository.save(optional.get());
    }
}
