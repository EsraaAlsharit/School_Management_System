package com.Esraa.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Esraa.project.repositories.StudentRepository;

@Service
public class StudentServices {
	@Autowired
	public StudentRepository studentRepository;
	
	
}
