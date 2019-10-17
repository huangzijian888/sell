package cn.huangzijian888.sell.enums;

import lombok.Getter;

/**
 * 商品状态
 *
 * @author: huangzijian888
 * @date: 2019/10/13 16:42
 */
@Getter
public enum ProductStatusEnum implements CodeEnum {


    /**
     * 在架
     */
    UP(0, "在架"),
    /**
     * 下架
     */
    DOWN(1, "下架"),
    ;

    /**
     * 状态
     */
    private Integer code;

    /**
     * 说明
     */
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
