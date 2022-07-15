package com.learn.SpringbootMongodb.service;

import com.learn.SpringbootMongodb.entity.Department;
import com.learn.SpringbootMongodb.entity.Employee;

import java.util.List;

public interface IDepartmentService {
    List<Department> getDepartments();

    List<Department> searchDepartments(String information);

    Department getDepartment(String departmentId);

    Department insert(Department department);

    Department update(Department department);

    Department insertEmployee(String departmentName, Employee employee);

    void delete(String departmentId);
}
