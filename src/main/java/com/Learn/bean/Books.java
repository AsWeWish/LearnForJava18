package com.Learn.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books implements Comparable<Books> {
    private String user;
    private String book;
    private String description;
    private int sort;

    @Override
    public int compareTo(Books o) {
        int i = this.getSort() - o.getSort();
        if (i != 0) {
            return this.getSort() - o.getSort();
        } else {
            return getUser().compareTo(o.getUser());
        }
    }
}


