package cn.huangzijian888.sell.utils;

/**
 * @author: huangzijian888
 * @date: 2019/10/16 07:14
 */
public class MathUtil {
    private static final Double MONEY_RANGE = 0.01;

    /**
     * 比较两个金额是否相等
     *
     * @param d1
     * @param d2
     * @return
     */
    public static Boolean equals(Double d1, Double d2) {
        Double result = Math.abs(d1 - d2);
        if (result < MONEY_RANGE) {
            return true;
        } else {
            return false;
        }
    }
}
