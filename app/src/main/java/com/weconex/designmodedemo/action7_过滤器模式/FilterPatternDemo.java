package com.weconex.designmodedemo.action7_过滤器模式;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lifeng on 2018/2/2.
 * @desc 过滤器模式
 * 注:这种模式允许使用不同标准来过滤一组对象,通过逻辑运算以解耦的方式将他们连接起来
 */

public class FilterPatternDemo {

    public static void test(){
        //使用不同的标准来过滤Person对象的列表
        List<Person> persons = new ArrayList<Person>();

        persons.add(new Person("Robert","Male", "Single"));
        persons.add(new Person("John","Male", "Married"));
        persons.add(new Person("Laura","Female", "Married"));
        persons.add(new Person("Diana","Female", "Single"));
        persons.add(new Person("Mike","Male", "Single"));
        persons.add(new Person("Bobby","Male", "Single"));

        CriteriaMale male = new CriteriaMale();
        CriteriaFemale female = new CriteriaFemale();
        CriteriaSing sing = new CriteriaSing();

        AndCriteria andCriteria = new AndCriteria(sing, male);
        OrCriteria orCriteria = new OrCriteria(sing, female);

        System.out.println("Males: ");
        printPersons(male.meetCriteria(persons));

        System.out.println("\nFemales: ");
        printPersons(female.meetCriteria(persons));

        System.out.println("\nSingle Males: ");
        printPersons(andCriteria.meetCriteria(persons));

        System.out.println("\nSingle Or Females: ");
        printPersons(orCriteria.meetCriteria(persons));
    }

    public static void printPersons(List<Person> persons){
        for (Person person : persons) {
            System.out.println("Person : [ Name : " + person.getName()
                    +", Gender : " + person.getGender()
                    +", Marital Status : " + person.getMaritalStatus()
                    +" ]");
        }
    }
}

/*** 示例:创建一个Person对象 Criteria接口和实现了该接口的实体类 ***/

class Person{
    private String name;
    private String gender;
    private String maritalStatus;

    public Person(String name, String gender, String maritalStatus) {
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

}

/**
 * 表示标准
 */
interface Criteria{
    List<Person> meetCriteria(List<Person>personList);
}

class CriteriaMale implements Criteria{

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> personMale = new ArrayList<>();
        for (Person person : personList) {
           if(person.getGender().equalsIgnoreCase("male"))
               //过滤出男性Person
            personMale.add(person);
        }
        return personMale;
    }
}

class CriteriaFemale implements Criteria{

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        ArrayList<Person> personFemale = new ArrayList<>();
        for (Person person : personList) {
            //过滤出女性Person
          if (person.getGender().equalsIgnoreCase("female"))
              personFemale.add(person);
        }

        return personFemale;
    }
}

class CriteriaSing implements Criteria{

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        ArrayList<Person> personSing = new ArrayList<>();
        for (Person person : personList) {
            //过滤出女性Person
            if (person.getGender().equalsIgnoreCase("sing"))
                personSing.add(person);
        }

        return personSing;
    }
}

class AndCriteria implements Criteria{

    private Criteria criteria;
    private Criteria otherCrieria;

    public AndCriteria(Criteria criteria, Criteria otherCrieria) {
        this.criteria = criteria;
        this.otherCrieria = otherCrieria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> firstCriteriaPersons = criteria.meetCriteria(personList);
        return otherCrieria.meetCriteria(firstCriteriaPersons);
    }
}

class OrCriteria implements Criteria{

    private Criteria cirteria;
    private Criteria otherCriteria;

    public OrCriteria(Criteria cirteria, Criteria otherCriteria) {
        this.cirteria = cirteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> firstCriteriaItems = cirteria.meetCriteria(personList);
        List<Person> otherCriteriaItems = cirteria.meetCriteria(personList);

        for (Person person : otherCriteriaItems) {
            if(!otherCriteriaItems.contains(person)) {
                firstCriteriaItems.add(person);
            }
        }
        
        return firstCriteriaItems;
    }
}