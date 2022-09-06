package com.Learn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Stream01 {
    /**
     *可以指定你希望对集合进行的操作,可以执行非常复杂的查找,过滤和映射数据等操作.
     * 使用Stream ApI 对集合数据进行操作,就是类似使用SQL执行数据库查询
     * --> StramAPI提供了一种高效且易于使用的处理数据的方式<--
     *核心思路:简化代码,不具备唯一性,所以它能做的别人也可以,但是它的效率更高
     */

    @Test
    public void test(){
        //创建流
        Stream<String> stringStream=Stream.of("a","b");
        //终止循环,惰性求值
        //stringStream.forEach(System.out::println);
        //map映射和filter过滤
        List<student> students = new ArrayList<>();
        students.add(new student("aa",1));
        students.add(new student("aaa",2));
        students.add(new student("aaaa",3));
        students.stream().map(student::getAge).filter((age)->age>1).forEach(System.out::println);
        /**
         * 中间操作,map等不对数据进行操作,在最后终止操作中一起进行
         */
    }

    /**
     * student内部类有两个属性,分别是name和age
     */
    public class student{
        public student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    /**
     * 并行流就是把一个内容分成多个数据块,并用不同的线程分别处理没顾数据块的流
     * Stream API中可以声明性的通过parallel()和sequential()在并行流和顺序流之间进行切换
     */
}
