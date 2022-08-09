package com.Esraa.project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Esraa.project.models.Manager;

public interface ManagerRepo extends CrudRepository<Manager, Long>{

	List<Manager> findAll();
	

}
