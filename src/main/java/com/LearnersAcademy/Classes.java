package com.LearnersAcademy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

import javax.persistence.CascadeType;

@Entity
@Table(name="class_table")
public class Classes {

	@Id
	@GeneratedValue
	private int class_id;
	
	@Column(name="class_name")
	private String name;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy="classes")
	private List<Students> students;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy="classes")
	private List<Subjects> subjects;
	
	public List<Students> getStudents() {
		return students;
	}

	public void setStudents(List<Students> students) {
		this.students = students;
	}

	public List<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}