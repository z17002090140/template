package com.example.demo.DTO;

import lombok.Data;

@Data
public class PageSo {
    protected Integer current = 1;

    protected Integer size = 10;

    public PageSo() {
    }

    public PageSo(Integer current, Integer size) {
        this.current = current;
        this.size = size;
    }
}
