package test;

public class ApplicationTest{
	
	public ApplicationTest() {
		super();
	}
	
	public void validExam() throws Exception {
System.out.println("Valid exam dates");
	}
	
	public void invalidExamDuration() throws Exception {
		System.out.println("Invalid exam time/duration");
	}
	
	public void invalidExamSlot() throws Exception {
		System.out.println("invalid Exam slot");
	}
	
	public void invalidExamPastDate() throws Exception {
		System.out.println("Invalid Exam past Date");
	}
	
	public void invalidExamWeekend() throws Exception {
		System.out.println("Invalid Exam Weekend");
	}
	
	public void invalidExamDateAfter7Days() throws Exception {
		System.out.println("Invlaid Exam dater after 7 days");
	}
	
	public void invalidDateTimeFormat() throws Exception {
		System.out.println("Invalid exam date time format");
	}
}
