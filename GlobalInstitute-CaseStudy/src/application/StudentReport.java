package application;

public class StudentReport {

	private Integer studentId;
	private String studentName;
	private String grade;
	private Integer totalMarks;
	private Integer noOfSubjects;
	private Character result;
	//Student stud=new Student();

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Integer getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(Integer totalMarks) {
		//totalMarks=stud.getMark1()+stud.getMark2()+stud.getMark3();
		this.totalMarks = totalMarks;
	}

	public Integer getNoOfSubjects() {
		return noOfSubjects;
	}

	public void setNoOfSubjects(Integer noOfSubjects) {
		this.noOfSubjects = noOfSubjects;
	}

	public Character getResult() {
		return result;
	}

	public void setResult(Character result) {
		this.result = result;
	}
}
