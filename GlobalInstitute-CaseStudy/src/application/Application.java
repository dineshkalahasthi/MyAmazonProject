package application;

import java.util.ArrayList;
import java.util.List;

import resources.AppConfig;

public class Application {
	Validator v = new Validator();
	AppConfig prop = new AppConfig();
	DataProvider dp = new DataProvider();

	// can have status as 'P' only if all 3 marks are 50 and above
	public String addStudent(Student student) throws Exception {
		v.validate(student);
		if (student.getMark1() >= 50 && student.getMark2() >= 50 && student.getMark3() >= 50) {
			if (student.getResult() == 'F') {
				throw new Exception(prop.PROPERTIES.get("Validator.INVALID_RESULT_PASS").toString());
			} else {
				dp.addStudent(student);
			}
		} else {
			if (student.getResult() == 'P') {
				throw new Exception(prop.PROPERTIES.get("Validator.INVALID_RESULT_FAIL").toString());
			} else {
				dp.addStudent(student);
			}
		}
		return "SUCCESS";
	}

	public String calculateGrade(StudentReport studentReport) throws Exception {
		int average = (studentReport.getTotalMarks() / studentReport.getNoOfSubjects());
		try {
			if (studentReport.getResult() == 'F') {
				return "NA";
			} else if (studentReport.getResult() == 'P') {
				if (average >= 90)
					return "A";
				else if (average >= 80 && average < 90)
					return "A";
				else if (average >= 70 && average < 80)
					return "B";
			}
		} catch (Exception e) {

		}
		return "C";
	}

	public List<StudentReport> getGradesForStudentsInRange(String range) throws Exception {
		StudentReport studr = new StudentReport();
		List<StudentReport> studlist = new ArrayList<>();
		// studlist=dp.getAllStudents();
		int lrange = Integer.parseInt(range.split("-")[0]);
		int rrange = Integer.parseInt(range.split("-")[1]);
		for (StudentReport st : dp.getAllStudents()) {
			if (st.getTotalMarks() >= lrange && st.getTotalMarks() <= rrange) {
				studlist.add(st);
				st.setGrade(calculateGrade(st));
			}
		}
//		if(studlist.size()!=0) {
//			for(StudentReport st:studlist) {
//				calculateGrade(st);
//				System.out.println(st+" , and Grade is:"+calculateGrade(st));
//			}
//		}
//		else {
//			throw new Exception(prop.PROPERTIES.getProperty("Application.NO_RECORDS"));
//		}

		return studlist;
	}
}
