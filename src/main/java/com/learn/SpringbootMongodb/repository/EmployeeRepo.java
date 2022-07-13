package com.learn.SpringbootMongodb.repository;

import com.learn.SpringbootMongodb.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends MongoRepository<Employee, String> {
}
