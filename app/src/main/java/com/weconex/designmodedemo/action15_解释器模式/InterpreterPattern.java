package com.weconex.designmodedemo.action15_解释器模式;

/**
 * Created by lifeng on 2018/2/7.
 * @desc 解释器模式
 *  注:定义了一个表达式接口 通过接口解释一个特定的上下文 类似于json解析器按一定的语法解析json
 */

public class InterpreterPattern {

    public static void test(){
        Expression isMale = getMaleExpression();
        Expression isMattiedWoman = getMarriedWomanExpression();

        System.out.println("John is male?" + isMale.interpret("John"));
        System.out.println("Julie is married Woman?" + isMattiedWoman.interpret("Married Julie"));
    }

    //创建规则 Robert和John是男性
    private static Expression getMaleExpression(){
        TerminalExpression robert = new TerminalExpression("Robert");
        TerminalExpression john = new TerminalExpression("John");
        return new OrExpression(robert,john);
    }

    //创建规则 Julie是已婚女性
    private static Expression getMarriedWomanExpression(){
        TerminalExpression julie = new TerminalExpression("Julie");
        TerminalExpression married = new TerminalExpression("Married");
        return new AndExpression(julie,married);
    }
}

/**
 * 创建一个表达式接口
 */
interface Expression{

    boolean interpret(String context);
}

/**
 * 创建实体类
 */
class TerminalExpression implements Expression{
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if(context.contains(data)) {
            return true;
        }
        return false;
    }
}

class OrExpression implements Expression{

    private Expression exp1;
    private Expression exp2;

    public OrExpression(Expression exp1, Expression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public boolean interpret(String context) {
        return exp1.interpret(context) || exp2.interpret(context);
    }
}

class AndExpression implements Expression{
    private Expression exp1;
    private Expression exp2;

    public AndExpression(Expression exp1, Expression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public boolean interpret(String context) {
        return exp1.interpret(context) && exp2.interpret(context);
    }
}

