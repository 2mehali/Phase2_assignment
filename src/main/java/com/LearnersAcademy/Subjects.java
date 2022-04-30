package com.LearnersAcademy;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="subject_table")
public class Subjects {
	
		@Id
		@GeneratedValue
		private int subject_id;
		
		@Column(name="subject_name")
		private String name;
		
		@ManyToOne(cascade= CascadeType.ALL)
		@JoinColumn(name="teacher_id")
		private Teachers teacher;
		
		@ManyToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="class_id")
		private Classes classes;

		public Classes getClasses() {
			return classes;
		}

		public void setClasses(Classes classes) {
			this.classes = classes;
		}

		public int getSubject_id() {
			return subject_id;
		}

		public void setSubject_id(int subject_id) {
			this.subject_id = subject_id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Teachers getTeacher() {
			return teacher;
		}

		public void setTeacher(Teachers teacher) {
			this.teacher = teacher;
		}

				
		

}
