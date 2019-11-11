package com.javatraining0.application.service.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.javatraining0.application.dao.StudentDAO;
import com.javatraining0.application.dao.StudentDAO1;
import com.javatraining0.application.entities.Student;
import com.javatraining0.application.models.StudentModel;
import com.javatraining0.application.security.configuration.ProjectSpecificException;
import com.javatraining0.application.service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

	@InjectMocks
	StudentService studentService;
	@Mock
	StudentDAO studentDAO;
	
	@Mock
	StudentDAO1 studentDAO1;
	
	@Mock
	JdbcTemplate jdbcTemplate;

	@Before
	public void setUp() {
		// this indicates the current class objects
		MockitoAnnotations.initMocks(this);
	}

	
	@Test
	public void testGetStudentsForSuccess() {

		try {
			// ECLEMMA
			List<Student> students = new ArrayList<Student>();
			Student student = new Student();
			student.setAddress("India");
			student.setDept("qfqwd");
			student.setFacultyId("jfkle");
			student.setName("Antony");
			students.add(student);

			Mockito.doNothing().when(studentDAO1).dummy();
			Mockito.when(studentDAO.findAll()).thenReturn(students);

			// Mockito.when(method2).thenReturn(retun type of m2);
			List<StudentModel> studentsList = studentService.getStudents();
//			Assert.assertEquals(1, studentsList.size());
			Assert.assertEquals("Antony", studentsList.get(0).getName());
			Assert.assertEquals("India", studentsList.get(0).getAddress());
		} catch (InterruptedException e) {

			e.printStackTrace();
		} catch (ProjectSpecificException e) {

			e.printStackTrace();
		}
	}
	
	/*@Test
	public void testGetStudentsForSuccess1() {

		
			// ECLEMMA
			List<Student> students = new ArrayList<Student>();
			Student student = new Student();
			student.setAddress("India");
			student.setDept("qfqwd");
			student.setFacultyId("jfkle");
			student.setName("Antony");
			students.add(student);

			Mockito.when(studentDAO.findAll()).thenReturn(students);
			
//			Mockito.when(studentDAO.findAll()).thenReturn(null);
//			Mockito.doNothing().when(studentDAO).findAll();
			
//			Mockito.doThrow(Exception.class).when(studentDAO.findAll());
			// Mockito.when(method2).thenReturn(retun type of m2);
			List<StudentModel> studentsList = studentService.getStudents();
//			Assert.assertEquals(1, studentsList.size());
			Assert.assertEquals("Antony", studentsList.get(0).getName());
			Assert.assertEquals("India", studentsList.get(0).getAddress());
		
	}*/

	@Test
	public void testGetStudentsUsingJdbcTeplate() throws InterruptedException {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		Mockito.when(jdbcTemplate.queryForList(Matchers.any(String.class)))
				.thenReturn(list);

		// Mockito.when(method2).thenReturn(retun type of m2);
		studentService.getStudentsUsingJdbcTeplate();

	}

	@Test(expected = ProjectSpecificException.class)
	public void testGetStudentsForExceptionScenario()
			throws InterruptedException, ProjectSpecificException {

		List<Student> students = new ArrayList<Student>();
		Mockito.when(studentDAO.findAll()).thenReturn(students);

		// Mockito.when(method2).thenReturn(retun type of m2);
		studentService.getStudents();

	}

}
