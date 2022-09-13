package com.Learn;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class ParallelStream {

    /**
     * 在stream中增加一个方法的调用,从而实现串行流切换为并行流
     * 具体调用过程
     * 多线程的核心是.parallel()
     * 如果需要调试就在后面添加.peek(Lambda)
     */
    public static void main(String[] args) {
        Stream<Integer> integerStream=Stream.of(1,2,3,4,5,6,7,8,9);
        integerStream.parallel()
                .peek(integer -> System.out.println(Thread.currentThread().getName() + "输出数字为"+integer))
                .reduce((x, y)->x+y)
                .get();
    }

}
