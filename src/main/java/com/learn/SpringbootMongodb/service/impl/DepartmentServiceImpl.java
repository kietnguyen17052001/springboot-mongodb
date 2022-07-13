package com.learn.SpringbootMongodb.service.impl;

import com.learn.SpringbootMongodb.entity.Department;
import com.learn.SpringbootMongodb.entity.Employee;
import com.learn.SpringbootMongodb.repository.DepartmentRepo;
import com.learn.SpringbootMongodb.repository.EmployeeRepo;
import com.learn.SpringbootMongodb.service.IDepartmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class DepartmentServiceImpl implements IDepartmentService {
    private final DepartmentRepo repo;
    private final EmployeeRepo employeeRepo;

    @Override
    public List<Department> getDepartments() {
        return repo.findAll();
    }

    @Override
    public Department insert(Department department) {
        return repo.save(department);
    }

    @Override
    public Department insertEmployee(String departmentName, Employee employee) {
        Department department = repo.findByName(departmentName);
        employeeRepo.save(employee);
        department.getEmployees().add(employee);
        return repo.save(department);
    }

}
