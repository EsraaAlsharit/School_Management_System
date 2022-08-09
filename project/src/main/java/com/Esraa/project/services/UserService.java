package com.Esraa.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Esraa.project.models.Teacher;
import com.Esraa.project.models.User;
import com.Esraa.project.repositories.UserRepo;

@Service
public class UserService {
	@Autowired
	UserRepo userRepo;
public List<User> findAllUsers() {
	return userRepo.findAll();
}

public User findUserBy(Long id) {
	Optional<User> optionalTeacher = userRepo.findById(id);
	if (optionalTeacher.isPresent()) {
		return optionalTeacher.get();
	} else {
		return null;
	}
}
public void creatUsesr(User u) {
	userRepo.save(u);
	
}
public User updateTeacher(Long id, Teacher teacher) {
	User optionalUser = findUserBy(id);

	return userRepo.save(optionalUser);

}

public void deleteTeacher(Long id) {
	userRepo.deleteById(id);
}

}
