package com.promineotech.studentApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.studentApi.entity.Grade;
import com.promineotech.studentApi.service.GradeService;

@RestController
@RequestMapping("/students/{studentId}/grades")
public class GradeController {
	
	@Autowired
	private GradeService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getGrades(@PathVariable Long studentId) {
		return new ResponseEntity<Object>(service.getGrades(studentId), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{gradeId}", method=RequestMethod.GET)
	public ResponseEntity<Object> getGradeById(@PathVariable Long gradeId) throws Exception {
		return new ResponseEntity<Object>(service.getGradeById(gradeId), HttpStatus.OK);
			
		}	
		
	@RequestMapping(value="/{gradeId}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updategrade(@RequestBody Grade grade, @PathVariable Long gradeId) {
		try {
			return new ResponseEntity<Object>(service.updateGrade(grade, gradeId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createGrade(@RequestBody Grade grade, @PathVariable Long studentId, Long classsId) {
		try {
			return new ResponseEntity<Object>(service.createGrade(grade, studentId, classsId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/{gradeId}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteGrade(@PathVariable Long gradeId) throws Exception {
		service.deleteGrade(gradeId);
		return new ResponseEntity<Object>("Deleted grade with id: " + gradeId, HttpStatus.OK);
	}
}