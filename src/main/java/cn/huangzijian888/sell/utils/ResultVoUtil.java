package cn.huangzijian888.sell.utils;

import cn.huangzijian888.sell.vo.ResultVO;

/**
 * @author: huangzijian888
 * @date: 2019/10/13 19:17
 */
public class ResultVoUtil {
    public static ResultVO success(Object object) {
        return new ResultVO(0, "成功", object);
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        return new ResultVO(code, msg);
    }
}
