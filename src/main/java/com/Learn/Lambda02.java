package com.Learn;

import org.junit.Test;

import java.util.Comparator;

/**
 * 主要讲述方法引用和对象引用
 * Lambda的第二春
 */
public class Lambda02 {
    //对象::实例方法名
    //方法作为对象的实现例,比如你实现lambda时候提供了两个参数,而实现例正好需要两个,Lambda需要有一个返回体,而实现例正好返回一个.
    //类::静态方法名或实例方法名
    @Test
    public void test01(){
        //最终效果
        Comparator<Integer> com=Integer::compare;

        //原本写法
        Comparator<Integer> comparator2=(x,y)->{
            int result = Integer.compare(x, y);
            return result;
        };
        /**
         * 二次总结
         * 实现comLambda需要俩int,com正好提供,com需要一个int结果,Integer.compare正好提供
         */
    }
}
