package com.mob.sts.module;


import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Data
@Entity
@Table(name="Student_table")
public class Student {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="StudentId")
	private Long id;
	@NotNull(message = "name Should not be null")
	@Column(name="StudentName")
	private String name;
	@Column(name="StudentAge")
    @Min(20) @Max(90)
    @NotNull(message="age should not be null")
	private int age;
	@Column(name="StudentEmail")
	@NotNull(message="email shold not be null")
	private String email;
	
	
	/*
	 * @CreationTimestamp
	 * 
	 * @Column(name="Created_time",nullable=false,updatable = false) private Date
	 * created;
	 * 
	 * @UpdateTimestamp
	 * 
	 * @Column(name="updated_time") private Date updated;
	 */

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


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	/*S*/
	@Override public String toString() { return "Student [id=" + id + ", name=" +
	 name + ", age=" + age + ", email=" + email + "]"; }
	
}
