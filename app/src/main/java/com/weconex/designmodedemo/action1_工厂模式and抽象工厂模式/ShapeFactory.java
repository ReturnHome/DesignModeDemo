package com.weconex.designmodedemo.action1_工厂模式and抽象工厂模式;

/**
 * Created by lifeng on 2018/1/31.
 */

public class ShapeFactory {

    public static Shape getShape(String type) {
        Shape shape = null;
        switch (type) {
            case "0":
                shape = new CircleShape();
                break;
            case "1":
                shape = new RectShape();
                break;
            case "2":
                shape = new TriangleShape();
                break;
        }
        shape.draw();
        return shape;
    }

    /**
     * 使用反射获取实例
     * @param clz
     * @return
     */
    public static Object getShape1(Class<? extends Shape> clz){
        Object instance = null;
        try {
            instance = Class.forName(clz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return instance;
    }

    /**
     * 使用反射 + 泛型(自动强转) 获取实例
     * @param clz
     * @param <T>
     * @return
     */
    public static <T extends Shape> T getShape(Class<? extends T> clz) {
        T instance = null;
        try {
            instance = (T) Class.forName(clz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return instance;
    }
}
