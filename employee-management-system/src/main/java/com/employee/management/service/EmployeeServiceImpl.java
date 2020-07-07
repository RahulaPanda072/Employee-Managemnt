package com.employee.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.dao.EmployeeDao;
import com.employee.management.exception.EmployeeException;
import com.employee.management.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public Employee getEmployee(int id) throws EmployeeException {
		return employeeDao.getEmployee(id);
	}

	@Override
	public void addEmployee(List<Employee> e) throws EmployeeException {
		employeeDao.addEmployee(e);
	}

	@Override
	public long getEmployee(int id, int dept) throws EmployeeException {
		return employeeDao.getEmployee(id,dept);
	}

}
