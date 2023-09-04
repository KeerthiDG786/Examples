package com.mob.sts.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mob.sts.module.AuthenticateRequest;
import com.mob.sts.module.Student;
import com.mob.sts.service.JwtService;
import com.mob.sts.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/")
public class StudentController {

	private final static Logger logger=LoggerFactory.getLogger(StudentController.class.getName());

	@Autowired 
	StudentService studentService;
	
	@Autowired
	private JwtService jwtService;
	 
	@GetMapping(value="sts")
	public ResponseEntity<Object> getStudents()
	{
		List<Student> student=studentService.getStudents();
		if(!student.isEmpty())
		{

			logger.info("Student details found");
			return new ResponseEntity<>(student,HttpStatus.OK); 
		}
		else
		{
			logger.error("no details found");
			return new ResponseEntity<>(new Failur("details not found",401),HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value="sts/{id}",produces="application/json; charset=utf-8")
	@PreAuthorize("hasRole('User')")
	public ResponseEntity<Object> getStudent(@PathVariable Long id) 
	{
		Student student=studentService.getStudent(id);
    
		if(student!=null)
		{
			logger.info("get by id");
			return new ResponseEntity<>(student,HttpStatus.OK);
		}
		
		else
		{
			
			logger.info("details not found for id"+id);
			return new ResponseEntity<>(new Failur("details not found for id "+id,401) ,HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping(value="sts/{id}")
	@PreAuthorize("hasRole('User')")
	public ResponseEntity<Object> deleteStudent(@PathVariable Long id) 
	{		
		Student student=studentService.getStudent(id);
		
         if(student!=null)
         {
		  studentService.deleteStudent(id);
		 return new ResponseEntity<>("Data deleted successfully with id",HttpStatus.OK);
		 //data deleted successfully
		 //hiii
         }
         
		
			return new ResponseEntity<>(new Failur("details not found for id"+id,401),HttpStatus.BAD_REQUEST);

	}

	@PostMapping(value="sts")
	public ResponseEntity<Object> saveStudent(@Valid @RequestBody Student student)
	{
		System.out.println(student);
          if(student!=null)
          {
		studentService.saveStudent(student);
		return new ResponseEntity<Object>("data created successfully with the id  "+student.getId(),HttpStatus.CREATED);
          }
			return new ResponseEntity<Object>(new Failur("enter all the details properly",204),HttpStatus.BAD_REQUEST);
	}

	@PutMapping(value="sts/{id}")	
	public ResponseEntity<Object> updateEmployee(@PathVariable Long id,@RequestBody Student student)
	{
		student.setId(id);
		Student student1=studentService.getStudent(id);

        if(student1!=null)
        {
        	student=studentService.updateStudent(student);
    		return new ResponseEntity<>(student,HttpStatus.OK);

        }
        else
        {
			return new ResponseEntity<Object>(new Failur("details not found for id "+id,401),HttpStatus.BAD_REQUEST);
        }

	}
	
	@PostMapping(value="/authenticate")
	public String AuthenticateAndGenereteToken(@RequestBody AuthenticateRequest authenticateRequest)
	{
		System.out.println("authentication");
		return  jwtService.getToken(authenticateRequest.getUserName());
	}


}
