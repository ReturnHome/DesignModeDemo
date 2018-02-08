package com.weconex.designmodedemo.action9_装饰器模式;

/**
 * Created by lifeng on 2018/2/2.
 * @desc 装饰器模式
 *  注:允许向一个现有的对象增加新的功能 同时又不改变其结构
 */

public class DecoratorPattern {

    public static void test(){
        Shape circle = new Circle();
        circle.draw();

        Shape redShapeDecotator = new RedShapeDecotator(circle);
        redShapeDecotator.draw();

        Shape rectangle = new Rectangle();
        Shape redShapeDecptator = new RedShapeDecotator(rectangle);
        redShapeDecptator.draw();
    }
}

interface Shape{
   void draw();
}

class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Shape:Rectangle");
    }
}

class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Shape:Circle");
    }
}

/**
 * 实现Shape的抽象装饰类
 */
abstract class ShapeDecorator implements Shape{
    protected Shape mShapeDecorator;

    protected ShapeDecorator(Shape shapeDecorator) {
        mShapeDecorator = shapeDecorator;
    }

    public void draw(){
        mShapeDecorator.draw();
    }
}

/**
 * 拓展ShapeDecorator的实体装饰类
 */
class RedShapeDecotator extends ShapeDecorator{

    public RedShapeDecotator(Shape shapeDecorator) {
        super(shapeDecorator);
    }

    @Override
    public void draw() {
        super.draw();
        setRedBorder();
    }

    private void setRedBorder(){
        System.out.println("Border color:red");
    }
}