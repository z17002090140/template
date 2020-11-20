package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.DTO.PageSo;
import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.service.StudentService;
import com.example.demo.common.utils.PageListUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
    @Override
    public void add(Student student) {
        save(student);
    }

    @Override
    public IPage findAll(PageSo pageSo) {
        List<Student> result = list();
        List pageList = PageListUtil.pageList(pageSo.getCurrent(),pageSo.getSize(),result);
        Page p = new Page(pageSo.getCurrent(),pageSo.getSize(),result.size());
        p.setRecords(pageList);
        return p;
    }

    @Override
    public void delete(Integer id) {
        removeById(id);
    }

    @Override
    public void updateStudent(Student student) {
        updateById(student);
    }

    @Override
    public List<Student> findByName(String name) {
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.eq("name",name);
        return list(qw);
    }
}
