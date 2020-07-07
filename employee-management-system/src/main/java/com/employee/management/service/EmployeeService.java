package com.employee.management.service;

import java.util.List;

import com.employee.management.exception.EmployeeException;
import com.employee.management.model.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();

	public Employee getEmployee(int id) throws EmployeeException;

	public void addEmployee(List<Employee> e) throws EmployeeException;

	public Employee getEmployee(int id, int dept) throws EmployeeException;

}
