package com.weconex.designmodedemo.action16_迭代器模式;

/**
 * Created by lifeng on 2018/2/7.
 *
 * @desc 迭代器模式
 * 注:提供一种方法顺序访问一个容器对象中各个对象 而又不暴露该对象的内部表示
 */

public class IteratorPattern {

    public static void test() {
        NameRepository nameRepository = new NameRepository();
        for (Iterator iterator = nameRepository.getIterator();iterator.hasNext();){
            System.out.println("name:" + iterator.next());
        }
    }
}

interface Iterator {

    boolean hasNext();

    Object next();
}

interface Container {

    Iterator getIterator();
}

class NameRepository implements Container {
    private String[] names = {"Robert", "John", "Julie", "Lora"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
