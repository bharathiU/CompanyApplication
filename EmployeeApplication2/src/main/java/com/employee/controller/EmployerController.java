package com.employee.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.employee.entities.Employer;
import com.employee.model.service.EmployerService;
@RestController
public class EmployerController {
	private EmployerService employerservice;
	  @Autowired 
	  public EmployerController(EmployerService employerservice) {
	  this.employerservice = employerservice; 
	  }
	  
	  @GetMapping(path = "/manager", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Employer>> getAllEmployers() {
			return new ResponseEntity<List<Employer>>(employerservice.findAll(), HttpStatus.OK);
		}
	  @GetMapping(path = "/manager/{id}", produces =MediaType.APPLICATION_JSON_VALUE) 
	  public ResponseEntity<Employer>getAnEmployer(@PathVariable(name = "id") Long id) {
		  Employer employer = employerservice.findEmployerById(id); 
		  return new ResponseEntity<Employer>(employer, HttpStatus.OK); 
	  }
	 
	  @GetMapping(path = "/managername/{name}", produces =MediaType.APPLICATION_JSON_VALUE) 
	  public ResponseEntity<Employer>getAnEmployerByName(@PathVariable(name = "name") String name) {
		  Employer employer = employerservice.findEmployerByName(name); 
		  return new ResponseEntity<Employer>(employer, HttpStatus.OK); 
	  }

}

