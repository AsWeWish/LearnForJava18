package com.Learn;

import com.Learn.bean.Books;
import com.Learn.bean.Books;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class StreamByParallel {


    /**
     * 测试
     */
    @Test
    public void test(){
        Instant bef = Instant.now();
        long reduce = LongStream.rangeClosed(0, 10000000000L).parallel().reduce(0, Long::sum);
        System.out.println(reduce);
        Instant now = Instant.now();
        System.out.println(Duration.between(now,bef));
    }

    /**
     * test2与排序
     */
    @Test
    public void test2WithSort(){
        List<Books> BooksList = createBooks();
        BooksList.stream().sorted().forEach(System.out::println);
    }

    /**
     * 创建书籍
     *返回信息中包括四本书,其中有一本是重复的
     * @return {@link List}<{@link Books}>
     */
    public List<Books> createBooks() {
        Books Books1 = new Books("坑壁0","坑壁指数","啥也不说",3);
        Books Books2 = new Books("坑壁1","坑壁指数","啥也不说",3);
        Books Books3 = new Books("坑壁1","坑壁指数1","啥也不说1",1);
        Books Books4 = new Books("坑壁2","坑壁指数2","啥也不说2",2);
        List<Books> list = new ArrayList<>();
        list.add(Books1);
        list.add(Books2);
        list.add(Books3);
        list.add(Books4);
        return list;
    }

    /**
     * 归并练习
     */
    public void Test8ForReduce() {
    }
}
