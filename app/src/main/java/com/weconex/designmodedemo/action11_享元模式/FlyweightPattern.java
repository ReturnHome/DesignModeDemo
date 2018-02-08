package com.weconex.designmodedemo.action11_享元模式;

import android.util.Log;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by lifeng on 2018/2/5.
 *
 * @desc 享元模式
 * 注:用于减少创建对象的数量 减少内存开销 提高性能
 */

public class FlyweightPattern {

    private static String[] colors = {"Red", "Green", "Blue", "White", "Black"};

    public static void test() {
        for(int i = 0; i < 10; i++) {
            Circle circle = ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(getRandomRadius());
            circle.draw();
        }
    }

    public static String getRandomColor(){
        int i = (int) (Math.random() * colors.length);
        System.out.println("getRandomColor():" + i);
        return colors[i];
    }

    public static int getRandomX(){
        return (int) (Math.random() * 100);
    }

    public static int getRandomY(){
        return (int) (Math.random() * 100);
    }

    public static int getRandomRadius(){
        return (int) (Math.random() * 360);
    }
}

interface Shape {
    void draw();
}

class Circle implements Shape {
    private String color;
    private int x;
    private int y;
    private int radius;

    public Circle(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle: Draw() [Color : " + color
                + ", x : " + x + ", y :" + y + ", radius :" + radius);
    }
}

/**
 * 创建工厂类 生成基于给定信息的实体类对象
 */
class ShapeFactory {
    private static final HashMap<String, Shape> hashMap = new HashMap<>();

    public static Circle getCircle(String color) {
        Circle circle = (Circle) hashMap.get(color);
        if (circle == null) {
            circle = new Circle(color);
            hashMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}