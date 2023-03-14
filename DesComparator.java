package edu.sjsu.assignment3;

import java.util.Comparator;

/**
 * 
 * Comparator for two Appointment objects. compares on basis of description,
 * start then end dates.
 * 
 * @author briannanicole
 * 
 */
public class DesComparator implements Comparator<Appointment> {

	@Override
	public int compare(Appointment o, Appointment o2) {

		if (o.getStartDate() == o2.getStartDate() && o.getEndDate() == o2.getEndDate()
				&& o.getDescription() == o2.getDescription())
			return 0;

		if (o.getDescription().compareTo(o2.getDescription()) < 0)
			return 1;
		else if (o.getDescription().compareTo(o2.getDescription()) > 0)
			return -1;

		if (o.getStartDate().isBefore(o2.getStartDate()))
			return 1;
		else if (o.getStartDate().isAfter(o2.getStartDate()))
			return -1;

		if (o.getEndDate().isBefore(o2.getEndDate()))
			return 1;

		return -1;
	}

}
