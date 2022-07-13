package com.learn.SpringbootMongodb.service.impl;

import com.learn.SpringbootMongodb.entity.Employee;
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
    public Employee getEmployeeById(String employeeId) {
        return repo.findById(employeeId).orElseThrow(() -> new NotFoundException("Not found id " + employeeId));
    }

    @Override
    public List<Employee> sortSalary(boolean isAsc) {
        return isAsc ? getEmployees().stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList())
                : getEmployees().stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
    }

    @Override
    public Employee insert(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public void delete(String employeeId) {
        repo.deleteById(employeeId);
    }
}
