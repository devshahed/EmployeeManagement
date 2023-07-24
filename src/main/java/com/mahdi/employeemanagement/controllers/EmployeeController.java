package com.mahdi.employeemanagement.controllers;

import com.mahdi.employeemanagement.requests.EmployeeRequest;
import com.mahdi.employeemanagement.responses.EmployeeResponse;
import com.mahdi.employeemanagement.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //Create
    @PostMapping
    public ResponseEntity<EmployeeResponse> addEmployee(@Valid @RequestBody EmployeeRequest employeeRequest){
        return new ResponseEntity<>(employeeService.addEmployee(employeeRequest), HttpStatus.CREATED);
    }

    //Read
    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAllEmployee(){
        return ResponseEntity.ok(employeeService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable("id") Long id){
        return ResponseEntity.ok(employeeService.getById(id));
    }

    //Update
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployeeById(@PathVariable("id") Long id, @Valid @RequestBody EmployeeRequest employeeRequest){
        return new ResponseEntity<>(employeeService.updateEmployee(employeeRequest, id), HttpStatus.CREATED);
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long id){
        employeeService.deleteById(id);
        return ResponseEntity.ok("Employee deleted successfully.");
    }
}
