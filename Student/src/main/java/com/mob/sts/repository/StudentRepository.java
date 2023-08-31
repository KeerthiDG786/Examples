package com.mob.sts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mob.sts.module.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
