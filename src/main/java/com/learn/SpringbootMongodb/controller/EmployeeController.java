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
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam(name = "search", required = false) String search) {
        if (search == null) {
            return new ResponseEntity<>(service.getEmployees(), HttpStatus.OK);
        }
        return new ResponseEntity<>(service.searchEmployees(search), HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("employeeId") String employeeId) {
        return new ResponseEntity<>(service.getEmployeeById(employeeId), HttpStatus.OK);
    }

    // top n nhan vien co muc luong cao nhat
    @GetMapping("/salary/top/{top}")
    public ResponseEntity<List<Employee>> topSalary(@PathVariable("top") int top) {
        return new ResponseEntity<>(service.topSalary(top), HttpStatus.OK);
    }

    // nhan vien co muc luong cao thu index
    @GetMapping("/salary/index/{index}")
    public ResponseEntity<Employee> indexSalary(@PathVariable("index") int index) {
        return new ResponseEntity<>(service.indexSalary(index), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> insert(@RequestBody Employee employee) {
        return new ResponseEntity<>(service.insert(employee), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {
        return new ResponseEntity<>(service.update(employee), HttpStatus.CREATED);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<?> delete(@PathVariable("employeeId") String employeeId) {
        service.delete(employeeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
