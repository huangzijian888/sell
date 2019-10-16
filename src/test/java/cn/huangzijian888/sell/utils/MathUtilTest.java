package cn.huangzijian888.sell.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: huangzijian888
 * @date: 2019/10/16 09:12
 */
public class MathUtilTest {

    @Test
    public void testEquals() {
        Integer i = 10;
        Double d = 0.10;
        System.out.println(MathUtil.equals(i, d));
    }
}