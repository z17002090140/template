package com.example.demo.common.utils;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class PageListUtil {
    public static List pageList(Integer current, Integer size, List vos) {
        List<List> lists = Lists.partition(vos, size);
        List pageRecords = new ArrayList<>();
        if (lists.size() > current - 1)
            pageRecords = lists.get(current - 1);
        return pageRecords;
    }
}
