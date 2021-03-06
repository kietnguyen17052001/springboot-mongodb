package com.learn.SpringbootMongodb.service.impl;

import com.learn.SpringbootMongodb.entity.Employee;
import com.learn.SpringbootMongodb.exception.BadRequestException;
import com.learn.SpringbootMongodb.exception.NotFoundException;
import com.learn.SpringbootMongodb.repository.EmployeeRepo;
import com.learn.SpringbootMongodb.service.IEmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Slf4j
@Service
public class EmployeeServiceImpl implements IEmployeeService {
    private final EmployeeRepo repo;

    @Override
    public List<Employee> getEmployees() {
        return repo.findAll();
    }

    @Override
    public List<Employee> searchEmployees(String information) {
        List<Employee> employees = getEmployees().stream()
                .filter(employee -> employee.getName().toLowerCase().contains(information.toLowerCase())
                        || employee.getEmail().contains(information)).toList();
        if (employees.isEmpty()) {
            throw new NotFoundException("Not found employees with information " + information);
        }
        return employees;
    }

    @Override
    public Employee getEmployeeById(String employeeId) {
        return repo.findById(employeeId).orElseThrow(() -> new NotFoundException("Not found id " + employeeId));
    }

    @Override
    public List<Employee> sortSalary(boolean isAsc) {
        return isAsc ? getEmployees().stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList())
                : getEmployees().stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
    }

    @Override
    public List<Employee> topSalary(int top) {
        return sortSalary(false).stream().limit(top).collect(Collectors.toList());
    }

    @Override
    public Employee indexSalary(int index) {
        return sortSalary(false).stream().skip(index - 1).limit(1).findFirst().orElse(null);
    }


    @Override
    public Employee insert(Employee employee) {
        try {
            return repo.save(employee);
        } catch (Exception e) {
            throw new BadRequestException("Email " + employee.getEmail() + " is already exists");
        }
    }

    @Override
    public Employee update(Employee employee) {
        try {
            return repo.save(employee);
        } catch (Exception e) {
            throw new BadRequestException("Email " + employee.getEmail() + " is already exists");
        }
    }

    @Override
    public void delete(String employeeId) {
        if (!repo.existsById(employeeId)) {
            throw new NotFoundException("Not found id " + employeeId);
        }
        repo.deleteById(employeeId);
    }
}
