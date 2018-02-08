package com.weconex.designmodedemo.action18_备忘录模式;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lifeng on 2018/2/7.
 * @desc 备忘录模式:保存一个对象的某个状态 以便在适当的时候恢复对象
 */

public class MementoPattern {

    public static void test(){
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setState("状态1");
        originator.setState("状态2");
        careTaker.add(originator.saveStateToMemento());

        originator.setState("状态3");
        careTaker.add(originator.saveStateToMemento());

        originator.setState("状态4");
        System.out.println("当前状态:" + originator.getState());

        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("第一次保存的数据状态:" + originator.getState());

        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("第二次保存的数据状态:" + originator.getState());

    }
}

/**
 * 记录要被恢复对象的状态
 */
class Memento{
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

/**
 * 创建并在Memento对象中存储状态
 */
class Originator{
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveStateToMemento(){
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento){
        state = memento.getState();
    }
}

/**
 * 负责从Memento中恢复对象的状态
 */
class CareTaker{
    private List<Memento> mMementoList = new ArrayList<>();

    public void add(Memento memento){
        mMementoList.add(memento);
    }

    public Memento get(int index){
        return mMementoList.get(index);
    }
}