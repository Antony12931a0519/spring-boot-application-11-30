package com.javatraining0.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatraining0.application.dao.StudentDAO;
import com.javatraining0.application.entities.Student;
import com.javatraining0.application.models.StudentModel;

@Service
public class StudentService {
	@Autowired
	StudentDAO studentDAO;

	public List<StudentModel> getStudents() {
		List<StudentModel> list = new ArrayList<StudentModel>();
		List<Student> students = (List<Student>) studentDAO.findAll();
		for (Student s : students) {

			StudentModel model = new StudentModel();
			model.setSid(s.getSid());
			model.setAddress(s.getAddress());
			model.setDept(s.getDept());
			model.setName(s.getName());
			list.add(model);
		}
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

}
