package com.promineotech.studentApi.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.studentApi.entity.Absent;
import com.promineotech.studentApi.entity.Student;
import com.promineotech.studentApi.repository.AbsentRepository;
import com.promineotech.studentApi.repository.StudentRepository;

@Service
public class AbsentService {
	
	private static final Logger logger = LogManager.getLogger(AbsentService.class);

	@Autowired
	private AbsentRepository repo;
	
	@Autowired
	private StudentRepository studentRepo;
	
	public Absent getAbsentById(Long id) throws Exception {
		try {
			return repo.findOne(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to retrieve absence: " + id, e);
			throw e;
		}
	}
		
	public Iterable<Absent> getAbsences(Long id) {
		return repo.findByStudentId(id);
		
	}
	
	public Absent createAbsent(Absent absent, Long studentId, Long classsId) {
		Student student = studentRepo.findOne(studentId);
		absent.setStudent(student);
		student.getAbsences().add(absent);
		return repo.save(absent);
	}
	
	public Absent updateAbsent(Absent absent, Long id) throws Exception {
		try {
			Absent oldAbsent = repo.findOne(id);
			oldAbsent.setStudent(absent.getStudent());
			oldAbsent.setClasss(absent.getClasss());
			oldAbsent.setDate(absent.getDate());
			return repo.save(oldAbsent);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to update absence: " + id, e);
			throw new Exception ("Unable to update absence.");
		}
	}
	
	public void deleteAbsent(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to delete absence: " + id, e);
			throw new Exception("Unable to delete absence.");
		}
	}
}
