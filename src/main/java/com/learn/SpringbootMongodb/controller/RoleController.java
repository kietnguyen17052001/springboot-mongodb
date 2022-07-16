package com.learn.SpringbootMongodb.controller;

import com.learn.SpringbootMongodb.entity.Role;
import com.learn.SpringbootMongodb.service.IAccountService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roles")
@AllArgsConstructor
public class RoleController {
    private final IAccountService service;

    @Data
    static
    class FormRoleToAccount {
        private String username;
        private String role;
    }

    @PostMapping
    public ResponseEntity<Role> addRole(@RequestBody Role role) {
        return new ResponseEntity<>(service.addRole(role), HttpStatus.CREATED);
    }

    @PutMapping("/addToAccount")
    public ResponseEntity<?> addRoleToAccount(@RequestBody FormRoleToAccount formRoleToAccount) {
        service.addRoleToUser(formRoleToAccount.getUsername(), formRoleToAccount.getRole());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
