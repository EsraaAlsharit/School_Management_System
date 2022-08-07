package com.Esraa.project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Esraa.project.models.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {

	List<Teacher> findAll();

}
