package com.mob.sts.service;

import java.util.List;

import com.mob.sts.module.Student;

public interface StudentService {
	
	List<Student> getStudents();

	Student getStudent(Long id)  ;

	String deleteStudent(Long id);
	
	Student saveStudent(Student student);


	Student updateStudent(Student student);

}
