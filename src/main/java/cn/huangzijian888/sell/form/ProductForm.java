package cn.huangzijian888.sell.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: huangzijian888
 * @date: 2019/10/17 14:49
 */
@Data
public class ProductForm {

    private String productId;

    /**
     * 名称.
     */
    private String productName;

    /**
     * 单价.
     */
    private BigDecimal productPrice;

    /**
     * 库存.
     */
    private Integer productStock;

    /**
     * 类目编号.
     */
    private Integer categoryType;

    /**
     * 描述.
     */
    private String productDescription;

    /**
     * 小图.
     */
    private String productIcon;

}
