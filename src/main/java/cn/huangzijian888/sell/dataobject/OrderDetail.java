package cn.huangzijian888.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author: huangzijian888
 * @date: 2019/10/13 21:56
 */
@Entity
@Data
public class OrderDetail {

    @Id
    private String detailId;

    /**
     * 订单id.
     */
    private String orderId;

    /**
     * 商品名称.
     */
    private String productName;

    /**
     * 商品id.
     */
    private String productId;

    /**
     * 商品单价.
     */
    private BigDecimal productPrice;

    /**
     * 商品数量.
     */
    private Integer productQuantity;

    /**
     * 商品小图.
     */
    private String productIcon;

    public OrderDetail() {
    }

    public OrderDetail(String detailId, String orderId, String productName, String productId, BigDecimal productPrice, Integer productQuantity) {
        this.detailId = detailId;
        this.orderId = orderId;
        this.productName = productName;
        this.productId = productId;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public OrderDetail(String detailId, String orderId, String productName, String productId, BigDecimal productPrice, Integer productQuantity, String productIcon) {
        this(detailId, orderId, productName, productId, productPrice, productQuantity);
        this.productIcon = productIcon;
    }
}
