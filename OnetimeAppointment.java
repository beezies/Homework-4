package edu.sjsu.assignment3;

import java.time.LocalDate;

/**
 * 
 * Subclass of Appointment that is for single appointments.
 * 
 * @author briannanicole
 * 
 */
public class OnetimeAppointment extends Appointment {

	public OnetimeAppointment(String description, LocalDate startDate) {
		super(description, startDate, startDate);
	}

	/**
	 * Check if the input is the exact same as the start date of appointment.
	 */
	@Override
	public boolean occursOn(LocalDate date) {

		LocalDate startDate = getStartDate();

		if (date == startDate)
			return true;

		boolean sameYear = (date.getYear() == startDate.getYear());
		boolean sameMonth = (date.getMonth() == startDate.getMonth());
		boolean sameDay = (date.getDayOfMonth() == startDate.getDayOfMonth());

		return (sameYear && sameMonth && sameDay);

	}

}
