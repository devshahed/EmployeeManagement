package com.mahdi.employeemanagement.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class EmployeeRequest {
    @NotEmpty(message = "Name should not be empty!")
    @Size(min = 3, max = 30, message = "Name must be at least 3 letters")
    private String name;
    @NotEmpty(message = "Phone should not be empty!")
    @Size(min = 11, max = 14, message = "Invalid phone number!")
    private String phone;
    @NotEmpty(message = "Country should not be empty!")
    private String country;
    @NotEmpty(message = "City should not be empty!")
    private String city;
    @NotNull
    private Integer salary;
    @NotEmpty(message = "Joining Date should not be empty!")
    private String joining_date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getJoining_date() {
        return joining_date;
    }

    public void setJoining_date(String joining_date) {
        this.joining_date = joining_date;
    }
}
