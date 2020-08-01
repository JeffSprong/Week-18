package com.promineotech.studentApi.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Student {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private int age;
	private Set<Tardy> tardies;
	private Set<Absent> absences;
	private Set<Grade> grades;
	
	private Set<Classs> classses;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@OneToMany(mappedBy = "student")
	public Set<Tardy> getTardies() {
		return tardies;
	}
	public void setTardies(Set<Tardy> tardies) {
		this.tardies = tardies;
	}
	@OneToMany(mappedBy = "student")
	public Set<Absent> getAbsences() {
		return absences;
	}
	public void setAbsences(Set<Absent> absences) {
		this.absences = absences;
	}
	
	@OneToMany(mappedBy = "student")
	public Set<Grade> getGrades() {
		return grades;
	}
	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}
	
	@ManyToMany(mappedBy = "students")
	public Set<Classs> getClassses() {
		return classses;
	}
	public void setClassses(Set<Classs> classses) {
		this.classses = classses;
	}

}
