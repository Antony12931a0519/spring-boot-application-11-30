package com.javatraining0.application.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.javatraining0.application.dao.CustomStudentDAO;
import com.javatraining0.application.dao.StudentDAO;
import com.javatraining0.application.dao.StudentDAO1;
import com.javatraining0.application.entities.Student;
import com.javatraining0.application.models.StudentModel;
import com.javatraining0.application.security.configuration.ProjectSpecificException;

@Service
public class StudentService {
	@Autowired
	StudentDAO studentDAO;
	
	@Autowired
	StudentDAO1 studentDAO1;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	CustomStudentDAO customStudentDAO;

	/*
	 * @Autowired FacultyDAO studentDAO;
	 */
	// @Cacheable("studentslist")
	public List<StudentModel> getStudents() throws InterruptedException,
			ProjectSpecificException {

		List<StudentModel> list = new ArrayList<StudentModel>();
		List<Student> students = (List<Student>) studentDAO.findAll();

		studentDAO1.dummy();
		for (Student s : students) {

			StudentModel model = new StudentModel();
			model.setSid(s.getSid());
			model.setAddress(s.getAddress());
			model.setDept(s.getDept());
			model.setName(s.getName());
			list.add(model);
		}

		if (list.isEmpty())
			throw new ProjectSpecificException(
					"No details are existing in the system");

		return list;

	}

	public List<Map<String, Object>> getStudentsUsingJdbcTeplate()
			throws InterruptedException {
		List<Map<String, Object>> list = jdbcTemplate
				.queryForList("select * from student");
		System.out.println(list);
		return list;
	}

	public List<Student> getStudentsUsingEntityManager()
			throws InterruptedException {
		List<Student> list = customStudentDAO.findSudentDetails();

		return list;
	}

	public Student getStudentDetailsById(int studentid) {
		Optional<Student> student = studentDAO.findById(studentid);
		return student.get();
	}

	public List<Student> getStudentDetailsByAddress(String address) {
		List<Student> student = studentDAO.findStudentsByAddress(address);

		return student;
	}

	public List<String> customQueryForFetchingAddressBasedonentity() {
		Collection<String> addressList = studentDAO
				.customQueryForFetchingAddressBasedonentity();

		return (List<String>) addressList;
	}

	public List<String> customQueryForFetchingAddressusingEntityAndCriteria(
			String address) {
		Collection<String> addressList = studentDAO
				.customQueryForFetchingAddressusingEntityAndCriteria(address);

		return (List<String>) addressList;
	}

	public List<Student> customQueryForFetchingStudentRecordBasedOnMultipleCriteria(
			String address, String name) {
		Collection<Student> StudentsList = studentDAO
				.customQueryForFetchingStudentRecordBasedOnMultipleCriteria(
						address, name);

		return (List<Student>) StudentsList;
	}

	public List<Student> plainSqlQueryForFetchingStudentRecordsBasedOnCriteria() {
		Collection<Student> StudentsList = studentDAO
				.plainSqlQueryForFetchingStudentRecordsBasedOnCriteria();

		return (List<Student>) StudentsList;
	}

	public String createStudentDetails(StudentModel studentModel)
			throws Exception {

		String result = null;
		Student student = new Student();
		student.setAddress(studentModel.getAddress());
		student.setName(studentModel.getName());
		student.setDept(studentModel.getDept());
		// student.setFid(null);

		try {

			// pull the detils of faculty
			// fcultyao.find();
			student = studentDAO.save(student);
			if (student != null)
				result = "Student Details are created Succesfully.";
			else
				result = "Student Details are not created";

		} catch (Exception ex) {
			throw new Exception("Exception occured beacuase of :" + ex);

		}
		return result;

	}

	public String updateStudentDetails(StudentModel studentModel)
			throws Exception {

		String result = null;
		Optional<Student> optionalStudent = studentDAO.findById(studentModel
				.getSid());
		Student student = optionalStudent.get();

		student.setAddress(studentModel.getAddress());
		student.setName(studentModel.getName());
		student.setDept(studentModel.getDept());

		try {

			// pull the detils of faculty
			// fcultyao.find();
			student = studentDAO.save(student);
			if (student != null)
				result = "Student Details are updated Succesfully.";
			else
				result = "Student Details are not updated";

		} catch (Exception ex) {
			throw new Exception("Exception occured beacuase of :" + ex);

		}
		return result;

	}

	public String deleteStudentDetails(StudentModel studentModel)
			throws Exception {

		String result = null;
		Optional<Student> optionalStudent = studentDAO.findById(studentModel
				.getSid());
		Student student = optionalStudent.get();
		/*
		 * student.setAddress(studentModel.getAddress());
		 * student.setName(studentModel.getName());
		 * student.setDept(studentModel.getDept()); // student.setFid(null);
		 */
		try {

			// pull the detils of faculty
			// fcultyao.find();
			studentDAO.deleteById(student.getSid());

			result = "Student Details are deleted Succesfully.";

		} catch (Exception ex) {
			throw new Exception("Exception occured beacuase of :" + ex);

		}
		return result;

	}

}
