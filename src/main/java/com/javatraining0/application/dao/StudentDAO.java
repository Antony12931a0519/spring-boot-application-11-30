package com.javatraining0.application.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javatraining0.application.entities.Student;

@Repository
public interface StudentDAO extends CrudRepository<Student, Integer> {
	
	public List<Student> findStudentsByAddress(String address);

	public List<Student> findStudentsByName(String name);

	@Query("select s.address from Student s")
	public Collection<String> customQueryForFetchingAddressBasedonentity();

	@Query("select s.address from Student s where s.address=:address")
	public Collection<String> customQueryForFetchingAddressusingEntityAndCriteria(
			@Param("address") String address);

	@Query("select s from Student s where s.address=:address and s.name=:name")
	public Collection<Student> customQueryForFetchingStudentRecordBasedOnMultipleCriteria(
			@Param("address") String address, @Param("name") String name);

	//when ever we use plain sql queries
	@Query(value = "select * from Student where student_name = '1'", nativeQuery = true)
	public Collection<Student> plainSqlQueryForFetchingStudentRecordsBasedOnCriteria();

}
