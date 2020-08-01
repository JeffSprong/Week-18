package com.promineotech.studentApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.studentApi.entity.Absent;
import com.promineotech.studentApi.service.AbsentService;

@RestController
@RequestMapping("/students/{studentId}/absences")
public class AbsentController {
	
	@Autowired
	private AbsentService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getAbsences(@PathVariable Long studentId) {
		return new ResponseEntity<Object>(service.getAbsences(studentId), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{absentId}", method=RequestMethod.GET)
	public ResponseEntity<Object> getAbsentById(@PathVariable Long absentId) throws Exception { // check
		return new ResponseEntity<Object>(service.getAbsentById(absentId), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{absentId}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateAbsent(@RequestBody Absent absent, @PathVariable Long absentId) {
		try {
			return new ResponseEntity<Object>(service.updateAbsent(absent, absentId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createAbsent(@RequestBody Absent absent, @PathVariable Long studentId, Long classsId) {
		try {
			return new ResponseEntity<Object>(service.createAbsent(absent, studentId, classsId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/{absentId}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteAbsent(@PathVariable Long absentId) throws Exception { // check
		service.deleteAbsent(absentId);
		return new ResponseEntity<Object>("Deleted absence with id: " + absentId, HttpStatus.OK);
	}
}