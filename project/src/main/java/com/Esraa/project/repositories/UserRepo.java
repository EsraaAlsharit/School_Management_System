package com.Esraa.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.Esraa.project.models.User;

public interface UserRepo extends CrudRepository<User, Long> {

	List<User> findAll();
	
	Optional<User> findByEmail(String email);
}
