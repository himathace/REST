package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.repository.Repo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class Studentcontroller {

    private  final Repo studentrepository;

    public  Studentcontroller(Repo studentrepository){
        this.studentrepository=studentrepository;
    }

    @PostMapping
    public Student addstudent(@RequestBody Student addstudent){
        return studentrepository.save(addstudent);
    }



     // get all students in the database
    @GetMapping
    public List<Student> getallstudents(){

        return studentrepository.findAll();
    }


    //get one student using id
    // GET http://localhost:8080/students/1
    @GetMapping("/{id}")
    public Student getstudentbyid(@PathVariable Long id){
        return  studentrepository.findById(id).orElseThrow();

    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id,@RequestBody Student newstudent){
        return studentrepository.findById(id)
                .map(classstudent -> {
                    classstudent.name=newstudent.name;
                    classstudent.email=newstudent.email;
                    return studentrepository.save(classstudent);
                })
                .orElseThrow();

    }


    @DeleteMapping("/{id}")
    public void deletestudent(@PathVariable Long id){
        studentrepository.deleteById(id);
    }











}
