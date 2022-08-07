package com.Esraa.project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Esraa.ProjectManager.models.Project;
import com.Esraa.ProjectManager.models.User;
import com.Esraa.project.models.Student;



public interface StudentRepository extends CrudRepository<Student, Long>{

	List<Student> findAll();
	
	List<Student> findByMembersNotContaining(Student student);
}
