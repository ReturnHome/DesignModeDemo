package com.weconex.designmodedemo.action4_原型模式;

import java.util.HashMap;

/**
 * Created by lifeng on 2018/2/1.
 *
 * @desc 原型设计模式:用于创建重复的对象,同时又保证性能
 * 注:必须实现Cloneable接口 不实现这个接口,会抛出CloneNotSupportedException异常
 */

public class PrototypePatternDemo {

    public static void test(){

        Shape clonedShape = (Shape) ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());

        Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());

    }
}

class ShapeCache {
    private static HashMap<String, Shape> mHashMap = new HashMap<>();

    public static Shape getShape(String shapeId){
        Shape shape = mHashMap.get(shapeId);
        return (Shape) shape.clone();
    }

    public static void loadCache() {
        Rectangle rectangle = new Rectangle();
        rectangle.setId("1");
        Square square = new Square();
        square.setId("2");
        mHashMap.put(rectangle.getId(),rectangle);
        mHashMap.put(square.getId(),square);
    }
}

/**
 * 创建一个实现Cloneable
 */
abstract class Shape implements Cloneable {
    protected String type;
    private String id;

    public abstract void draw();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}

class Rectangle extends Shape {

    public Rectangle() {
        type = "rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Rectangle draw()");
    }
}

class Square extends Shape {
    public Square() {
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Square draw()");
    }
}