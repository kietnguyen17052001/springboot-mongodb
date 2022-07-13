package com.learn.SpringbootMongodb.repository;

import com.learn.SpringbootMongodb.entity.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends MongoRepository<Department, String> {
    Department findByName(String name);
}
