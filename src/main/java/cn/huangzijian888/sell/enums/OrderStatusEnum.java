package cn.huangzijian888.sell.enums;

import lombok.Getter;

/**
 * @author: huangzijian888
 * @date: 2019/10/13 21:45
 */
@Getter
public enum OrderStatusEnum implements CodeEnum {

    /**
     * NEW 新订单
     * <p>
     * FINISHED 完成
     * <p>
     * CANCEL 取消
     */
    NEW(0, "新订单"),

    FINISHED(1, "已完成"),

    CANCEL(2, "已取消");
    private Integer code;
    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
