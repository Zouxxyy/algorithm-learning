package com.zouxxyy.c01;

import java.io.File;

/**
 * @author zxy
 */
public class Test {

    public static void main(String[] args) {


        String test = "file:/home/zxy";

        System.out.println(test.substring(5));

        System.out.println(new File(test).getAbsolutePath());

    }

}
