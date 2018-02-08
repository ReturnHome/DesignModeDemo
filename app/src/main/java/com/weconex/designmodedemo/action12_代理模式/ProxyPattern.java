package com.weconex.designmodedemo.action12_代理模式;

/**
 * Created by lifeng on 2018/2/5.
 * @desc 代理模式
 *  注:一个类代表另一个类的功能 为其他对象提供一种代理以控制对这个对象的访问
 */

public class ProxyPattern {

    public static void test(){
        Image image = new ImageProxy("xxx.jpg");

        image.display();
        System.out.println("");
        image.display();
    }
}

interface Image{
    void display();
}

/**
 * 创建接口的实体类
 */
class RealImage implements Image{
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        System.out.println("Loading " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}

/**
 * 创建代理类
 */
class ImageProxy implements Image{

    private String fileName;
    private RealImage mRealImage;

    public ImageProxy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(mRealImage == null) {
            mRealImage = new RealImage(fileName);
        }
        mRealImage.display();
    }
}