package com.weconex.designmodedemo.action22_策略模式;

/**
 * Created by lifeng on 2018/2/8.
 * @desc 策略模式
 *  注:一个类的行为或其算法可以在运行时更改
 */

public class StrategyPattern {

    public static void test(){
        Context context = new Context(new AddOperation());
        int result = context.excuteStrategy(10, 5);
        System.out.println("AddOperation 计算结果:" + result);

        context = new Context(new SubstractOperation());
        result = context.excuteStrategy(10, 5);
        System.out.println("SubstractOperation 计算结果:" + result);

        context = new Context(new MultiplyOperation());
        result = context.excuteStrategy(10, 5);
        System.out.println("MultiplyOperation 计算结果:" + result);

    }
}

interface Strategy{
    int doOperation(int num1,int num2);
}

class AddOperation implements Strategy{

    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

class SubstractOperation implements Strategy{

    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

class MultiplyOperation implements  Strategy{

    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}

class Context{

    private Strategy mStrategy;

    public Context(Strategy strategy) {
        mStrategy = strategy;
    }

    public int excuteStrategy(int num1 , int num2){
        return mStrategy.doOperation(num1,num2);
    }
}