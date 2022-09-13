package application;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

	public String addStudent(Student student){
		return "SUCCESS";
	}

	public List<StudentReport> getAllStudents() {

		final int noOfSubject = 3;

		List<StudentReport> candidates = new ArrayList<StudentReport>();

		StudentReport candidate = new StudentReport();
		candidate.setStudentId(80004);
		candidate.setStudentName("John K");
		candidate.setTotalMarks(240);
		candidate.setNoOfSubjects(noOfSubject);
		candidate.setResult('P');

		StudentReport candidate1 = new StudentReport();
		candidate1.setStudentId(80005);
		candidate1.setStudentName("Marshal M");
		candidate1.setTotalMarks(163);
		candidate1.setNoOfSubjects(noOfSubject);
		candidate1.setResult('F');

		StudentReport candidate2 = new StudentReport();
		candidate2.setStudentId(80002);
		candidate2.setStudentName("Jacob J");
		candidate2.setTotalMarks(269);
		candidate2.setNoOfSubjects(noOfSubject);
		candidate2.setResult('P');

		StudentReport candidate3 = new StudentReport();
		candidate3.setStudentId(80001);
		candidate3.setStudentName("Samuel S");
		candidate3.setTotalMarks(200);
		candidate3.setNoOfSubjects(noOfSubject);
		candidate3.setResult('F');

		StudentReport candidate4 = new StudentReport();
		candidate4.setStudentId(80003);
		candidate4.setStudentName("Jackie C");
		candidate4.setTotalMarks(180);
		candidate4.setNoOfSubjects(noOfSubject);
		candidate4.setResult('P');
		
		candidates.add(candidate);
		candidates.add(candidate1);
		candidates.add(candidate2);
		candidates.add(candidate3);
		candidates.add(candidate4);

		return candidates;
	}
}
