package com.learn.SpringbootMongodb.service;

import com.learn.SpringbootMongodb.entity.Account;
import com.learn.SpringbootMongodb.entity.Role;

public interface IAccountService {
    Account register(Account account);

    Role addRole(Role role);

    void addRoleToUser(String username, String roleName);
}
