package com.employee.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.exception.EmployeeException;
import com.employee.management.model.Employee;
import com.employee.management.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {

	@Autowired
	EmployeeService employeeSerice;

	// fetching list of all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return employeeSerice.getAllEmployees();
	}

	// fetching employee by id
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable int id) throws EmployeeException {
		return employeeSerice.getEmployee(id);
	}

	// inserting employee data
	@PostMapping("/employees")
	public String addEmployees(@RequestBody List<Employee> employee) throws EmployeeException {
		employeeSerice.addEmployee(employee);
		return "Employee record added successfully";
	}

	// Get the Count of all employees by Department whose Salary is >=10000 .
	@GetMapping("/employees/{id}/{dept}")
	public Employee getEmployeeCount(@PathVariable int id, @PathVariable int dept) throws EmployeeException {
		return employeeSerice.getEmployee(id,dept);
	}
}
