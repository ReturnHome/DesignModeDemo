package com.weconex.designmodedemo.action10_外观模式;

/**
 * Created by lifeng on 2018/2/5.
 * @desc 外观模式
 *  注:隐藏系统的复杂性 并向客户端提供一个可以访问系统的接口
 */

public class FacadePattern {

    public static void test(){
        ShapeMaker shapeMaker = new ShapeMaker();
        //使用外观类 画不同形状的图形
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}

/**
 * 创建一个外观类
 */
class ShapeMaker{
    private Shape circleShape;
    private Shape squareShape;
    private Shape rectangleShape;

    public ShapeMaker() {
        circleShape = new Circle();
        squareShape = new Square();
        rectangleShape = new Rectangle();
    }

    public void drawCircle(){
        circleShape.draw();
    }

    public void drawSquare(){
        squareShape.draw();
    }

    public void drawRectangle(){
        rectangleShape.draw();
    }
}

interface Shape{
    void draw();
}

class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Circle:draw()");
    }
}

class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Square:draw()");
    }
}

class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Rectangle:draw()");
    }
}

