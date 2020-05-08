package com.employee.model.service;
import java.util.List;
import com.employee.entities.Employer;
public interface EmployerService {
	public Employer findEmployerById(Long id);
	public List<Employer> findAll();
	public Employer findEmployerByName(String name);

}
