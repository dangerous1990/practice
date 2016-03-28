package org.learn.bigdecimal;

import java.math.BigDecimal;


public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal bd = new BigDecimal("10e1");
        System.out.println(bd.toEngineeringString());
        System.out.println(bd.toPlainString());
        System.out.println(bd.toString());
    }
}
