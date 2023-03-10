package edu.sjsu.assignment3;

import java.time.LocalDate;

/**
 * 
 * @author briannanicole
 * 
 *         Subclass of Appointment for appointments that occur on a monthly
 *         basis between two dates.
 *
 */
public class MonthlyAppointment extends Appointment {

	public MonthlyAppointment(String description, LocalDate startDate, LocalDate endDate) {
		super(description, startDate, endDate);
	}

	/**
	 * Check if the input is between the start and end date (inclusive) AND the day
	 * of month of the input date is the same as the start date’s day of month of
	 * the appointment
	 */
	@Override
	public boolean occursOn(LocalDate date) {

		LocalDate start = getStartDate();
		LocalDate end = getEndDate();

		if (date == start || date == end)
			return true;

		boolean validYearAndMonth = validYearAndMonth(date);

		int day = date.getDayOfMonth();
		boolean validDay = (day == start.getDayOfMonth());

		return validYearAndMonth && validDay;

	}

}
