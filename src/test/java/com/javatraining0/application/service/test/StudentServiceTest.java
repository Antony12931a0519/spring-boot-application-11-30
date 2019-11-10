package com.javatraining0.application.service.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.javatraining0.application.entities.Student;
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
			student.setAddress("hj,j");
			student.setDept("qfqwd");
			student.setFacultyId("jfkle");
			student.setName("kugyioj");
			students.add(student);

			Mockito.when(studentDAO.findAll()).thenReturn(students);

			// Mockito.when(method2).thenReturn(retun type of m2);
			studentService.getStudents();
		} catch (InterruptedException e) {

			e.printStackTrace();
		} catch (ProjectSpecificException e) {

			e.printStackTrace();
		}
	}

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
