package com.promineotech.studentApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.studentApi.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
