package com.weconex.designmodedemo.action6_桥接模式;

/**
 * Created by lifeng on 2018/2/2.
 * @desc 桥接模式
 *  注: 用于把抽象化和实现化解耦 使二者可以独立变化
 */

public class BridgePatternDemo {

    public static void test(){
        //画出不同颜色的圆
        new Circle(100,200,180,new RedCircle()).draw();
        new Circle(300,150,200,new GreenCircle()).draw();

    }
}

/*** 示例:使用相同的抽象方法但是不同的桥接实现类 来画出不同颜色的圆 ***/

interface DrawApi{
    void drawCircle(int radius,int x,int y);
}

/**
 * 创建实现了DrawApi的实现类
 */
class RedCircle implements DrawApi{

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: "
                + radius +", x: " +x+", "+ y +"]");
    }
}

class GreenCircle implements DrawApi{

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: "
                + radius +", x: " +x+", "+ y +"]");
    }
}

/**
 * 使用DrawApi接口创建抽象类
 */
abstract class Shape{
   protected DrawApi mDrawApi;

   protected Shape(DrawApi drawApi){
       this.mDrawApi = drawApi;
   }

   public abstract void draw();
}

/**
 * 创建实现Shape的实体类
 */
class Circle extends Shape{

    private int x;
    private int y;
    private int radius;

    protected Circle(int x, int y , int radius, DrawApi drawApi) {
        super(drawApi);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        mDrawApi.drawCircle(x,y,radius);
    }
}
