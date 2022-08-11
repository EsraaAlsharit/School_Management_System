package com.Esraa.project.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.Esraa.project.models.LoginUser;

import com.Esraa.project.models.Student;
import com.Esraa.project.models.Subject;
import com.Esraa.project.repositories.StudentRepository;
import com.Esraa.project.repositories.TeacherRepository;

@Service
public class StudentServices {
	@Autowired
	public StudentRepository studentRepository;
	// @Autowired
	// public GuardiansRepo guardiansRepo;
	@Autowired
	public TeacherRepository teacherRepository;

	// returns all the students
	public List<Student> allStudents() {
		return studentRepository.findAll();
	}

	public Student createStudent(Student b) {
		return studentRepository.save(b);
	}

	// public int subjectsCount(Student b) {
	// return studentRepository.countBySubjects(b);
	// }

	// retrieves a student
	public Student findStudentBy(Long id) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
		if (optionalStudent.isPresent()) {
			return optionalStudent.get();
		} else {
			return null;
		}
	}

	public Student addSubjects(Subject subject, Student student) {
		student.setSubjects(subject);
		return studentRepository.save(student);

	}

	public Student updateStudent(Long id, Student student) {
		Student optionalStudent = findStudentBy(id);
		return studentRepository.save(optionalStudent);

	}

	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}

	public Student login(LoginUser newLogin, BindingResult result) {
		if (result.hasErrors()) {
			return null;
		}
		Optional<Student> potentialStudent = studentRepository.findByEmail(newLogin.getEmail());
		if (!potentialStudent.isPresent()) {
			result.rejectValue("email", "Unique", "Unknown email!");
			return null;
		}
		Student user = potentialStudent.get();
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
