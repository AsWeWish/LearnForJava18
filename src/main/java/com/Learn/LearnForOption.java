package com.Learn;

import cn.hutool.core.bean.BeanUtil;
import com.Learn.bean.Books;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class LearnForOption {
    /**
     * 创建书籍
     *返回信息中包括四本书,其中有一本是重复的,还有一个的user是空
     * @return {@link List}<{@link Books}>
     */
    public Utils utils = new Utils();

    public List<Books> createBooks() {
        Books Books1 = new Books("坑壁0","坑壁指数","啥也不说",3);
        Books Books2 = new Books("坑壁1","坑壁指数","啥也不说",3);
        Books Books3 = new Books("坑壁1","坑壁指数1","啥也不说1",1);
        Books Books4 = new Books("","坑壁指数2","啥也不说2",3);
        Books booksWithSortNone = new Books();
        booksWithSortNone.setBook("五十");
        booksWithSortNone.setUser("三十");

        List<Books> list = new ArrayList<>();
        list.add(Books1);
        list.add(Books2);
        list.add(Books3);
        list.add(Books4);
        list.add(booksWithSortNone);
        return list;
    }

    /**
     * test1
     * Option基础功能测试之非空判断
     * Option.ofNullable(bean);-在添加元素时候判断非空性
     * option.ifPresent->调用参数时候判断是否为空
     *需要注意的是实例化的对象不算null,即使内部字段都是null
     */

    @Test
    public void test1() {
        List<Books> booksList = createBooks();
        Books books = new Books();
        boolean b = utils.allFieldIsNULL(books);
        System.out.println(b);
        if (BeanUtil.isEmpty(books)) {
            System.out.println("books是空的");
        }
        booksList.add(books);
        /*Optional<List<Books>> booksListByOptional = Optional.of(booksList);
        booksListByOptional
                .ifPresent((x)-> x.stream()
                        .map(xx-> xx.getSort())
                        .forEach((result)-> System.out.println(10+result)));*/
        books=null;
        Optional<Books> book = Optional.ofNullable(books);

        book.ifPresent(books1 -> System.out.println(books1.getSort()));
    }


}
