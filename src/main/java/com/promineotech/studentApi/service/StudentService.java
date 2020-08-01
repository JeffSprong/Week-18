package com.promineotech.studentApi.service;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.studentApi.entity.Student;
import com.promineotech.studentApi.repository.StudentRepository;


@Service
public class StudentService {
	
	private static final Logger logger = LogManager.getLogger(StudentService.class);

	@Autowired
	private StudentRepository repo;
	
	public Student getStudentById(Long id) throws Exception {
		try {
			return repo.findOne(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to retrieve student: " + id, e);
			throw e;
		}
	}
	
	public Iterable<Student> getStudents() {
		return repo.findAll();
	}
	
	public Student createStudent(Student student) {
		return repo.save(student);
	}
	
	public Student updateStudent(Student student, Long id) throws Exception {
		try {
			Student oldStudent = repo.findOne(id);
			oldStudent.setFirstName(student.getFirstName());
			oldStudent.setLastName(student.getLastName());
			oldStudent.setAddress(student.getAddress());
			oldStudent.setPhoneNumber(student.getPhoneNumber());
			oldStudent.setAge(student.getAge());
			return repo.save(oldStudent);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to update student: " + id, e);
			throw new Exception("Unable to update student.");
		}
	
	}
	
	public void deleteStudent(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			logger.error("Exception occured while trying to delete student: " + id,e);
			throw new Exception("Unable to delete student.");
		}
	}
}
