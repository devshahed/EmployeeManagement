package com.mahdi.employeemanagement.services.impl;

import com.mahdi.employeemanagement.entities.Employee;
import com.mahdi.employeemanagement.exceptions.ResourceNotFoundException;
import com.mahdi.employeemanagement.repositories.EmployeeRepository;
import com.mahdi.employeemanagement.requests.EmployeeRequest;
import com.mahdi.employeemanagement.responses.EmployeeResponse;
import com.mahdi.employeemanagement.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EmployeeResponse> getAll() {
        List<Employee> employees = employeeRepository.findAll();

        return employees
                .stream()
                .map(employee -> modelMapper.map(employee, EmployeeResponse.class))
                .toList();
    }

    @Override
    public EmployeeResponse getById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        return modelMapper.map(employee, EmployeeResponse.class);
    }

    @Override
    public EmployeeResponse addEmployee(EmployeeRequest employeeRequest) {
        Employee newEmployee = modelMapper.map(employeeRequest, Employee.class);
        Employee saved = employeeRepository.save(newEmployee);

        return modelMapper.map(saved, EmployeeResponse.class);
    }

    @Override
    public EmployeeResponse updateEmployee(EmployeeRequest employeeRequest, Long id) {
        employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        Employee employee = modelMapper.map(employeeRequest, Employee.class);
        employee.setId(id);

        Employee updated = employeeRepository.save(employee);

        return modelMapper.map(updated, EmployeeResponse.class);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        employeeRepository.deleteById(id);
    }
}
