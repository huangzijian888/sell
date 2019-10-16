package cn.huangzijian888.sell.dto;

import cn.huangzijian888.sell.dataobject.OrderDetail;
import cn.huangzijian888.sell.enums.OrderStatusEnum;
import cn.huangzijian888.sell.enums.PayStatusEnum;
import cn.huangzijian888.sell.utils.EnumUtil;
import cn.huangzijian888.sell.utils.serialize.Date2LongSerialize;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author: huangzijian888
 * @date: 2019/10/14 12:34
 */
@Data
public class OrderDTO {
    /**
     * 订单id.
     */
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
    private Integer orderStatus;

    /**
     * 支付状态，默认为0未支付.
     */
    private Integer payStatus;

    /**
     * 创建时间.
     */
    @JsonSerialize(using = Date2LongSerialize.class)
    private Date createTime;

    /**
     * 更新时间.
     */
    @JsonSerialize(using = Date2LongSerialize.class)
    private Date updateTime;

    /**
     * 订单详情列表
     */
    private List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }
}
