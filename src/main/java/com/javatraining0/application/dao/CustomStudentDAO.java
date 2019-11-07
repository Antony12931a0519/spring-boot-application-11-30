package com.javatraining0.application.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.javatraining0.application.entities.Student;

@Repository
public class CustomStudentDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Student> findSudentDetails() {

		Query query = entityManager.
				createNativeQuery("select * from student","mapppinNativeQuery");
		
		
		return query.getResultList();

	}

}
