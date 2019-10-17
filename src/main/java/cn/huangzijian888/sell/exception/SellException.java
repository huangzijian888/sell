package cn.huangzijian888.sell.exception;

import cn.huangzijian888.sell.enums.ResultEnum;
import lombok.Getter;

/**
 * @author: huangzijian888
 * @date: 2019/10/14 12:48
 */
@Getter
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
