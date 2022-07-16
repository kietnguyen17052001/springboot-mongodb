package com.learn.SpringbootMongodb.repository;

import com.learn.SpringbootMongodb.entity.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepo extends MongoRepository<Role, String> {
    Role findByName(String name);
}
