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

	public Student updateStudent(Long id, String title, String desc, String lang, Integer numOfPages) {
		// TODO Auto-generated method stub
		Student optionalStudent = findStudentBy(id);

		// optionalStudent.setTitle(title);
		// optionalStudent.setDescription(desc);
		// optionalStudent.setId(id);
		// optionalStudent.setLanguage(lang);
		// optionalStudent.setNumberOfPages(numOfPages);
		// Optional<Student> optionalStudent1 = studentRepository.findById(id);
		return studentRepository.save(optionalStudent);

	}

	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}

}
