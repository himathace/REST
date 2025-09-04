package com.example.demo.controller;

import com.example.demo.model.student;
import com.example.demo.repository.repo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class studentcontroller {
    private  final repo studentrepository;

    public  studentcontroller(repo studentrepository){
        this.studentrepository=studentrepository;
    }


    @PostMapping
    public student addstudent(@RequestBody student addstudent){
        return studentrepository.save(addstudent);

    }

    public List<student> getallstudents(){
        return studentrepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletestudent(@PathVariable Long id){
        studentrepository.deleteById(id);
    }












}
