package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import test.*;

enum Weekend {
	SATURDAY("Saturday"), SUNDAY("Sunday");

	Weekend(String string) {
		// TODO Auto-generated constructor stub

	}
}

public class Tester {
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		String examStartString = "12 April, 2021, 9:00 am";
		String examEndString = "12 April, 2021, 11:00 am";

		// Code here
		try {
			isValidExamDateTime(examStartString, examEndString);
		} catch (invalidExamDuration ied) {
			ied.getMessage();
			// e.printStackTrace();
		} catch (invalidExamSlot ies) {
			ies.getMessage();
		} catch (ExamDateonWeekendException e) {
			e.getMessage();
		} catch (ExamPastDate ed) {
			ed.getMessage();
		} catch (invalidExamDateAfter7Days i) {
			i.getMessage();
		}catch(invalidExamDateException iee) {
			iee.getMessage();
		}

	}

	static ApplicationTest exception;
	static DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd MMMM, yyyy, h:mm a");
	static LocalDateTime dateTime = LocalDateTime.now();
	static String dateTimeStr = LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 00)).format(dateTimeFormat);
	static LocalDateTime ExpectedExamDateStartTimeslot1;
	static LocalDateTime ExpectedExamDateEndTimeslot1;
	static LocalDateTime ExpectedExamDateStartTimeslot2;
	static LocalDateTime ExpectedExamDateEndTimeslot2;

	public static boolean isValidExamDateTime(String examStartString, String examEndString) throws invalidExamDuration,
			invalidExamSlot, invalidExamDateAfter7Days, ExamDateonWeekendException, ExamPastDate, invalidExamDateException {
		// Code here
		exception = new ApplicationTest();
		LocalDateTime startdate = getDateTimeFromString(examStartString);
		LocalDateTime enddate = getDateTimeFromString(examEndString);
//       for(LocalDateTime dt:examstartDate(dateTimeStr)) {
//       ExpectedExamDateStartTimeslot1=LocalDateTime.of(dt.getDayOfMonth(), dt.getMonth(),dt.getYear(),9,00);
//       ExpectedExamDateEndTimeslot1=ExpectedExamDateStartTimeslot1.plusHours(3);
//       ExpectedExamDateStartTimeslot2=LocalDateTime.of(dt.getDayOfMonth(), dt.getMonth(),dt.getYear(),3,00);
//       ExpectedExamDateEndTimeslot2=ExpectedExamDateStartTimeslot2.plusHours(3);
//       }
		// LocalDateTime examstartDate = examstartDate(dateTimeStr)[0];
		// LocalDateTime examendDate = examstartDate(dateTimeStr)[6];
		int duration = (enddate.getHour() * 60 - startdate.getHour() * 60 + enddate.getMinute() - startdate.getMinute())
				/ 60;
		ExpectedExamDateStartTimeslot1 = examstartDate(dateTimeStr)[0];
		ExpectedExamDateEndTimeslot1 = examstartDate(dateTimeStr)[0].plusHours(3);
		ExpectedExamDateStartTimeslot2 = examstartDate(dateTimeStr)[6];
		ExpectedExamDateEndTimeslot2 = examstartDate(dateTimeStr)[6].plusHours(3);

		if (startdate.getDayOfMonth() == (enddate.getDayOfMonth())) {
//       if(!(startdate.toLocalDate().isAfter(ExpectedExamDateStartTimeslot1.toLocalDate()))) {
			if (!(startdate.getYear() > dateTime.getYear() && startdate.getMonthValue() > dateTime.getMonthValue())) {
//    	   if(!(startdate.toLocalTime().isBefore(LocalTime.of(9, 00))&&enddate.toLocalTime().isAfter(LocalTime.of(12, 00))||
//    			   startdate.toLocalTime().isBefore(LocalTime.of(15, 00))&&enddate.toLocalTime().isAfter(LocalTime.of(18, 00)))) {
				if ((startdate.getYear() == dateTime.getYear() && startdate.getMonthValue() == dateTime.getMonthValue()
						&& startdate.getMonthValue() == enddate.getMonthValue())) {
					if (startdate.getDayOfMonth() > dateTime.getDayOfMonth()) {
						if (!((startdate.getDayOfWeek().toString().equalsIgnoreCase("SATURDAY"))
								|| (startdate.getDayOfWeek().toString().equalsIgnoreCase("SUNDAY")))) {
							if (startdate.isAfter(dateTime) && startdate.isBefore(dateTime.plusDays(8))) {

								if (((startdate.isAfter(ExpectedExamDateStartTimeslot1))
										&& (enddate.isBefore(ExpectedExamDateEndTimeslot1)))
										|| ((startdate.isEqual(ExpectedExamDateStartTimeslot1))
												&& (enddate.isEqual(ExpectedExamDateEndTimeslot1)))
										|| ((startdate.isAfter(ExpectedExamDateStartTimeslot2))
												&& (enddate.isBefore(ExpectedExamDateEndTimeslot2))
												|| (startdate.isEqual(ExpectedExamDateStartTimeslot2))
														&& (enddate.isEqual(ExpectedExamDateEndTimeslot2))
												|| ((startdate.isEqual(ExpectedExamDateStartTimeslot1))
														&& (enddate.isBefore(ExpectedExamDateEndTimeslot1))
														|| ((startdate.isEqual(ExpectedExamDateStartTimeslot2))
																&& (enddate
																		.isBefore(ExpectedExamDateEndTimeslot2)))))) {
									if (duration == 2) {
										System.out.println("You take exam, as all the inuts provided are valid");
										return true;
									} else {
										throw new invalidExamDuration();
									}

								} else {
									throw new invalidExamSlot();
								}
							} else {
								throw new invalidExamDateAfter7Days();
							}
						} else {
							throw new ExamDateonWeekendException();
						}
					} else {
						throw new ExamPastDate();
					}

				} else {
					throw new ExamPastDate();
				}
			} else {
throw new invalidExamDateException();
			}
		}

		else {
			throw new invalidExamDateAfter7Days();
		}
//    	   if(startdate.isAfter(ExpectedExamDateStartTimeslot1)||startdate.is(ExpectedExamDateStartTimeslot2)) {
//    		   if(enddate.toLocalDate().isEqual(ExpectedExamDateEndTimeslot1.toLocalDate())||enddate.isEqual(ExpectedExamDateEndTimeslot2)){
//    			   
//    		   }
//    	   }
//           if(((startdate.isAfter(ExpectedExamDateStartTimeslot1))&& (enddate.isBefore(ExpectedExamDateEndTimeslot1)))
//        		   ||((startdate.isEqual(ExpectedExamDateStartTimeslot1))&& (enddate.isEqual(ExpectedExamDateEndTimeslot1))) 
//        		   || ((startdate.isAfter(ExpectedExamDateStartTimeslot2))&& (enddate.isBefore(ExpectedExamDateEndTimeslot2))
//        				   ||(startdate.isEqual(ExpectedExamDateStartTimeslot2))&& (enddate.isEqual(ExpectedExamDateEndTimeslot2))
//        				   ||((startdate.isEqual(ExpectedExamDateStartTimeslot1))&& (enddate.isBefore(ExpectedExamDateEndTimeslot1)) 
//        						   || ((startdate.isEqual(ExpectedExamDateStartTimeslot2))&& (enddate.isBefore(ExpectedExamDateEndTimeslot2)))))){
//return true;
//           }
//           else if((enddate.toLocalDate().isEqual(ExpectedExamDateEndTimeslot1.toLocalDate())
//        		   ||enddate.toLocalDate().isEqual(ExpectedExamDateEndTimeslot2.toLocalDate()))){
//        	   //throw new invalidExamPastDate();
//           }

	}

	public static LocalDateTime[] examstartDate(String examStartString) {
		LocalDateTime startDate[] = new LocalDateTime[7];
		int i = 1;
		while (i <= 7) {
			String Day = LocalDateTime.now().plusDays(i).getDayOfWeek().toString();
			if (Day.equalsIgnoreCase("Saturday")) {
				// j++;
				startDate[i - 1] = LocalDateTime.parse(examStartString, dateTimeFormat).plusDays(i + 2);
			} else if (Day.equalsIgnoreCase("Sunday")) {
				// j++;
				startDate[i - 1] = LocalDateTime.parse(examStartString, dateTimeFormat).plusDays(i + 1);
			} else {
				startDate[i - 1] = startDate[i - 2].plusDays(1);
			}
			i++;
		}
//		for (LocalDateTime dt : startDate)
//			System.out.println(dt.format(dateTimeFormat));
		return startDate;
	}

	public static LocalDateTime getDateTimeFromString(String dateStr) {
		// Code here
		LocalDateTime gDate;
		gDate = LocalDateTime.parse(dateStr, dateTimeFormat);
		// System.out.println(gDate);
		return gDate;
	}
}
