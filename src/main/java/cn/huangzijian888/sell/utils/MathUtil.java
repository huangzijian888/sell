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
     * @param totalFee    微信传过来的金额 单位：分
     * @param orderAmount 数据库查询出来的 单位：元
     * @return
     */
    public static Boolean equals(Integer totalFee, Double orderAmount) {
        Double temp = orderAmount * 100;
        Integer intValue = (temp).intValue();
        if (totalFee.equals(intValue)) {
            return true;
        } else {
            return false;
        }
    }
}
