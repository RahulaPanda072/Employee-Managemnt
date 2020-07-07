package com.employee.management.dao;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.management.exception.EmployeeException;
import com.employee.management.model.Employee;
import com.employee.management.utils.EmployeeUtils;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EmployeeUtils employeeUtils;
	
	private static final Logger LOG = LoggerFactory.getLogger(EmployeeDaoImpl.class);
	
	public void addEmployee(List<Employee> employeeList) throws EmployeeException {
		try {
			File file = employeeUtils.checkAndCreateFile();
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

			// Write objects to file
			for (Employee employee : employeeList) {
				objectOutputStream.writeObject(employee);
			}
			objectOutputStream.close();
			fileOutputStream.close();
		} catch (IOException ie) {
			throw new EmployeeException("Exception while Inserting employee data", ie);
		}
	}

	public Employee getEmployee(int id) throws EmployeeException {
		BufferedReader inputStream = null;
		ObjectInputStream objectInputStream = null;
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			File file = employeeUtils.checkAndCreateFile();
			objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			while (true) {
				Employee employee = (Employee) objectInputStream.readObject();
				employeeList.add(employee);
			}
		} catch (IndexOutOfBoundsException ie) {
			throw new EmployeeException("Exception while fetching employee data", ie);
		} catch (EOFException io) {
			// Ignore EOF exception
		} catch (ClassNotFoundException | IOException e) {
			throw new EmployeeException("Exception while fetching employee data", e);
		} catch (Exception ex) {
			throw new EmployeeException("Exception while fetching employee data", ex);
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
				objectInputStream.close();
			} catch (IOException io) {
				LOG.error("Issue closing the Files" + io.getMessage());
			}
		}
		if(employeeList.size() > 0)
			return employeeList.stream().filter(e -> e.getEmployeeID() == id).collect(Collectors.toList()).get(0);
		else
			return null;
	}

	@Override
	public Employee getEmployee(int id, int dept) throws EmployeeException {
		BufferedReader inputStream = null;
		ObjectInputStream objectInputStream = null;
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			File file = employeeUtils.checkAndCreateFile();
			objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			while (true) {
				Employee employee = (Employee) objectInputStream.readObject();
				employeeList.add(employee);
			}
		} catch (IndexOutOfBoundsException ie) {
			throw new EmployeeException("Exception while fetching employee data", ie);
		} catch (EOFException io) {
			// Ignore EOF exception
		} catch (ClassNotFoundException | IOException e) {
			throw new EmployeeException("Exception while fetching employee data", e);
		} catch (Exception ex) {
			throw new EmployeeException("Exception while fetching employee data", ex);
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
				objectInputStream.close();
			} catch (IOException io) {
				LOG.error("Issue closing the Files" + io.getMessage());
			}
		}
		return employeeList.stream()
				.filter(e -> e.getEmployeeID() == id && e.getDept() == dept && e.getSalary() > 10000)
				.collect(Collectors.toList()).get(0);
	}

	public List<Employee> getAllEmployees() {

		BufferedReader inputStream = null;
		ObjectInputStream objectInputStream = null;
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			File file = employeeUtils.checkAndCreateFile();
			objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			while (true) {
				Employee employee = (Employee) objectInputStream.readObject();
				employeeList.add(employee);
			}
		} catch (EOFException io) {
			// Ignore EOF exception
		} catch (ClassNotFoundException | IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
				objectInputStream.close();
			} catch (IOException io) {
				LOG.error("Issue closing the Files" + io.getMessage());
			}
		}
		return employeeList;
	}
}
