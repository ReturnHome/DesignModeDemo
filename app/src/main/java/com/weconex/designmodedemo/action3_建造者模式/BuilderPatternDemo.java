package com.weconex.designmodedemo.action3_建造者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lifeng on 2018/2/1.
 * @desc 建造者模式:使用一个个简单的对象创建一个复杂的对象
 */

public class BuilderPatternDemo {

    public static void Test(){
        MealBuilder mealBuilder = new MealBuilder();

        Meal meal = mealBuilder.prepareNonVegMeal();
        meal.showItem();
        meal.getCost();


        Meal vegMeal = mealBuilder.prepareVegMeal();
        vegMeal.showItem();
        vegMeal.getCost();
    }
}

/**
 * 创建Builder类 实际的Builder负责创建Meal对象
 */
class MealBuilder{

    public Meal prepareVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new ChickenBurger());
        return meal;
    }

    public Meal prepareNonVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new Coke());
        meal.addItem(new Pepsi());
        return meal;
    }
}

/**
 * 创建餐厅
 */
class Meal{
    private List<Item> mItems = new ArrayList<>();

    public void addItem(Item item){
        mItems.add(item);
    }

    /**
     * 获取总价
     * @return
     */
    public float getCost(){
        float cost = 0.0f;
        for (Item item : mItems) {
            cost += item.price();
        }
        System.out.println("cost: "+cost);
        System.out.println("----------------");
        return cost;
    }

    public void showItem(){
        for (Item item  : mItems) {
            System.out.print("Item : "+item.name());
            System.out.print(", Packing : "+item.packing().pack());
            System.out.println(", Price : "+item.price());
        }
    }
}

/**
 * 食物包装的接口
 */
interface Packing {
    String pack();
}

/**
 * 食物包装的实现类 表示包装纸
 */
class Wrapper implements Packing {
    @Override
    public String pack() {
        return "wrapper:包装纸";
    }
}

/**
 * 食物包装的实现类 表示瓶子
 */
class Bottle implements Packing {
    @Override
    public String pack() {
        return "bottle:瓶子";
    }
}

/**
 * 食物属性
 */
interface Item {

    String name();
    /*** 包装 ***/
    Packing packing();
    /*** 价格 ***/
    float price();
}

/**
 * Item的实现类 并提供了默认属性
 * @desc 汉堡🍔
 */
abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}

/**
 * Item的实现类 并提供了默认属性
 * @desc 冷饮
 */
abstract class ColdDrink implements Item{
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}

/**
 * 创建拓展Burger的实现类
 * @desc 蔬菜汉堡
 */
class VegBurger extends Burger{

    @Override
    public String name() {
        return "VegBurger:蔬菜汉堡";
    }

    @Override
    public float price() {
        return 2.350f;
    }
}

/**
 * 创建拓展Burger的实现类
 * @desc 鸡肉汉堡
 */
class ChickenBurger extends Burger{

    @Override
    public String name() {
        return "ChickenBurger:鸡肉汉堡";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}

/**
 * 创建拓展ColdDrink的实现类
 * @desc 可口可乐
 */
class Coke extends ColdDrink{

    @Override
    public String name() {
        return "Coke:可口可乐";
    }

    @Override
    public float price() {
        return 3.0f;
    }
}

/**
 * 创建拓展ColdDrink的实现类
 * @desc 百事可乐
 */
class Pepsi extends ColdDrink{

    @Override
    public String name() {
        return "Pepsi:百事可乐";
    }

    @Override
    public float price() {
        return 4.5f;
    }
}
