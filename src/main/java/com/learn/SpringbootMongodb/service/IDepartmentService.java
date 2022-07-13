package com.learn.SpringbootMongodb.service;

import com.learn.SpringbootMongodb.entity.Department;
import com.learn.SpringbootMongodb.entity.Employee;

import java.util.List;

public interface IDepartmentService {
    List<Department> getDepartments();

    Department insert(Department department);

    Department insertEmployee(String departmentName, Employee employee);
}
