package com.Esraa.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Esraa.project.models.Subject;
import com.Esraa.project.repositories.SubjectRepository;

@Service
public class SubjectServices {

	@Autowired
	SubjectRepository subjectRepository;

	public Subject findGuardianBy(Long id) {
		Optional<Subject> optionalExpense = subjectRepository.findById(id);
		if (optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}

	public List<Subject> findSubjects() {
		return subjectRepository.findAll();
	}

	public void creatSubject(Subject subject) {
		subjectRepository.save(subject);
	}

}
