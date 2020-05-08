package com.employee.model.service;
import java.util.List;
import com.employee.entities.Employee;
public interface EmployeeService {
	public List<Employee> Salaryrange(double salary);
	public List<Employee> findAll();
	public Employee findById(Long id);
	public Employee findByName(String name);
}
