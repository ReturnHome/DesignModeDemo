package com.weconex.designmodedemo.action2_单例模式;

/**
 * Created by lifeng on 2018/2/1.
 *
 * @desc 懒汉式 单例模式
 * 注: 不支持多线程加载 线程不安全  因为没有加同步锁
 *
 * 1.一般情况下，不建议使用第 1 种和第 2 种懒汉方式，建议使用第 3 种饿汉方式。
 * 2.只有在要明确实现 lazy loading 效果时，才会使用第 5 种登记方式。
 * 3.如果涉及到反序列化创建对象时，可以尝试使用第 6 种枚举方式。
 * 4.如果有其他特殊的需求，可以考虑使用第 4 种双检锁方式。
 */

public class Singleton1 {
    private static Singleton1 mInstance;

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        if (mInstance == null) {
            mInstance = new Singleton1();
        }
        return mInstance;
    }

}

/**
 * 懒汉式单例模式
 *
 * @desc 1.线程安全 第一次调用才初始化 避免内存浪费
 * 2.必须加锁才能保证线程安全 但加锁效率太低
 */
class Singleton2 {
    private static Singleton2 mInstance;

    private Singleton2() {
    }

    private static synchronized Singleton2 getInstance() {
        if (mInstance == null) {
            mInstance = new Singleton2();
        }
        return mInstance;
    }
}

/**
 * 饿汉式单例模式
 *
 * @desc 1.没有加锁, 执行效率会提高
 * 2.类加载时就初始化 浪费内存
 */
class Singleton3 {

    private static Singleton3 mInstance = new Singleton3();

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        return mInstance;
    }
}

/**
 * 双重校验锁机制(DCL)
 *
 * @desc 线程安全 在多线程情况下能保持性能
 */
class Singleton4 {
    private static volatile Singleton4 mInstance;

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        if (mInstance == null) {
            synchronized (Singleton4.class) {
                if (mInstance == null) {
                    mInstance = new Singleton4();
                }
            }
        }
        return mInstance;
    }
}

/**
 * 登记式/静态内部类
 * @desc 这种单例模式 能达到和双重校验锁一样的功效 但是实现更简单
 *  对静态域使用延迟初始化 这种方式利用classloader机制来保证初始化Instance时只有一个线程
 */
class Singleton5 {
    private Singleton5(){}

    private static class SingletonHolder {
        private static Singleton5 mInstance = new Singleton5();
    }

    public static final Singleton5 getInstance(){
        return SingletonHolder.mInstance;
    }
}

/**
 * 枚举单例模式
 * @desc
 *  1.使用枚举来创建单例模式是最简洁 自动支持序列化机制
 *  2.绝对防止多次实例化
 */
enum Singleton6{
    INSTANCE;

    public void showMessage(){

    }
}
