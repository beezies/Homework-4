package edu.sjsu.assignment3;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

public class TestDesComparator {

	@Test
	public void test_appointment_array() {

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
		Appointment[] expected = { a4, a5, a3, a2, a1 };

		DesComparator comp = new DesComparator();

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if ((comp.compare(arr[j], arr[j + 1])) < 0) {
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

		assertTrue(same);

	}

}
