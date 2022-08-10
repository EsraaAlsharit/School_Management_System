package com.Esraa.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.Esraa.project.models.Manager;

public interface ManagerRepository extends CrudRepository<Manager, Long> {

    List<Manager> findAll();

	Optional<Manager> findByUserName(String UserName);


}
