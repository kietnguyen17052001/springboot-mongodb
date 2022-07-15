package com.learn.SpringbootMongodb.controller;

import com.learn.SpringbootMongodb.entity.Department;
import com.learn.SpringbootMongodb.entity.Employee;
import com.learn.SpringbootMongodb.service.IDepartmentService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
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
    public ResponseEntity<List<Department>> getDepartments(@RequestParam(name = "search", required = false) String search) {
        if (search == null) {
            return new ResponseEntity<>(service.getDepartments(), HttpStatus.OK);
        }
        return new ResponseEntity<>(service.searchDepartments(search), HttpStatus.OK);
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<Department> getDepartment(@PathVariable("departmentId") String departmentId) {
        return new ResponseEntity<>(service.getDepartment(departmentId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Department> insert(@RequestBody Department department) {
        return new ResponseEntity<>(service.insert(department), HttpStatus.CREATED);
    }

    @PostMapping("/{departmentName}/employee")
    public ResponseEntity<Department> insertEmployee(@PathVariable("departmentName") String departmentName, @RequestBody Employee employee) {
        return new ResponseEntity<>(service.insertEmployee(departmentName, employee), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Department> update(@RequestBody Department department) {
        return new ResponseEntity<>(service.update(department), HttpStatus.OK);
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<?> delete(@PathVariable("departmentId") String departmentId) {
        service.delete(departmentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
