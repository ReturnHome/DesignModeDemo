package com.weconex.designmodedemo.action21_空对象模式;

/**
 * Created by lifeng on 2018/2/8.
 * @desc 空对象模式
 *  注:一个空对象取代Null对象实例的检查
 *  Null对象不是检查空值,而是反映一个不做任何动作的关系 可用于在在数据不可用的时候提供一个默认行为
 */

public class NullObjectPattern {

    public static void test(){
        AbstractCustomer customer1 = CustomerFactory.getCustomer("Rob");
        AbstractCustomer customer2 = CustomerFactory.getCustomer("Bob");
        AbstractCustomer customer3 = CustomerFactory.getCustomer("Julie");
        AbstractCustomer customer4 = CustomerFactory.getCustomer("Laura");

        System.out.println("Customers");
        System.out.println(customer1.getName());
        System.out.println(customer2.getName());
        System.out.println(customer3.getName());
        System.out.println(customer4.getName());
    }
}

abstract class AbstractCustomer{

    protected String name;

    public abstract boolean isNil();

    public abstract String getName();
}

class RealCustomer extends AbstractCustomer{

    public RealCustomer(String name) {
        this.name = name;
    }

    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public String getName() {
        return name;
    }
}

class NullCustomer extends AbstractCustomer{

    @Override
    public boolean isNil() {
        return true;
    }

    @Override
    public String getName() {
        return "Not Available in Customer Database!";
    }
}

class CustomerFactory{

    public static final String[] names = {"Rob","Joe","Julie"};

    public static AbstractCustomer getCustomer(String name){
        for (String s : names) {
            if(s.equalsIgnoreCase(name)) {
                return new RealCustomer(name);
            }
        }
        return new NullCustomer();
    }
}
