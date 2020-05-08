package com.employee.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.employee.entities.Employee;
import com.employee.model.service.EmployeeService;

@RestController
public class EmployeeController {
	private EmployeeService empservice;

	@Autowired
	public EmployeeController(EmployeeService empservice) {
		this.empservice = empservice;
	}

	@GetMapping(path = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return new ResponseEntity<List<Employee>>(empservice.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/employe/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getAnEmployeeById(@PathVariable(name = "id") Long id) {
		Employee employee1 = empservice.findById(id);
		return new ResponseEntity<Employee>(employee1, HttpStatus.OK);

	}

	@GetMapping(path = "/employee/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployeeByName(@PathVariable(name = "name") String name) {
		Employee employee = empservice.findByName(name);
		return new ResponseEntity<Employee>(empservice.findByName(name), HttpStatus.FOUND);
	}

	@GetMapping(path = "/employee/range/{salary}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getEmployeeBySalaryrange(@PathVariable(name = "salary") double salary) {
		return new ResponseEntity<List<Employee>>(empservice.Salaryrange(salary), HttpStatus.OK);
	}
}
