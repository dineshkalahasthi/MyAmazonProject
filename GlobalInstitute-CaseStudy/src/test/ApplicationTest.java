package test;

import org.testng.annotations.Test;

import application.Student;
import application.Validator;

public class ApplicationTest {
	Student invaliddep;

	@Test
	public void addStudentInvalidDepartment() throws Exception {
		// Write the code to test
		invaliddep = new Student(1004, 50, 60, 65, "Jacob", "cse", 'P');
		Validator val = new Validator();
		val.validate(invaliddep);
	}

	@Test
	public void addStudentInvalidMarks() throws Exception {
		// Write the code to test
		Student invalidmarks = new Student(1004, -50, 110, 65, "Jacob", "CSE", 'P');
		Validator val = new Validator();
		val.validate(invalidmarks);
	}

	@Test
	public void addStudentInvalidStudentId() throws Exception {
		// Write the code to test
		Student invalidstuId = new Student(10040, 50, 60, 65, "Jacob", "cse", 'P');
		Validator val = new Validator();
		val.validate(invalidstuId);
	}
}
