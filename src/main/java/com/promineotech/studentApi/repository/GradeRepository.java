package com.promineotech.studentApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.studentApi.entity.Grade;

public interface GradeRepository extends CrudRepository<Grade, Long> {
	
	public Iterable<Grade> findByStudentId(Long studentId);

}
