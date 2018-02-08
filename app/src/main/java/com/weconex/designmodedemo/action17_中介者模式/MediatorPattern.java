package com.weconex.designmodedemo.action17_中介者模式;

import java.util.Date;

/**
 * Created by lifeng on 2018/2/7.
 * @desc 中介者模式
 *  注:用来降低多个对象和类之间的通信复杂性
 */

public class MediatorPattern {

    public static void test(){
        User tom = new User("Tom");
        User lucy = new User("Lucy");

        tom.sendMessage("Hi,Lucy!");
        lucy.sendMessage("Hello!Tom");
    }
}

/*** 示例:模拟聊天室  多个用户像聊天室发送消息 聊天室向所有用户显示消息 ***/

class CharRoom{

    public static void showMessage(User user,String message){
        System.out.println(new Date().toString() + "[" + user.getName() + "]:" + message);
    }
}

class User{
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sendMessage(String message){
        CharRoom.showMessage(this,message);
    }
}