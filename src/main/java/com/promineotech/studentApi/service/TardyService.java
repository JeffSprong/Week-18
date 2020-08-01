package com.promineotech.studentApi.service;

//import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.studentApi.entity.Student;
import com.promineotech.studentApi.entity.Tardy;
import com.promineotech.studentApi.repository.StudentRepository;
import com.promineotech.studentApi.repository.TardyRepository;

@Service
public class TardyService {
	
	@Autowired
	private TardyRepository repo;
	
	@Autowired
	private StudentRepository studentRepo;
	

	public Iterable<Tardy> getAllTardies(Long id) {
		return repo.findByStudentId(id);
	}
	
	public Tardy getTardy(Long id) {
		return repo.findOne(id);
	}
	
	public Tardy updateTardy(Tardy tardy, Long id) throws Exception {
	Tardy foundTardy = repo.findOne(id);
	if (foundTardy == null) {
		throw new Exception("Tardy not found.");
	}
	foundTardy.setStudent(tardy.getStudent());
	foundTardy.setClasss(tardy.getClasss());
	foundTardy.setDate(tardy.getDate());
	return repo.save(foundTardy);
	}
	
	
	public Tardy createTardy(Tardy tardy, Long studentId, Long classsId) {
		Student student = studentRepo.findOne(studentId);
		tardy.setStudent(student);
		student.getTardies().add(tardy);
		return repo.save(tardy);
	}
	

	public void deleteTardy(Long id) {
		repo.delete(id);
	}

}
