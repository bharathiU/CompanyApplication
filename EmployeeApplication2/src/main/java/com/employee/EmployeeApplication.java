package com.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.employee.entities.Employee;
import com.employee.entities.Employer;
import com.employee.repository.EmployeeRepository;
import com.employee.repository.EmployerRepository;

@SpringBootApplication
public class EmployeeApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployerRepository employerRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
