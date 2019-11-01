package com.javatraining0.application.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javatraining0.application.entities.Student;

@Repository
public interface StudentDAO extends CrudRepository<Student, Integer>{
	
	public List<Student> findStudentsByAddress(String address);
	public List<Student> findStudentsByName(String name);

}
