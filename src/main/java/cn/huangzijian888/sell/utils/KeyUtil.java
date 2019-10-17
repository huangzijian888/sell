package cn.huangzijian888.sell.utils;

import cn.hutool.core.util.RandomUtil;

/**
 * @author: huangzijian888
 * @date: 2019/10/14 13:00
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式：时间+随机数
     *
     * @return
     */
    public static synchronized String generateUniqueKey() {
        return System.currentTimeMillis() + RandomUtil.randomNumbers(6);
    }
}
