package com.employee.model.service;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.entities.Employer;
import com.employee.exceptions.EmployerNotFoundException;
import com.employee.repository.EmployerRepository;
@Service
@Transactional
public class EmployerServiceImpl implements EmployerService{
	@Autowired
	private EmployerRepository emprepo;

	@Override
	public List<Employer> findAll() {
		return emprepo.findAll();
	}

	@Override
	public Employer findEmployerById(Long id) {
		return emprepo.findById(id)
				.orElseThrow(() -> new EmployerNotFoundException("Employer not found " +id));
		}

	@Override
	public Employer findEmployerByName(String name) {
		return emprepo.findByName(name)
				.orElseThrow(() -> new EmployerNotFoundException("Employer not found " +name));
	}
	 
}
