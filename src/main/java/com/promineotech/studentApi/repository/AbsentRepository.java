package com.promineotech.studentApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.studentApi.entity.Absent;

public interface AbsentRepository extends CrudRepository<Absent, Long> {
	
	public Iterable<Absent> findByStudentId(Long studentId);

}
