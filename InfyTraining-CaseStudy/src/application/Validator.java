package application;

import java.time.LocalDate;
import java.util.List;

public class Validator {
	public void validate(Booking booking) throws Exception {
		// Use isValidBatchName, isValidCourseName, isValidAssessmentDate,
		// isValidAssessmentType, isValidEmailId to validate the booking details
		// For invalid inputs throw exceptions with the corresponding messages
	}

	public Boolean isValidBatchName(String batchName) {
		String[] batchname = batchName.split("-");
		if (batchname[0].equals("JEE") || batchname[0].equals("MS") || batchname[0].equals("IVS")) {
			if (batchname[1].equals("RT1") || batchname[1].equals("RT2")) {
				if (batchname[2].equals("CS") || batchname[2].equals("NCS")) {
					return true;
				}
			}

		}
		return false;
	}

	public Boolean isValidCourseName(String courseName) {
		String reg="^FA[1-9]$";
		if(courseName.matches(reg)) {
			return true;
		}
		return false;
	}

	public Boolean isValidAssessmentDate(LocalDate assessmentDate) {
		LocalDate today=LocalDate.now();
		LocalDate[] endDate=new LocalDate[6];
		int i=0;
		while(i<7) {
			if(today.plusDays(i).getDayOfWeek().equals(LocalDate.parse("SATURDAY")))
			endDate[i]=today.plusDays(i+2);
			else if(today.plusDays(i).getDayOfWeek().equals(LocalDate.parse("SUNDAY"))) {
				endDate[i]=today.plusDays(i+3);
			}
			else {
				endDate[i]=today.plusDays(i);
			}
		}
		for(LocalDate t:endDate) {
			if(today.equals(t)) {
				return true;
			}
		}
//		LocalDate enddate=today.p
		return false;
	}

	public Boolean isValidAssessmentType(String assessmentType) {
		if(assessmentType.equalsIgnoreCase("Objective")||assessmentType.equalsIgnoreCase("Hands-on")) {
			return true;
		}
		return false;
	}

	public Boolean isValidEmailId(List<Trainee> traineesList) {
		Trainee t=new Trainee();
		String reg="^[a-zA-z]"+"_"+t.getEmpNo();
		return null;
	}
}
