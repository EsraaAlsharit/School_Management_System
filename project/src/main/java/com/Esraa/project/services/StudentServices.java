package com.Esraa.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Esraa.project.models.Student;
import com.Esraa.project.repositories.StudentRepository;

@Service
public class StudentServices {
	@Autowired
	public StudentRepository studentRepository;

	// returns all the students
	public List<Student> allStudents() {
		return studentRepository.findAll();
	}

	public Student createStudent(Student b) {
		return studentRepository.save(b);
	}

	// retrieves a student
	public Student findStudentBy(Long id) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
		if (optionalStudent.isPresent()) {
			return optionalStudent.get();
		} else {
			return null;
		}
	}

	public Student updateStudent(Long id, Student student) {
		Student optionalStudent = findStudentBy(id);
		return studentRepository.save(optionalStudent);

	}

	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}

}
