package com.weconex.designmodedemo.action14_命令模式;

/**
 * Created by lifeng on 2018/2/7.
 *
 * @desc 命令模式
 * 注:数据驱动的设计模式 请求以命令的形式包裹在对象中 并传给调用对象
 *  优点:降低了系统的耦合度 新的命令可以很快接入到系统中
 *  缺点:类的数量过多
 */

public class CommandPattern {

    public static void test() {
        Receiver receiver = new Receiver();
        ConcreteCommend commend = new ConcreteCommend(receiver);
        Invoker invoker = new Invoker(commend);
        invoker.action();
    }
}

/**
 * 抽象的命令
 */
interface Commend {

    void excute();
}

/**
 * 接收者 执行具体的命令
 */
class Receiver{

    public void action(){
        System.out.println("执行命令");
    }
}

/**
 * 具体的命令
 */
class ConcreteCommend implements Commend{

    private Receiver mReceiver;

    //将接收者作为构造参数传入
    public ConcreteCommend(Receiver receiver) {
        mReceiver = receiver;
    }

    @Override
    public void excute() {
        mReceiver.action();
    }
}

/**
 * 请求者 发起请求命令的人
 */
class Invoker{

    private Commend mCommend;

    public Invoker(Commend commend) {
        mCommend = commend;
    }

    public void action(){
        mCommend.excute();
    }
}