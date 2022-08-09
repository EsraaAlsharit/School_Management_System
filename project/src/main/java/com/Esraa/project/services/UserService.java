package com.Esraa.project.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.Esraa.project.models.LoginUser;
import com.Esraa.project.models.Student;
import com.Esraa.project.models.Teacher;
import com.Esraa.project.models.User;
import com.Esraa.project.repositories.StudentRepository;
import com.Esraa.project.repositories.TeacherRepository;
import com.Esraa.project.repositories.UserRepo;

@Service
public class UserService {
	@Autowired
	UserRepo userRepo;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	TeacherRepository teacherRepository;

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

	public User register(User newUser, BindingResult result) {
		if (userRepo.findByEmail(newUser.getEmail()).isPresent()) {
			result.rejectValue("email", "Unique", "This email is already in use!");
		} else if (studentRepository.findByEmail(newUser.getEmail()).isPresent()) {
			result.rejectValue("email", "Unique", "This email is already in use!");
		} else if (teacherRepository.findByEmail(newUser.getEmail()).isPresent()) {
			result.rejectValue("email", "Unique", "This email is already in use!");
		}
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
		}
		if (result.hasErrors()) {
			return null;
		} else {
			String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashed);
			return userRepo.save(newUser);
		}
	}

	public User login(LoginUser newLogin, BindingResult result) {
		if (result.hasErrors()) {
			return null;
		}
		Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
		Optional<Teacher> potentialTeacher = teacherRepository.findByEmail(newLogin.getEmail());
		Optional<Student> potentialStudent = studentRepository.findByEmail(newLogin.getEmail());
		if (!potentialUser.isPresent()) {
			result.rejectValue("email", "Unique", "Unknown email!");
			return null;
		} else if (!potentialTeacher.isPresent()) {
			result.rejectValue("email", "Unique", "Unknown email!");
			return null;
		} else if (!potentialStudent.isPresent()) {
			result.rejectValue("email", "Unique", "Unknown email!");
			return null;
		}

		User user = potentialUser.get();
		if (!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Password!");
		}
		Teacher teacher = potentialTeacher.get();
		if (!BCrypt.checkpw(newLogin.getPassword(), teacher.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Password!");
		}
		Student student = potentialStudent.get();
		if (!BCrypt.checkpw(newLogin.getPassword(), student.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Password!");
		}
		if (result.hasErrors()) {
			return null;
		} else {
			return user;
		}
	}

}
