package cn.huangzijian888.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author huangzijian888
 */
@Entity
@Data
public class ProductInfo {
    @Id
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
     * 状态，0正常 1下架.
     */
    private Integer productStatus;
    /**
     * 描述.
     */
    private String productDescription;
    /**
     * 小图.
     */
    private String productIcon;

    public ProductInfo() {
    }

    public ProductInfo(String productId, String productName, BigDecimal productPrice, Integer productStock, Integer categoryType) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.categoryType = categoryType;
    }

    public ProductInfo(String productId, String productName, BigDecimal productPrice, Integer productStock, Integer categoryType, Integer productStatus) {
        this(productId, productName, productPrice, productStock, categoryType);
        this.productStatus = productStatus;
    }

    public ProductInfo(String productId, String productName, BigDecimal productPrice, Integer productStock, Integer categoryType, Integer productStatus, String productDescription) {
        this(productId, productName, productPrice, productStock, categoryType, productStatus);
        this.productDescription = productDescription;
    }


    public ProductInfo(String productId, String productName, BigDecimal productPrice, Integer productStock, Integer categoryType, Integer productStatus, String productDescription, String productIcon) {
        this(productId, productName, productPrice, productStock, categoryType, productStatus, productDescription);
        this.productIcon = productIcon;
    }

}
