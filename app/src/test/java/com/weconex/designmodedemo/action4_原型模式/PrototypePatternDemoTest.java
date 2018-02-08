package com.weconex.designmodedemo.action4_原型模式;

import org.junit.Test;

/**
 * Created by lifeng on 2018/2/1.
 */
public class PrototypePatternDemoTest {
    @Test
    public void test1() throws Exception {
        ShapeCache.loadCache();
        PrototypePatternDemo.test();
    }

}