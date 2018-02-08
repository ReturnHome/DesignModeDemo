package com.weconex.designmodedemo.action3_建造者模式;

/**
 * Created by lifeng on 2018/2/5.
 *
 * @desc 变种Builder模式
 * 注:这种方式更优雅 可以通过链式调用
 */

public class BuilderPatternDemo2 {

    public static void test() {
        Person person = new Person.Builder("Tom")
                .setHabit("LOL")
                .setLocation("GuangZhou")
                .setJob("Android")
                .setJob("IOS")
                .Build();
        System.out.println(person.toString());

    }
}

class Person {
    private final String name;//final类型必须在构造器中初始化 不允许不初始化它的构造器存在
    private String location;//可选
    private final String job;//可选
    private String habit;//可选

    public Person(Builder builder) {
        this.name = builder.name;
        this.location = builder.location;
        this.job = builder.job;
        this.habit = builder.habit;
    }

    public static class Builder {
        private final String name;//final类型必须在构造器中初始化 不允许不初始化它的构造器存在
        private String location;//可选
        private String job;//可选
        private String habit;//可选

        public Builder(String name) {
            this.name = name;
        }

        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder setJob(String job) {
            this.job = job;
            return this;
        }

        public Builder setHabit(String habit) {
            this.habit = habit;
            return this;
        }

        public Person Build(){
            return new Person(this);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", job='" + job + '\'' +
                ", habit='" + habit + '\'' +
                '}';
    }
}