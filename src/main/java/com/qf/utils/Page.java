package com.qf.utils;

import lombok.Data;

import java.util.List;
//茹东杰
@Data
public class Page<T> {
    private int total; // 总条数
    private int page;  // 当前页
    private int size;  // 每页展示的条数
    private List<T> rows;// 结果集
}
