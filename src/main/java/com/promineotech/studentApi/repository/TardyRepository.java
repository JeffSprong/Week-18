package com.promineotech.studentApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.studentApi.entity.Tardy;

public interface TardyRepository extends CrudRepository<Tardy, Long> {

	public Iterable<Tardy> findByStudentId(Long studentId);
	
}
