package application;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import resources.AppConfig;

public class Tester {
	
	public static void main(String[] args) {
		try
		{
			bookAssessment();
			getAssessmentReport();

		} catch (Exception e) {
			System.out.println("\nERROR:"+ AppConfig.PROPERTIES.getProperty(e.getMessage()));
		}
	}
	
	public static void bookAssessment() throws Exception{
		
		Booking booking = new Booking();
		LocalDate assessmentDate1 = LocalDate.now();
		assessmentDate1 = assessmentDate1.plusDays(1);

		booking.setAssessmentDate(assessmentDate1);
		booking.setAssessmentType("Hands-On");
		booking.setBatchName("IVS-RT2-NCS");		
		booking.setCourseName("FA1");
		
		Trainee trainee1 = new Trainee();
		trainee1.setEmpNo(600001);
		trainee1.setEmailId("Arun_600001");
		
		Trainee trainee2 = new Trainee();
		trainee2.setEmpNo(600002);
		trainee2.setEmailId("Remi_600002");		
		
		List<Trainee>tlist = new ArrayList<Trainee>();
		tlist.add(trainee1);
		tlist.add(trainee2);
		
		booking.setTraineesList(tlist);
		Application app = new Application();
		Integer duration = app.bookAssessment(booking);
		
		if(duration==null || (duration!=180 && duration!=90))
			System.out.println("\n" +AppConfig.PROPERTIES.getProperty("Tester.FAIL") );
		else
			System.out.println("\n" +AppConfig.PROPERTIES.getProperty("Tester.SUCCESS")+" "+ duration+ " minutes");
	}

	public static void getAssessmentReport() throws Exception{
		// Uncomment the below code after implementing the business logic
		
		/*String batchName="IVS-RT2-NC";
		Application app = new Application();
		List<Report> reportList = app.getAssessmentReport(batchName);
		String datePattern = "dd-MMM-yyyy";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(datePattern);
	
		System.out.println("\n\n\n\tCourseName      AssessmentType        AssessmentDate       ");
		System.out.println("--------------------------------------------------------------");
		for (Report report : reportList) {
			System.out.println("\t "+report.getCourseName()+"\t\t"+report.getAssessmentType() + "\t\t"
			+ dtf.format(report.getAssessmentDate()) + " \t\t");
		}*/
	}
}
