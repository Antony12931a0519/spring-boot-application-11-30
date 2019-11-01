package com.javatraining0.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javatraining0.application.entities.Student;
import com.javatraining0.application.models.StudentModel;
import com.javatraining0.application.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/studentlist",
			produces = "application/json",
			method = { RequestMethod.GET })
	public List<StudentModel> getstudentslist() {

		return studentService.getStudents();
	}
	
	@RequestMapping(value = "/studentdestails",
			        produces = "application/json",
					consumes = "application/json",
			method = { RequestMethod.POST })
	public Student getStudentById(@RequestBody StudentModel studentModel) {

		return studentService.getStudentDetailsById(studentModel.getSid());
	}
	
	@RequestMapping(value = "/studentdestails/address",
	        produces = "application/json",
			consumes = "application/json",
	method = { RequestMethod.POST })
public List<Student> getStudentByAdress(@RequestBody StudentModel studentModel) {

return studentService.getStudentDetailsByAddress(studentModel.getAddress());
}

}