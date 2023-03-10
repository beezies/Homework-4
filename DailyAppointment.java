package edu.sjsu.assignment3;

import java.time.LocalDate;

/**
 * 
 * @author briannanicole
 * 
 *         Subclass of Appointment that is for daily appointments between two
 *         dates.
 *
 */
public class DailyAppointment extends Appointment {

	public DailyAppointment(String description, LocalDate startDate, LocalDate endDate) {
		super(description, startDate, endDate);
	}

	/**
	 * Check if the input is between the start and end date (inclusive)
	 */
	@Override
	public boolean occursOn(LocalDate date) {

		LocalDate start = getStartDate();
		LocalDate end = getEndDate();

		if (date == start || date == end)
			return true;

		boolean validYearAndMonth = validYearAndMonth(date);

		int month = date.getMonthValue();
		int day = date.getDayOfMonth();

		boolean validDay;
		if (month == start.getMonthValue() && month != end.getMonthValue()) {
			validDay = (day >= start.getDayOfMonth());
		} else if (month != start.getMonthValue() && month == end.getMonthValue()) {
			validDay = (day <= end.getDayOfMonth());
		} else if (month == start.getMonthValue() && month == end.getMonthValue()) {
			validDay = (day >= start.getDayOfMonth() && day <= end.getDayOfMonth());
		} else
			validDay = true;

		return validYearAndMonth && validDay;
	}

}
