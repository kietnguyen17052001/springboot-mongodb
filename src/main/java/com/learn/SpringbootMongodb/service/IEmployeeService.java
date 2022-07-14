package com.learn.SpringbootMongodb.service;

import com.learn.SpringbootMongodb.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getEmployees();

    Employee getEmployeeById(String employeeId);

    List<Employee> sortSalary(boolean isAsc);

    List<Employee> topSalary(int top);

    Employee indexSalary(int index);

    Employee insert(Employee employee);

    Employee update(Employee employee);

    void delete(String employeeId);
}
