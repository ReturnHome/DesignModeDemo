package com.weconex.designmodedemo.action1_工厂模式and抽象工厂模式;

import android.util.Log;

/**
 * Created by lifeng on 2018/2/1.
 */

public class ShapeAbstractFactory extends AbstractFactory {
    @Override
    public Shape getShape(int type) {
        Shape shape = null;

        switch (type) {
            case 0:
                shape = new CircleShape();
                Log.i("TAG", "CircleShape:创建了");
                break;
            case 1:
                shape = new RectShape();
                Log.i("TAG", "RectShape:创建了");
                break;
            case 2:
                shape = new TriangleShape();
                Log.i("TAG", "TriangleShape:创建了");
                break;
        }
        return shape;
    }
}
