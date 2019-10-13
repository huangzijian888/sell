package cn.huangzijian888.sell.vo;

import lombok.Data;

/**
 * @author: huangzijian888
 * @date: 2019/10/13 17:38
 */
@Data
public class ResultVO<T> {

    /**
     * 错误码.
     */
    private Integer code;
    /**
     * 提示信息.
     */
    private String msg;
    /**
     * 具体内容.
     */
    private T data;

    public ResultVO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
