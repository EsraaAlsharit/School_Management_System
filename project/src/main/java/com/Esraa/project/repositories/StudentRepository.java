package com.Esraa.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.Esraa.project.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{

	List<Student> findAll();
	
    Optional<Student> findByEmail(String email);

}
