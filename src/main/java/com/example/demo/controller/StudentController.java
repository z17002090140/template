package com.example.demo.controller;

import com.example.demo.DTO.PageSo;
import com.example.demo.common.plugin.validator.ValidationUtils;
import com.example.demo.common.plugin.validator.group.Additon;
import com.example.demo.entity.Student;
import com.example.demo.response.ServerResponse;
import com.example.demo.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Api(tags = "测试接口")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    @ApiOperation(value = "新增")
    public ServerResponse addStudent(Student student){
        ValidationUtils.validateEntity(student, Additon.class);
        studentService.add(student);
        return ServerResponse.SuccessDefault();
    }

    @GetMapping("/getAll")
    public ServerResponse findAllStudent(PageSo pageSo){
        return ServerResponse.SuccessListDefault(studentService.findAll(pageSo));
    }

    @PostMapping("/delete")
    public ServerResponse deleteStudent(Integer id){
        studentService.delete(id);
        return ServerResponse.SuccessDefault();
    }

    @PostMapping("/update")
    public ServerResponse updateStudent(Student student){
        studentService.updateStudent(student);
        return ServerResponse.SuccessDefault();
    }

    @GetMapping("/findByName")
    public ServerResponse findByName(String name){
        return ServerResponse.SuccessListDefault(studentService.findByName(name));
    }
}
