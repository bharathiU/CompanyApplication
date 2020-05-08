package com.employee.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.employee.entities.Employer;
@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long>{
	public Optional<Employer> findEmployerById(Long id);
	public List<Employer> findAll();
	public Optional<Employer> findByName(String name);

}
