package application;

import resources.AppConfig;

enum department {
	ece("ECE"), cse("CSE"), it("IT");

	private String val;

	department(String val) {
		// TODO Auto-generated constructor stub
		this.val = val;
	}

	public department getType() {
		for (department type : values()) {
			if (type.is(val)) {
				return type;
			}
		}
		return department.cse;
	}

	public boolean is(String department) {
		return this.val.equalsIgnoreCase(department);
	}
}

public class Validator {
	AppConfig prop = new AppConfig();

	public void validate(Student student) throws Exception {

		// Use isValidStudentName, isValidStudentId, isValidDepartment,
		// isValidExamMarks, isValidResult to validate the student details
		// For invalid inputs throw exceptions with the corresponding messages
		if (!isValidStudentName(student.getStudentName())) {
			System.out.println(prop.PROPERTIES.get("Validator.INVALID_STUDENTNAME"));
		} else {
			if (!isValidStudentID(student.getStudentId())) {
				throw new Exception(prop.PROPERTIES.get("Validator.INVALID_STUDENTID").toString());
			} else {
				if (!isValidDepartment(student.getDepartment())) {
					System.out.println(prop.PROPERTIES.get("Validator.INVALID_DEPARTMENT"));
				} else {
					if (!isValidExamMarks(student)) {
						throw new Exception(prop.PROPERTIES.get("Validator.INVALID_EXAMMARKS").toString());
					} else {
						if (!isValidResult(student.getResult())) {
							System.out.println(prop.PROPERTIES.get("Validator.INVALID_RESULT"));
						}
						/*else {
							if(student.getMark1()>50&&student.getMark2()>50&&student.getMark3()>50){
								if(student.getResult()=='F') {
									System.out.println(prop.PROPERTIES.get("Validator.INVALID_RESULT_PASS"));
								}
						}
							else {
								if(student.getResult()=='P') {
									System.out.println(prop.PROPERTIES.get("Validator.INVALID_RESULT_FAIL"));
								}
							}
							
						}*/
					}
				}
			}

		}
	}

	// The entered student name should contain only alphabets and spaces.
	// Name cannot start with a space
	public Boolean isValidStudentName(String studentName) {
		String reg = "^[a-zA-Z]*$";
		if (studentName.matches(reg)) {
			return true;
		}
		return false;
	}

	// The entered student ID can be any valid 4 digit number greater than or equal
	// to 1001
	public Boolean isValidStudentID(int studentstudentId) throws Exception {
		String reg = "^[1-9]{1}[0-9]{3}$";
		if (String.valueOf(studentstudentId).matches(reg)) {
			return true;
		}
//		else {
//			throw new Exception(" ");
//		}
		return false;
	}

	// The entered Department name should be one among the given departments
	// (ECE, CSE, IT)
	public Boolean isValidDepartment(String dept) {
//		if (department.valueOf(dept).is(dept))
		if (dept.toUpperCase().equals("CSE")
				||dept.toUpperCase().equals("ECE")
				||dept.toUpperCase().equals("IT"))
			return true;
		return false;
	}

	// Checking if marks set are not less than "0"
	public Boolean isValidExamMarks(Student student) {
		if ((student.getMark1() >= 0 && student.getMark1() <= 100)
				&& (student.getMark2() >= 0 && student.getMark2() <= 100)
				&& (student.getMark3() >= 0 && student.getMark3() <= 100)) {
			return true;
		}
		return false;
	}

	// Checking if result set is either 'P' or 'F' only
	public Boolean isValidResult(char result) {
		if (result == 'P' || result == 'F') {
			return true;
		}
		return false;
	}
}
