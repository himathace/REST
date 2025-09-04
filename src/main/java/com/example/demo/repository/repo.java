package com.example.demo.repository;

import com.example.demo.model.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repo extends JpaRepository<student,Long> {

}
