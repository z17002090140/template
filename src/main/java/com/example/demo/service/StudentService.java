package com.example.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.DTO.PageSo;
import com.example.demo.entity.Student;

import java.util.List;

public interface StudentService extends IService<Student> {

    void add(Student student);

    IPage findAll(PageSo pageSo);

    void delete(Integer id);

    void updateStudent(Student student);

    List<Student> findByName(String name);
}
