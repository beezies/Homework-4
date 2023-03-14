package edu.sjsu.assignment3;

import java.time.LocalDate;

// JavaDoc url: https://beezies.github.io/Homework-4/edu/sjsu/assignment3/package-summary.html

/**
 * 
 * Abstract class for assigning appointments between start and end dates.
 * 
 * @author briannanicole
 * 
 */
public abstract class Appointment implements Comparable<Appointment> {

	private String description;
	private LocalDate startDate;
	private LocalDate endDate;

	public Appointment(String description, LocalDate startDate, LocalDate endDate) {
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/**
	 * 
	 * Should be implemented to check if an Appointment occurs on a given day.
	 * 
	 * @param date Date to check
	 * @return Whether the appointment occurs
	 */
	public abstract boolean occursOn(LocalDate date);

	/**
	 * 
	 * @return Description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @return Start Date
	 */
	public LocalDate getStartDate() {
		return startDate;
	}

	/**
	 * 
	 * @return End Date
	 */
	public LocalDate getEndDate() {
		return endDate;
	}

	/**
	 * 
	 * Helper to determine whether the year and month of the date are valid.
	 * 
	 * @param date Date to check
	 * @return Whether the year and month of the date are valid
	 */
	public boolean validYearAndMonth(LocalDate date) {

		LocalDate start = getStartDate();
		LocalDate end = getEndDate();

		int year = date.getYear();
		if (year < start.getYear() || year > end.getYear())
			return false;

		int month = date.getMonthValue();
		boolean validMonth;
		if (year == start.getYear() && year != end.getYear()) {
			validMonth = (month >= start.getMonthValue());
		} else if (year != start.getYear() && year == end.getYear()) {
			validMonth = (month <= end.getMonthValue());
		} else if (year == start.getYear() && year == end.getYear()) {
			validMonth = (month >= start.getMonthValue() && month <= end.getMonthValue());
		} else
			validMonth = true;

		return validMonth;
	}

	/**
	 * Returns 0 if the Appointments are the same, 1 if this appointment is
	 * "greater" than the one compared, -1 if it is "lesser" and 0 if they are the
	 * same. Results are determined in order of start date, end date, and then
	 * description.
	 */
	public int compareTo(Appointment o) {

		if (o.getStartDate() == getStartDate() && o.getEndDate() == getEndDate()
				&& o.getDescription() == getDescription())
			return 0;

		if (this.getStartDate().isBefore(o.getStartDate()))
			return 1;
		if (this.getStartDate().isAfter(o.getStartDate()))
			return -1;

		if (this.getEndDate().isBefore(o.getEndDate()))
			return 1;
		if (this.getEndDate().isAfter(o.getEndDate()))
			return -1;

		return (this.getDescription().compareTo(o.getDescription()) * -1);
	}

	public static void main(String[] args) {
		LocalDate d1 = LocalDate.of(2022, 1, 27);
		LocalDate d2 = LocalDate.of(2022, 5, 18);
		LocalDate d3 = LocalDate.of(2022, 2, 16);
		LocalDate d4 = LocalDate.of(2022, 5, 16);

		Appointment a1 = new OnetimeAppointment("Class Starts", d1);
		Appointment a2 = new DailyAppointment("Class", d1, d2);
		Appointment a3 = new DailyAppointment("Assignments", d3, d4);
		Appointment a4 = new MonthlyAppointment("A meeting", d1, d2);
		Appointment a5 = new MonthlyAppointment("A meeting", d3, d2);

		Appointment[] arr = { a1, a2, a3, a4, a5 };
		Appointment[] expected = { a1, a4, a2, a3, a5 };

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if ((arr[j].compareTo(arr[j + 1])) < 0) {
					Appointment temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		boolean same = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != expected[i])
				same = false;
		}
		System.out.println(same);
	}

}
