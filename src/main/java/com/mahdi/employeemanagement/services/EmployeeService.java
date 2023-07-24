package com.mahdi.employeemanagement.services;

import com.mahdi.employeemanagement.requests.EmployeeRequest;
import com.mahdi.employeemanagement.responses.EmployeeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    //Get ALl Employees
    List<EmployeeResponse> getAll();

    //Get Single Employee
    EmployeeResponse getById(Long id);

    //Add Employee
    EmployeeResponse addEmployee(EmployeeRequest employeeRequest);

    //Update Employee
    EmployeeResponse updateEmployee(EmployeeRequest employeeRequest, Long id);

    //Delete Employee
    void deleteById(Long id);
}
