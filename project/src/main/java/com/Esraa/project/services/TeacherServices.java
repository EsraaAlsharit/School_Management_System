package com.Esraa.project.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import com.Esraa.project.models.LoginUser;
import com.Esraa.project.models.Teacher;
import com.Esraa.project.repositories.StudentRepository;
import com.Esraa.project.repositories.TeacherRepository;
import com.Esraa.project.repositories.UserRepo;

@Service
public class TeacherServices {
	@Autowired
	public TeacherRepository teacherRepository;
	@Autowired
	public StudentRepository studentRepository;
	@Autowired
	public UserRepo userRepo;

	// returns all the teachers
	public List<Teacher> allTeachers() {
		return teacherRepository.findAll();
	}

	public Teacher createTeacher(Teacher b) {
		return teacherRepository.save(b);
	}

	// retrieves a teacher
	public Teacher findTeacherBy(Long id) {
		Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
		if (optionalTeacher.isPresent()) {
			return optionalTeacher.get();
		} else {
			return null;
		}
	}

	public Teacher updateTeacher(Long id, Teacher teacher) {
		Teacher optionalTeacher = findTeacherBy(id);
		return teacherRepository.save(optionalTeacher);
	}

	public void deleteTeacher(Long id) {
		teacherRepository.deleteById(id);
	}

	public Teacher login(LoginUser newLogin, BindingResult result) {
		if (result.hasErrors()) {
			return null;
		}
		Optional<Teacher> potentialTeacher = teacherRepository.findByEmail(newLogin.getEmail());
		if (!potentialTeacher.isPresent()) {
			result.rejectValue("email", "Unique", "Unknown email!");
			return null;
		}
		Teacher user = potentialTeacher.get();
		if (!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Password!");
		}
		if (result.hasErrors()) {
			return null;
		} else {
			return user;
		}
	}

}
