package com.mob.sts.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mob.sts.Exception.StudentDetailsNotFound;
import com.mob.sts.module.Student;
import com.mob.sts.repository.StudentRepository;

@Service
public class StudentServiceImplement implements StudentService{

	private static final Logger logger=LoggerFactory.getLogger(StudentServiceImplement.class.getName());

	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> getStudents() 
	{
		List<Student> student=null;
		try
		{
			student=studentRepository.findAll();
			
			return student;
		}
		catch(StudentDetailsNotFound e)
		{
			logger.info("no details for students");
			throw new StudentDetailsNotFound("error : details not found",HttpStatus.INTERNAL_SERVER_ERROR);
		}


	}

	@Override 
	public Student getStudent(Long id) 
	{
		System.out.println("hello");
		Optional<Student> student= studentRepository.findById(id);
				System.out.println(student);
				if(student.isPresent())
				{
	            	return student.get();
				}
				else
				{
					throw new NoSuchElementException();
				}


	}

	@Override 
	public String deleteStudent(Long id) 
	{
		Optional<Student> student= studentRepository.findById(id);
		if(student.isPresent())	
		{

			studentRepository.deleteById(id);
			return "details deleted success fully";

		}
		else
		{
			throw new StudentDetailsNotFound("details not present for id "+id,HttpStatus.BAD_REQUEST);
		}

	}

	@Override 
	public Student  saveStudent(Student student)
	{
		System.out.println(student);
		if(student!=null)
		{
			student =studentRepository.save(student);
			return student;
		}

		else
		{
			throw new StudentDetailsNotFound("details not present for ",HttpStatus.BAD_REQUEST);
		}

	}

	@Override
	public Student updateStudent(Student student)
	{
		studentRepository.save(student);
		return student;
	}


}
