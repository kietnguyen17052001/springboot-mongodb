package com.learn.SpringbootMongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "employee")
public class Employee {
    @Id
    private String id;
    private String name;
    private float salary;
    private Address address;
}
