package com.weconex.designmodedemo.action1_工厂模式and抽象工厂模式;

import android.util.Log;

/**
 * Created by lifeng on 2018/2/1.
 *
 * @desc 创建一个工厂类创造器/生成器
 */

public class FactoryProduct {

    public static AbstractFactory getFactory(String type) {
        AbstractFactory factory = null;
        switch (type) {
            case "shape":
                Log.i("TAG", "ShapeAbstractFactory 创建了");
                return factory = new ShapeAbstractFactory();
        }
        return factory;
    }

}
