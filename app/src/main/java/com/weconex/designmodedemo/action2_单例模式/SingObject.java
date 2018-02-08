package com.weconex.designmodedemo.action2_单例模式;

/**
 * Created by lifeng on 2018/2/1.
 */

public class SingObject {
    //私有构造器
    private SingObject() {
    }

    private static SingObject mInstance = new SingObject();

    public static SingObject getInstance() {
        return mInstance;
    }

    public void showMessage() {
        System.out.println("我被打印了");
    }
}
