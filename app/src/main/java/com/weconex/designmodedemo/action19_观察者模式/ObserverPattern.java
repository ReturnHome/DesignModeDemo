package com.weconex.designmodedemo.action19_观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lifeng on 2018/2/7.
 * @desc 观察者模式
 *  注:当对象间存在一对多关系时(当一个对象被修改,会自动通知它的依赖对象) 使用此模式
 *
 */

public class ObserverPattern {

    public static void test(){
        Subject subject = new Subject();

        new BinaryObserver(subject);
        new OctalObserver(subject);
        new HexaObserver(subject);

        System.out.println("First state change:15");
        subject.setState(15);

        System.out.println("Second state change:10");
        subject.setState(10);
    }
}

/**
 * 观察者的抽象类
 */
abstract class Observer{

    protected Subject mSubject;

    protected abstract void update();
}

/**
 * 带有绑定观察者到Client对象和从Client对象解绑观察者的方法
 */
class Subject{
    private List<Observer> mObservers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObserver();
    }
    //通知所有观察者
    public void notifyAllObserver(){
        for (Observer observer : mObservers) {
            observer.update();
        }
    }
    //绑定观察者
    public void attach(Observer observer) {
        mObservers.add(observer);
    }
}

/**
 * 观察者的实体类
 */
class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject) {
        this.mSubject = subject;
        this.mSubject.attach(this);
    }

    @Override
    protected void update() {
        System.out.println("Binary state:" + Integer.toBinaryString(mSubject.getState()));
    }
}

class OctalObserver extends Observer{

    public OctalObserver(Subject subject) {
        this.mSubject = subject;
        this.mSubject.attach(this);
    }

    @Override
    protected void update() {
        System.out.println("Octal state:" + Integer.toOctalString(mSubject.getState()));
    }
}

class HexaObserver extends Observer{

    public HexaObserver(Subject subject) {
        this.mSubject = subject;
        this.mSubject.attach(this);
    }

    @Override
    protected void update() {
        System.out.println("Hexa state:" + Integer.toHexString(mSubject.getState()).toUpperCase());
    }
}

