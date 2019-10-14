package cn.huangzijian888.sell.utils;

import java.util.Random;

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
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
