package com.Learn;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.*;


/**
 * 并行和串行
 */
public class ForkJoinCalculate extends RecursiveTask<Long> {

    private long start;
    private long end;
    //如果start和end之间的计算区间超过50就要使用并行的方式运行
    private static final long THRESHOLD=9999999;

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    /**
     * 运算或者任务拆分
     * @return
     */
    @Override
    protected Long compute() {
       long length=end-start;
       if (length<=THRESHOLD){
           long sum=0;
           for (long i = start; i < end; i++) {
               sum+=i;
           }
           return sum;
       }else {
           long middle = (start + end) / 2;
           ForkJoinCalculate left = new ForkJoinCalculate(start, middle);
           ForkJoinCalculate right = new ForkJoinCalculate(middle, end);
           left.fork();
           right.fork();
           return (left.join()+right.join());
       }
    }

    public static void main(String[] args) {
        long be = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinCalculate task = new ForkJoinCalculate(0L, 99999999999999L);
        Long invoke = pool.invoke(task);
        long now = System.currentTimeMillis();
        System.out.println(now-be);
        System.out.println(invoke);

        double sum=0;
        long bef = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sum+=i;
        }
        long no = System.currentTimeMillis();
        System.out.println(no-bef);
        System.out.println(sum);
    }

}

