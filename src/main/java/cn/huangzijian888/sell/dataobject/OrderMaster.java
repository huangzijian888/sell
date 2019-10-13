package cn.huangzijian888.sell.dataobject;

import cn.huangzijian888.sell.enums.OrderStatusEnum;
import cn.huangzijian888.sell.enums.PayStatusEnum;
import lombok.Getter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: huangzijian888
 * @date: 2019/10/13 21:41
 */
@Entity
@DynamicUpdate
@Getter
public class OrderMaster {
    /**
     * 订单id.
     */
    @Id
    private String orderId;
    /**
     * 买家姓名.
     */
    private String buyerName;
    /**
     * 买家手机号.
     */
    private String buyerPhone;
    /**
     * 买家地址.
     */
    private String buyerAddress;
    /**
     * 买家微信openid.
     */
    private String buyerOpenid;
    /**
     * 订单总金额.
     */
    private BigDecimal orderAmount;
    /**
     * 订单状态，默认为0新下单.
     */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    /**
     * 支付状态，默认为0未支付.
     */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /**
     * 创建时间.
     */
    private Date createTime;

    /**
     * 更新时间.
     */
    private Date updateTime;

    public OrderMaster() {
    }

    public OrderMaster(String orderId, String buyerName, String buyerPhone, String buyerAddress, String buyerOpenid, BigDecimal orderAmount) {
        this.orderId = orderId;
        this.buyerName = buyerName;
        this.buyerPhone = buyerPhone;
        this.buyerAddress = buyerAddress;
        this.buyerOpenid = buyerOpenid;
        this.orderAmount = orderAmount;
    }
}
