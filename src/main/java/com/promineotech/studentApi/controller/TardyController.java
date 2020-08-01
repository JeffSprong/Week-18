package com.promineotech.studentApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.studentApi.entity.Tardy;
import com.promineotech.studentApi.service.TardyService;

@RestController
@RequestMapping("/students/{studentId}/tardies")
public class TardyController {
	
	@Autowired
	private TardyService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getAllTardies(@PathVariable Long studentId) {
		return new ResponseEntity<Object>(service.getAllTardies(studentId), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{tardyId}", method=RequestMethod.GET)
	public ResponseEntity<Object> getTardy(@PathVariable Long tardyId) {
		return new ResponseEntity<Object>(service.getTardy(tardyId), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{tardyId}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateTardy(@RequestBody Tardy tardy, @PathVariable Long tardyId) {
		try {
			return new ResponseEntity<Object>(service.updateTardy(tardy, tardyId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createTardy(@RequestBody Tardy tardy, @PathVariable Long studentId, Long classsId) {
		try {
			return new ResponseEntity<Object>(service.createTardy(tardy, studentId, classsId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/{tardyId}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteTardy(@PathVariable Long tardyId) {
		service.deleteTardy(tardyId);
		return new ResponseEntity<Object>("Deleted tardy with id: " + tardyId, HttpStatus.OK);
	}
}
