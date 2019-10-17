package cn.huangzijian888.sell.constant;

/**
 * Redis常量
 *
 * @author: huangzijian888
 * @date: 2019/10/18 00:06
 */
public interface RedisConstant {

    /**
     * token前缀
     */
    String TOKEN_PREFIX = "token_%s";

    /**
     * 过期时间
     */
    Integer EXPIRE = 7200;
}
