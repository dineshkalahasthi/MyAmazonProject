package application;

import java.util.ArrayList;
import java.util.List;

import resources.AppConfig;


public class Tester {

	public static void main(String[] args) {
		//addStudent();
		getGradesForStudentsInRange();
	}

	public static void addStudent() {
		//uncomment the below code after implementing the business logic
		
		/*Application app = new Application();

		Student student = new Student();
		student.setStudentId(1001);
		student.setStudentName("Vignesh");
		student.setDepartment("ECE");
		student.setMark1(70);
		student.setMark2(23);
		student.setMark3(60);
		student.setResult('P');

		String message = null;
		try {
			message = app.addStudent(student);
			if (message.equals("SUCCESS")) {
				System.out.println();
				System.out.println("\t\t" + AppConfig.PROPERTIES.getProperty("Tester.SUCCESS"));
			}
		} catch (Exception e) {
			 	System.out.println();
				System.out.println("\t\t" + AppConfig.PROPERTIES.getProperty(e.getMessage()));
		}*/
	}

	
	public static void getGradesForStudentsInRange() {
		Application app = new Application();
		List<StudentReport> studentsList = new ArrayList<StudentReport>();

		try {
			studentsList = app.getGradesForStudentsInRange("180-200");
			System.out.println();
			System.out.println("\t Global Institute  ");
			System.out.println("\t *******************");
			System.out.printf("\t%-25s%-25s%-25s%n","Student ID","Student Name","Grade");
			System.out.printf("\t%-25s%-25s%-25s%n","*********","*************","******");
			for (StudentReport sr : studentsList) {
				System.out.printf("\t%-25s%-25s%-25s%n",sr.getStudentId(),sr.getStudentName(),sr.getGrade());
			}

		} catch (Exception e) {
				System.out.println();
				System.out.println("\t"+AppConfig.PROPERTIES.getProperty(e.getMessage()));
		}
	}
}
