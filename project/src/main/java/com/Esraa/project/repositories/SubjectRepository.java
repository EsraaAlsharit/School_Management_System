package com.Esraa.project.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.Esraa.project.models.Student;
import com.Esraa.project.models.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Long> {

    List<Subject> findAll();

    int countByStudents(Student student);
}
