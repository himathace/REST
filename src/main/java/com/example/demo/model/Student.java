package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.repository.NoRepositoryBean;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "title is required")
    @Size(max = 20,message = "title must be within 100 characters")
    private String title;

    @NotBlank(message = "description is required")
    private String description;

    @NotBlank(message = "description is required")
    @Future(message = "deadline must be feture date")
    private String deadline;

    @NotBlank(message = "description is required")
    private String status;

}