package com.promineotech.studentApi.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.studentApi.entity.Classs;
import com.promineotech.studentApi.entity.Student;
import com.promineotech.studentApi.repository.ClasssRepository;
import com.promineotech.studentApi.repository.StudentRepository;

@Service
public class ClasssService {

	private static final Logger logger = LogManager.getLogger(ClasssService.class);

	@Autowired
	private ClasssRepository repo;
	
	@Autowired
	private StudentRepository studentRepo;
	
	public Classs getClasssById(Long id) throws Exception {
		try {
			return repo.findOne(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to retrieve class: " + id, e);
			throw e;
		}
	}
		
	public Iterable<Classs> getClassses() {
		return repo.findAll();
		
	}
	
	public Classs createClasss(Classs classs) {
		return repo.save(classs);
	}
	
	public Classs updateClasss(Classs classs, Long id) throws Exception {
		try {
			Classs oldClasss = repo.findOne(id);
			oldClasss.setName(classs.getName());
			oldClasss.setDescription(classs.getDescription());
			return repo.save(oldClasss);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to update class: " + id, e);
			throw new Exception ("Unable to update class.");
		}
	}
	
	public void deleteClasss(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to delete class: " + id, e);
			throw new Exception("Unable to delete class.");
		}
	}
	
	public Classs addStudent(Long classId, Long studentId) {
		Classs classs = repo.findOne(classId);
		Student student = studentRepo.findOne(studentId);
		classs.getStudents().add(student);
		student.getClassses().add(classs);
		repo.save(classs);
		studentRepo.save(student);
		return classs;
	}
}
