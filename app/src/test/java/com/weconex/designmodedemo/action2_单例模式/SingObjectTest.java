package com.weconex.designmodedemo.action2_单例模式;

import org.junit.Test;

/**
 * Created by lifeng on 2018/2/1.
 */
public class SingObjectTest {

    @Test
    public void getMessage() throws Exception {
        SingObject.getInstance().showMessage();
    }

}