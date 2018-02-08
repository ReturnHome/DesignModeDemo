package com.weconex.designmodedemo.action1_工厂模式and抽象工厂模式;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lifeng on 2018/2/1.
 */
public class FactoryProductTest {
    @Test
    public void getFactory() throws Exception {
         FactoryProduct.getFactory("shape");
    }

}