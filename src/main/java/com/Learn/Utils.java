package com.Learn;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.Learn.bean.Books;

import java.awt.print.Book;
import java.lang.reflect.Field;

public class Utils {
    /**
     * 判断类中每个属性是否都为空
     *
     * @param o
     * @return
     */
    public static boolean allFieldIsNULL(Object o) {
        try {
            int count=0;
            int nullCount=0;
            for (Field field : o.getClass().getDeclaredFields()) {
                field.setAccessible(true);

                Object object = field.get(o);
                count++;

                    if (ObjectUtil.isEmpty(object)) {
                        nullCount++;
                       continue;
                    }
            }
            if (count==nullCount){
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("判断对象属性为空异常");
        }
        return true;
    }

    public static void main(String[] args) {
        Books books = new Books("1", "2", null, 4);
        Book book = new Book();
        System.out.println(allFieldIsNULL(book));
        System.out.println(allFieldIsNULL(books));

    }
}
