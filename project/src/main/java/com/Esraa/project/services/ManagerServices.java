package com.Esraa.project.services;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.Esraa.project.models.LoginManager;
import com.Esraa.project.models.LoginUser;
import com.Esraa.project.models.Manager;
import com.Esraa.project.models.Student;
import com.Esraa.project.models.Teacher;
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

	public Manager register(Manager newManager, BindingResult result) {
		if (managerRepo.findByUserName(newManager.getUserName()).isPresent()) {
			result.rejectValue("userName", "Unique", "This userName is already in use!");
		}
		if (result.hasErrors()) {
			return null;
		} else {
			String hashed = BCrypt.hashpw(newManager.getPassword(), BCrypt.gensalt());
			newManager.setPassword(hashed);
			return managerRepo.save(newManager);
		}

	}

	public Manager login(LoginManager newLogin, BindingResult result) {
		if (result.hasErrors()) {
			return null;
		}
		Optional<Manager> potentialUser = managerRepo.findByUserName(newLogin.getUserName());
		if (!potentialUser.isPresent()) {
			result.rejectValue("userName", "Unique", "Unknown UserName!");
			return null;
		}
		Manager Manager = potentialUser.get();
		if (!BCrypt.checkpw(newLogin.getPassword(), Manager.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Password!");
		}
		if (result.hasErrors()) {
			return null;
		} else {
			return Manager;
		}
	}

}
