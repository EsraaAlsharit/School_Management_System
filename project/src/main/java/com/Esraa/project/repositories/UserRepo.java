package com.Esraa.project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Esraa.project.models.User;

public interface UserRepo extends CrudRepository<User, Long> {

	List<User> findAll();
}
