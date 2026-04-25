package model;

public class Employee {
	private int empId;
	private String empName;
	private String department;
	private double salary;
	private String email;
	
	public Employee(int empId, String empName, String department, double salary, String email) {
		this.empId = empId;
		this.empName = empName;
		this.department = department;
		this.salary = salary;
		this.email = email;
	}
	
	public int getEmpId() {
		return empId;
	}
	public String getEmpName() {
		return empName;
	}
	public String getDepartment() {
		return department;
	}
	public double getSalary() {
		return salary;
	}
	public String getEmail() {
		return email;
	}
}