package application;


public class Student {
	
	// Implement the class as per class diagram 
	int studentId,mark1,mark2,mark3;
	String studentName,department;
	char result;
	
	/**
	 * @param studentId
	 * @param mark1
	 * @param mark2
	 * @param mark3
	 * @param studentName
	 * @param department
	 * @param result
	 */
	public Student(int studentId, int mark1, int mark2, int mark3, String studentName, String department, char result) {
		super();
		this.studentId = studentId;
		this.mark1 = mark1;
		this.mark2 = mark2;
		this.mark3 = mark3;
		this.studentName = studentName;
		this.department = department;
		this.result = result;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getMark1() {
		return mark1;
	}
	public void setMark1(int mark1) {
		this.mark1 = mark1;
	}
	public int getMark2() {
		return mark2;
	}
	public void setMark2(int mark2) {
		this.mark2 = mark2;
	}
	public int getMark3() {
		return mark3;
	}
	public void setMark3(int mark3) {
		this.mark3 = mark3;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public char getResult() {
		return result;
	}
	public void setResult(char result) {
		this.result = result;
	}

}
