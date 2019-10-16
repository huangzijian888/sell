package cn.huangzijian888.sell.enums;

import lombok.Getter;

/**
 * @author: huangzijian888
 * @date: 2019/10/13 21:50
 */
@Getter
public enum PayStatusEnum {
    /**
     * WAIT 未支付
     * <p>
     * SUCCESS 支付成功
     */
    WAIT(0, "未支付"),

    SUCCESS(1, "支付成功"),

    REFUND(2, "已退款"),
    ;

    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
