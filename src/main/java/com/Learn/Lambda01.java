package com.Learn;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class Lambda01 {
    /**
     * 传统中对于匿名内部类的写法
     */
    @Test
    public void Test01() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("传统写法");
            }
        };
        runnable.run();
    }

    /**
     * java8中引入了->符号,该符号称为箭头符号或者Lambda操作符
     * 它将表达式拆成两部分
     * 左边是参数部分
     * 右边是需要执行的功能或者叫Lambda体
     * Lambda依赖于函数式接口
     */
    @Test
    public void Test2() {
        Runnable runnable = () -> {
            System.out.println("Lambda全量写法");
        };
        runnable.run();
    }

    ;

    /**
     * 如果Lambda体只有一句,可以把{}去掉,和有无返回值无关
     */
    @Test
    public void Test2_1() {
        Runnable runnable = () -> System.out.println("Lambda全量写法");
        runnable.run();
    }

    ;

    /**
     * 如果有一个参数但是没返回值
     * 可以在括号中直接写这个参数,名字无所谓,先怎么写都可以
     */
    @Test
    public void Test3() {
        Consumer<String> consumer = (x) -> System.out.println("返现的参数:" + x);
        consumer.accept("传入的参数");
    }

    /**
     * 如果只有一个参数,那么左边的括号也可以去掉
     */
    public void Test3_1() {
        Consumer<String> consumer = x -> System.out.println("返现的参数:" + x);
        consumer.accept("传入的参数");
    }

    /**
     * 如果参数不止一个
     * 同时有返回值或者Lambda体语句不止一条
     */

    @Test
    public void Test4() {
        Comparator<Integer> comparator = (x, y) -> {
            System.out.println("总和为" + (x + y));
            return (x > y ? x : y);
        };
        int compare = comparator.compare(1, 2);
        System.out.println(compare);
    }

    /**
     * 此时编译器会自动推断多个参数的类型
     */

    @Test
    public void Test4_1() {
        Comparator<Integer> comparator = (Integer x, Integer y) -> {
            System.out.println(x + y + "文字描述");
            return x + y;
        };
        System.out.println(comparator.compare(1, 2));
    }

    /**
     * 四大内置函数
     * 1.消费形接口->传参无返回值 Consumer<T>
     * 2.供给形接口->无参有返回值 Predicate<T,R>
     * 3.断言式->传参,但是返回布尔结果 Function<T,R>
     * 4.函数式->传参,返回传递参数类型的结果 Predicate<T>
     */


    public void happy(double money, Consumer<Double> con) {
   con.accept(money);
    }

    @Test
  public void Test2Happy(){
      happy(100,(m)-> System.out.println(m--+"被消费"));
    }
}
