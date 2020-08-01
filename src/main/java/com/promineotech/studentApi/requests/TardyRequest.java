package com.promineotech.studentApi.requests;

import com.promineotech.studentApi.entity.Classs;
import com.promineotech.studentApi.entity.Student;

public class TardyRequest {
	
	private Student student;
	private Classs classs;
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Classs getClasss() {
		return classs;
	}
	public void setClasss(Classs classs) {
		this.classs = classs;
	}

}
