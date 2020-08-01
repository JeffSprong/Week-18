package com.promineotech.studentApi.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.studentApi.entity.Grade;
import com.promineotech.studentApi.entity.Student;
import com.promineotech.studentApi.repository.GradeRepository;
import com.promineotech.studentApi.repository.StudentRepository;

@Service
public class GradeService {

	private static final Logger logger = LogManager.getLogger(GradeService.class);

	@Autowired
	private GradeRepository repo;
	
	@Autowired
	private StudentRepository studentRepo;
	
	public Grade getGradeById(Long id) throws Exception {
		try {
			return repo.findOne(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to retrieve Grade: " + id, e);
			throw e;
		}
	}
		
	public Iterable<Grade> getGrades(Long id) {
		return repo.findByStudentId(id);
		
	}
	
	public Grade createGrade(Grade grade, Long studentId, Long classsId) {
		Student student = studentRepo.findOne(studentId);
		grade.setStudent(student);
		student.getGrades().add(grade);
		return repo.save(grade);
	}
	
	public Grade updateGrade(Grade grade, Long id) throws Exception {
		try {
			Grade oldGrade = repo.findOne(id);
			oldGrade.setStudent(grade.getStudent());
			oldGrade.setClasss(grade.getClasss());
			oldGrade.setGrade(grade.getGrade());
			return repo.save(oldGrade);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to update grade: " + id, e);
			throw new Exception ("Unable to update grade.");
		}
	}
	
	public void deleteGrade(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to delete grade: " + id, e);
			throw new Exception("Unable to delete grade.");
		}
	}
}
