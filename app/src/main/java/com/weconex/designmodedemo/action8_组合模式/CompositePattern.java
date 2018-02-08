package com.weconex.designmodedemo.action8_组合模式;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lifeng on 2018/2/2.
 * @desc 组合模式
 *  注: 用于把一组相似的对象当做一个单一的对象 依据树形结构来组合对象
 */

public class CompositePattern {
    
    public static void test(){
        Employee CEO = new Employee("John","CEO", 30000);
        //销售部主管
        Employee headSales = new Employee("Robert","Head Sales", 20000);
        //市场部主管
        Employee headMarketing = new Employee("Michel","Head Marketing", 20000);

        //销售部员工
        Employee clerk1 = new Employee("Laura","Marketing", 10000);
        Employee clerk2 = new Employee("Bob","Marketing", 10000);

        //市场部员工
        Employee salesExecutive1 = new Employee("Richard","Sales", 10000);
        Employee salesExecutive2 = new Employee("Rob","Sales", 10000);

        CEO.add(headSales);
        CEO.add(headMarketing);

        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);

        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        //打印所有员工
        System.out.println(CEO);
        for (Employee headEmployee : CEO.getSubordinates()) {
            System.out.println(headEmployee);
            for (Employee employee : headEmployee.getSubordinates()) {
                System.out.println(employee);
            }
        }
    }
}

/*** 示例:模拟公司组织结构 ***/

class Employee{
    private String name;
    private String dept;//职务

    private int salary;//薪水

    private List<Employee> subordinates;

    public Employee(String name ,String dept,int salary){
        this.name = name;
        this.dept = dept;
        this.salary = salary;

        subordinates = new ArrayList<>();
    }

    public void add(Employee employee){
        subordinates.add(employee);
    }

    public void remove(Employee employee){
        subordinates.remove(employee);
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }
}
