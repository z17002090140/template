package com.example.demo.entity;

import com.example.demo.common.plugin.validator.group.Additon;
import com.example.demo.common.plugin.validator.group.Update;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
public class Student extends BaseEntity{

    @NotNull(message = "请输入id",groups = Update.class)
    @Null(message = "请不要输入id",groups = Additon.class)
    private Long id;

    private String name;

    private Integer age;

}
