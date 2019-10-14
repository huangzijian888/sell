package cn.huangzijian888.sell.dto;

import lombok.Data;

/**
 * @author: huangzijian888
 * @date: 2019/10/14 13:18
 */
@Data
public class CartDTO {
    /**
     * 商品id.
     */
    private String productId;

    /**
     * 商品数量.
     */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
