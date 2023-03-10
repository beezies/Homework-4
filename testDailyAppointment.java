package edu.sjsu.assignment3;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class testDailyAppointment {

	@Test
	public void test_valid_middle_year() {
		LocalDate start = LocalDate.of(2002, 12, 13);
		LocalDate end = LocalDate.of(2004, 6, 8);
		DailyAppointment app = new DailyAppointment("hi", start, end);

		LocalDate test = LocalDate.of(2003, 12, 13);
		boolean valid = app.occursOn(test);
		assertTrue(valid);
	}

	@Test
	public void test_valid_edge_dates() {
		LocalDate start = LocalDate.of(2002, 12, 13);
		LocalDate end = LocalDate.of(2004, 6, 8);
		DailyAppointment app = new DailyAppointment("hi", start, end);

		LocalDate test = LocalDate.of(2002, 12, 13);
		boolean valid = app.occursOn(test);
		assertTrue(valid);

		test = LocalDate.of(2004, 6, 8);
		valid = app.occursOn(test);
		assertTrue(valid);
	}

	@Test
	public void test_not_valid_before() {
		LocalDate start = LocalDate.of(2002, 12, 13);
		LocalDate end = LocalDate.of(2004, 6, 8);
		DailyAppointment app = new DailyAppointment("hi", start, end);

		LocalDate test = LocalDate.of(2001, 12, 13);
		boolean valid = app.occursOn(test);
		assertFalse(valid);

		test = LocalDate.of(2002, 11, 13);
		valid = app.occursOn(test);
		assertFalse(valid);

		test = LocalDate.of(2002, 12, 12);
		valid = app.occursOn(test);
		assertFalse(valid);
	}

	@Test
	public void test_not_valid_after() {
		LocalDate start = LocalDate.of(2002, 12, 13);
		LocalDate end = LocalDate.of(2004, 6, 8);
		DailyAppointment app = new DailyAppointment("hi", start, end);

		LocalDate test = LocalDate.of(2005, 6, 8);
		boolean valid = app.occursOn(test);
		assertFalse(valid);

		test = LocalDate.of(2004, 7, 8);
		valid = app.occursOn(test);
		assertFalse(valid);

		test = LocalDate.of(2004, 6, 9);
		valid = app.occursOn(test);
		assertFalse(valid);
	}

}
