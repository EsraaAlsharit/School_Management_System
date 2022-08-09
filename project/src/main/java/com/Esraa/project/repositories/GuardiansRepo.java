package com.Esraa.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.Esraa.project.models.Guardians;
import com.Esraa.project.models.Student;


public interface GuardiansRepo extends CrudRepository<Guardians, Long> {

	List<Guardians> findAll();
	
	Optional<Guardians> findByEmail(String email);
}
