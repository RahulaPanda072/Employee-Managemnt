package com.employee.management.model;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = -1182244913641248148L;

	private int employeeID;

	private String firstName;

	private String lastName;

	private String gender;

	private int dept;

	private double salary;

	public Employee() {
		super();
	}

	public Employee(int employeeID, String firstName, String lastName, String gender, int dept, double salary) {
		super();
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dept = dept;
		this.salary = salary;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getDept() {
		return dept;
	}

	public void setDept(int dept) {
		this.dept = dept;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", dept=" + dept + ", salary=" + salary + "]";
	}

}
