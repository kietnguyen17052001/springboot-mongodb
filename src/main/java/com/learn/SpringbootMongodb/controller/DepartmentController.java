package com.learn.SpringbootMongodb.controller;

import com.learn.SpringbootMongodb.entity.Department;
import com.learn.SpringbootMongodb.entity.Employee;
import com.learn.SpringbootMongodb.service.IDepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {
    private final IDepartmentService service;

    @GetMapping
    public ResponseEntity<List<Department>> getDepartments() {
        try {
            return new ResponseEntity<>(service.getDepartments(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Department> insert(@RequestBody Department department) {
        try {
            return new ResponseEntity<>(service.insert(department), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{departmentName}/employee")
    public ResponseEntity<Department> insertEmployee(@PathVariable("departmentName") String departmentName, @RequestBody Employee employee) {
        try {
            return new ResponseEntity<>(service.insertEmployee(departmentName, employee), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
