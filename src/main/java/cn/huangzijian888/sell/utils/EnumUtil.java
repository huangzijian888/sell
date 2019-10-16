package cn.huangzijian888.sell.utils;

import cn.huangzijian888.sell.enums.CodeEnum;

/**
 * @author: huangzijian888
 * @date: 2019/10/16 13:29
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
