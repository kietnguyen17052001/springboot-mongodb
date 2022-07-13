package com.learn.SpringbootMongodb;

import com.learn.SpringbootMongodb.entity.Address;
import com.learn.SpringbootMongodb.entity.Department;
import com.learn.SpringbootMongodb.entity.Employee;
import com.learn.SpringbootMongodb.repository.EmployeeRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootMongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMongodbApplication.class, args);

    }

}
