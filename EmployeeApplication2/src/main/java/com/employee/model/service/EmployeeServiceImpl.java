package com.employee.model.service;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.entities.Employee;
import com.employee.exceptions.EmployeeNotFoundException;
import com.employee.repository.EmployeeRepository;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository emprepo;
	List<Employee> Salaryrange = new ArrayList<Employee>();
	@Override
	public List<Employee> findAll() {
		return emprepo.findAll();
	}
	@Override
	public List<Employee> Salaryrange(double salary) {
		for (Employee e : findAll()) {
			if (e.getSalary() > salary) {
				Salaryrange.add(e);
			}
		}
		return Salaryrange;
	}
	@Override
	public Employee findByName(String name) {
		return emprepo.findByName(name)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found " +name));
	}
	@Override
	public Employee findById(Long id) {
		return emprepo.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found " +id));
	}
}
