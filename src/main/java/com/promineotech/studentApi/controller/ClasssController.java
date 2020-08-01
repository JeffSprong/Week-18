package com.promineotech.studentApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.studentApi.entity.Classs;
import com.promineotech.studentApi.service.ClasssService;

@RestController
@RequestMapping("/class")
public class ClasssController {
	
	@Autowired
	private ClasssService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getClassses() {
		return new ResponseEntity<Object>(service.getClassses(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{classsId}", method=RequestMethod.GET)
	public ResponseEntity<Object> getClasssById(@PathVariable Long classsId) throws Exception { //check
		return new ResponseEntity<Object>(service.getClasssById(classsId), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{classsId}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateClasss(@RequestBody Classs classs, @PathVariable Long classsId) {
		try {
			return new ResponseEntity<Object>(service.updateClasss(classs, classsId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createClasss(@RequestBody Classs classs) {
		try {
			return new ResponseEntity<Object>(service.createClasss(classs), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/{classsId}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteclasss(@PathVariable Long classsId) throws Exception { // check
		service.deleteClasss(classsId);
		return new ResponseEntity<Object>("Deleted class with id: " + classsId, HttpStatus.OK);
	}

	
	@RequestMapping(value="/{classsId}/addStudent/{studentId}", method=RequestMethod.POST)
	public ResponseEntity<Object> addStudent(@RequestBody Long classsId, Long studentId) {
		try {
			return new ResponseEntity<Object>(service.addStudent(classsId, studentId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}