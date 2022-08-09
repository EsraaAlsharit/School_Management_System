package com.Esraa.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Esraa.project.models.Manager;
import com.Esraa.project.repositories.ManagerRepository;

@Service
public class ManagerServices {

	@Autowired
	ManagerRepository managerRepo;

	public List<Manager> allManagers() {
		return managerRepo.findAll();

	}

	public Manager createManager(Manager manag) {
		return managerRepo.save(manag);
	}

	public Manager findManagerBy(Long id) {
		Optional<Manager> optionalManager = managerRepo.findById(id);
		if (optionalManager.isPresent()) {
			return optionalManager.get();
		} else {
			return null;
		}
	}

	public Manager updateManager(Long id, Manager manager) {
		Manager optionalManager = findManagerBy(id);
		return managerRepo.save(optionalManager);

	}

	public void deleteManager(Long id) {
		managerRepo.deleteById(id);
	}

}