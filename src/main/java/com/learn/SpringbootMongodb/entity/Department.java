package com.learn.SpringbootMongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "department")
public class Department {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    @DBRef
    private List<Employee> employees;
}
