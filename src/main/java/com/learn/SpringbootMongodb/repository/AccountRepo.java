package com.learn.SpringbootMongodb.repository;

import com.learn.SpringbootMongodb.entity.Account;
import com.learn.SpringbootMongodb.entity.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends MongoRepository<Account, String> {
    Account findByUsername(String username);
}
