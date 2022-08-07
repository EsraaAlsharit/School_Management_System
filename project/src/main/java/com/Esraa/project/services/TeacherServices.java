package com.Esraa.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Esraa.project.models.Teacher;
import com.Esraa.project.repositories.TeacherRepository;

@Service
public class TeacherServices {
	@Autowired
	public TeacherRepository teacherRepository;

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

	public Teacher updateTeacher(Long id, String title, String desc, String lang, Integer numOfPages) {
		Teacher optionalTeacher = findTeacherBy(id);

		// optionalTeacher.setTitle(title);
		// optionalTeacher.setDescription(desc);
		// optionalTeacher.setId(id);
		// optionalTeacher.setLanguage(lang);
		// optionalTeacher.setNumberOfPages(numOfPages);
		// Optional<Teacher> optionalTeacher1 = teacherRepository.findById(id);
		return teacherRepository.save(optionalTeacher);

	}

	public void deleteTeacher(Long id) {
		teacherRepository.deleteById(id);
	}

}
