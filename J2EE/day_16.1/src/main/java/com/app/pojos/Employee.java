package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "my_emp")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	
	private String name;
	
	@Column(name = "addr")
	private String address;
	
	private double salary;
	
	@Column(name = "deptId")
	private String department;
	
	@Column(name = "join_date")
	private LocalDate date;

	public Employee() {
	}

	/**
	 * @param name
	 * @param address
	 * @param salary
	 * @param department
	 * @param date
	 */
	public Employee(String name, String address, double salary, String department, LocalDate date) {
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.department = department;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getEmpId() {
		return empId;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", address=" + address + ", salary=" + salary
				+ ", department=" + department + ", date=" + date + "]";
	}
	
	
}
