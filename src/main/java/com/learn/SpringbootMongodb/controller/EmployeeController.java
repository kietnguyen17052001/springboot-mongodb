package com.learn.SpringbootMongodb.controller;

import com.learn.SpringbootMongodb.entity.Employee;
import com.learn.SpringbootMongodb.service.IEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    private final IEmployeeService service;

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {
        try {
            return new ResponseEntity<>(service.getEmployees(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // top n nhan vien co muc luong cao nhat
    @GetMapping("/salary/top/{top}")
    public ResponseEntity<List<Employee>> topSalary(@PathVariable("top") int top) {
        try {
            return new ResponseEntity<>(service.topSalary(top), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // nhan vien co muc luong cao thu index
    @GetMapping("/salary/index/{index}")
    public ResponseEntity<Employee> indexSalary(@PathVariable("index") int index) {
        try {
            return new ResponseEntity<>(service.indexSalary(index), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Employee> insert(@RequestBody Employee employee) {
        try {
            return new ResponseEntity<>(service.insert(employee), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
