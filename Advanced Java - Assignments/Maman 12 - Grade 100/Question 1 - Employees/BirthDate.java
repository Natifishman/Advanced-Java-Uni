
/**
 * Represents the birth date of an employee.
 * 
 * Written by Natanel Fishman for Maman 12, Question 1.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BirthDate {
	private final Calendar calendar; // Calendar object representing the birth date
	private static final int MIN_YEAR = 1907;
	private static final int MAX_MONTH = 11;

	/**
	 * Constructs a BirthDate object with the specified year, month, and day of
	 * birth.
	 * 
	 * @param yearOfBirth  the year of birth
	 * @param monthOfBirth the month of birth (0-11)
	 * @param dayOfBirth   the day of birth
	 */
	public BirthDate(int yearOfBirth, int monthOfBirth, int dayOfBirth) {
		calendar = new GregorianCalendar(yearOfBirth, monthOfBirth, dayOfBirth);

		int currentYear = Calendar.getInstance().get(Calendar.YEAR);

		validateYear(yearOfBirth, currentYear);
		validateMonth(monthOfBirth);
		validateDay(dayOfBirth);
	}

	/**
	 * Validates the year of birth.
	 * 
	 * @param yearOfBirth the year of birth to validate
	 * @param currentYear the current year
	 * @throws IllegalArgumentException if the year of birth is invalid
	 */
	private void validateYear(int yearOfBirth, int currentYear) {
		if (yearOfBirth < MIN_YEAR || yearOfBirth > currentYear) {
			throw new IllegalArgumentException(
					"Invalid year of birth. Please provide a year between " + MIN_YEAR + " and " + currentYear);
		}
	}

	/**
	 * Validates the month of birth. In Calendar class, months are numbered from
	 * 0-11
	 * 
	 * @param monthOfBirth the month of birth to validate
	 * @throws IllegalArgumentException if the month of birth is invalid
	 */
	private void validateMonth(int monthOfBirth) {
		if (monthOfBirth < 0 || monthOfBirth > MAX_MONTH) {
			throw new IllegalArgumentException("Invalid month of birth. Month should be between 0 and " + MAX_MONTH);
		}
	}

	/**
	 * Validates the day of birth.
	 * 
	 * @param dayOfBirth the day of birth to validate
	 * @throws IllegalArgumentException if the day of birth is invalid
	 */
	private void validateDay(int dayOfBirth) {
		int maxDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		if (dayOfBirth < 1 || dayOfBirth > maxDayOfMonth) {
			throw new IllegalArgumentException("Invalid day of birth for the given month and year");
		}
	}

	/**
	 * Retrieves the month of birth.
	 * 
	 * @return the month of birth (0-11)
	 */
	public int getMonth() {
		return calendar.get(Calendar.MONTH);
	}

	/**
	 * Retrieves the day of birth.
	 * 
	 * @return the day of birth
	 */
	public int getDay() {
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * Retrieves the year of birth.
	 * 
	 * @return the year of birth
	 */
	public int getYear() {
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * Returns a string representation of this BirthDate object.
	 * 
	 * @return a string representation of the birth date in the format
	 *         "day.month.year"
	 */
	@Override
	public String toString() {
		return String.format("Birthdate: %d.%d.%d", getDay(), getMonth() + 1, getYear());
	}
}