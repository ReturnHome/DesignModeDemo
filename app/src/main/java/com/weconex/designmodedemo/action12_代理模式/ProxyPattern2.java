package com.weconex.designmodedemo.action12_代理模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lifeng on 2018/2/6.
 *
 * @Desc 静态代理模式
 * 注:代理模式的另一种实现方式
 * 静态代理模式后期拓展和维护很困难
 */

public class ProxyPattern2 {

    public static void test() {
        //创建一个具体的诉讼人:老罗
        ILawProtocol laoLuo = new LaoLuo();

        System.out.println("-----------静态代理模式-----------");
        /*** 使用静态代理模式 ***/
        //构建一个代理律师 并经具体的诉讼人作为参数传进去
        Lawyer lawyer = new Lawyer(laoLuo);

        lawyer.submit();
        lawyer.burden();
        lawyer.defend();
        lawyer.finish();

        System.out.println("-----------动态代理模式-----------");
        /*** 使用动态代理模式 ***/
        //构建一个动态代理
        DynamicProxy dynamicProxy = new DynamicProxy(laoLuo);
        //获取被代理类老罗的ClassLoader
        ClassLoader classLoader = laoLuo.getClass().getClassLoader();
        //动态的构建一个代理律师类
        ILawProtocol lawyerT = (ILawProtocol) Proxy.newProxyInstance(
                classLoader,
                new Class[]{ILawProtocol.class},
                dynamicProxy);

        lawyerT.submit();
        lawyerT.burden();
        lawyerT.defend();
        lawyerT.finish();
    }

}

/**
 * @Desc 动态代理模式:
 * 注:
 * 1.针对静态代理模式写的太死 无法拓展的解决办法
 * 2.通过反射来决定加载哪个代理类 避免代理类都需要复写的问题
 */
class DynamicProxy implements InvocationHandler {

    private Object obj;//被代理类的引用

    public DynamicProxy(Object obj) {//关联被代理的类
        this.obj = obj;
    }

    /**
     * @param proxy  被代理类
     * @param method 被代理类的方法
     * @param args   被代理类所需的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用被代理类对象的方法
        Object invoke = method.invoke(obj, args);
        return invoke;
    }
}

/*** 模拟生活场景:2011年老罗针对西门子冰箱门关不严 找到律师进行维权 ***/


/**
 * 定义诉讼协议接口
 */
interface ILawProtocol {
    //提交申请
    void submit();

    //进行举证
    void burden();

    //开始辩护
    void defend();

    //诉讼完成
    void finish();
}

/**
 * 定义具体的诉讼人:老罗
 */
class LaoLuo implements ILawProtocol {

    @Override
    public void submit() {
        System.out.println("申请：西门子冰箱质量缺陷，特此申请民事仲裁！");
    }

    @Override
    public void burden() {
        System.out.println("证据：这是购买冰箱的发票，以及冰箱质量问题的视频！");
    }

    @Override
    public void defend() {
        System.out.println("辩护：我们证据确凿，必须得到应该的赔偿！");
    }

    @Override
    public void finish() {
        System.out.println("诉讼完成：判决西门子北京分公司在七日之内退还老罗购买冰箱的成本");
    }
}

/**
 * 代理律师类
 */
class Lawyer implements ILawProtocol {
    //关联一个诉讼人
    private ILawProtocol mLawProtocol;

    public Lawyer(ILawProtocol laoLuo) {
        this.mLawProtocol = laoLuo;
    }

    @Override
    public void submit() {
        mLawProtocol.submit();
    }

    @Override
    public void burden() {
        mLawProtocol.burden();
    }

    @Override
    public void defend() {
        mLawProtocol.defend();
    }

    @Override
    public void finish() {
        mLawProtocol.finish();
    }
}