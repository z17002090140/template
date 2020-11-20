package com.example.demo.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class BaseEntity {

    @JsonIgnore
    @ApiModelProperty(hidden=true)
    private Integer isDel;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss",serialize = false)
    @JsonIgnore
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(hidden=true)
    private Date createTime;

    @JsonIgnore
    @ApiModelProperty(hidden=true)
    private String creator;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss",serialize = false)
    @JsonIgnore
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(hidden=true)
    private Date updateTime;

    @JsonIgnore
    @ApiModelProperty(hidden=true)
    private String updator;
}
