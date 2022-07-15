package com.learn.SpringbootMongodb.service.impl;

import com.learn.SpringbootMongodb.entity.Department;
import com.learn.SpringbootMongodb.entity.Employee;
import com.learn.SpringbootMongodb.exception.BadRequestException;
import com.learn.SpringbootMongodb.exception.NotFoundException;
import com.learn.SpringbootMongodb.repository.DepartmentRepo;
import com.learn.SpringbootMongodb.repository.EmployeeRepo;
import com.learn.SpringbootMongodb.service.IDepartmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<Department> searchDepartments(String information) {
        List<Department> departments = getDepartments().stream().filter(department -> department.getName()
                .toLowerCase().contains(information.toLowerCase())).toList();
        if (departments.isEmpty()) {
            throw new NotFoundException("Not found department with information " + information);
        }
        return departments;
    }

    @Override
    public Department getDepartment(String departmentId) {
        return repo.findById(departmentId).orElseThrow(() -> {
            throw new NotFoundException("Not found department " + departmentId);
        });
    }

    @Override
    public Department insert(Department department) {
        try {
            department.setEmployees(new ArrayList<>());
            return repo.save(department);
        } catch (Exception e) {
            throw new BadRequestException("Name " + department.getName() + " is already exists");
        }
    }

    @Override
    public Department update(Department department) {
        try {
            return repo.save(department);
        } catch (Exception e) {
            throw new BadRequestException("Name " + department.getName() + " is already exists");
        }
    }

    @Override
    public Department insertEmployee(String departmentName, Employee employee) {
        Department department = repo.findByName(departmentName);
        if (department != null) {
            try {
                employeeRepo.save(employee);
                department.getEmployees().add(employee);
                return repo.save(department);
            } catch (Exception e) {
                throw new BadRequestException("Email " + employee.getEmail() + " is already exists");
            }
        } else {
            throw new NotFoundException("Not found department " + departmentName);
        }
    }

    @Override
    public void delete(String departmentId) {
        if (!repo.existsById(departmentId)) {
            throw new NotFoundException("Not found department " + departmentId);
        }
        repo.deleteById(departmentId);
    }

}
