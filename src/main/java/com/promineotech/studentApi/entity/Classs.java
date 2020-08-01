package com.promineotech.studentApi.entity;



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Classs {
	
	private Long id;
	private String name;
	private String description;
	private Set<Tardy> tardies;
	private Set<Absent> absences;
	private Set<Student> students;
	
	@JsonIgnore
	private Student student;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@OneToMany
	@JoinColumn(name = "tardyId")
	public Set<Tardy> getTardies() {
		return tardies;
	}
	public void setTardies(Set<Tardy> tardies) {
		this.tardies = tardies;
	}
	
	@OneToMany
	@JoinColumn(name = "absentId")
	public Set<Absent> getAbsences() {
		return absences;
	}
	public void setAbsences(Set<Absent> absences) {
		this.absences = absences;
	}
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_classs",
	  joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
	  inverseJoinColumns = @JoinColumn(name = "classs_id",
	  referencedColumnName = "id"))
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	

}
