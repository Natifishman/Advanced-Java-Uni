
/**
 * Represents an employee.
 * 
 * Written by Natanel Fishman for Maman 12, Question 1.
 */
import java.util.Calendar;

public abstract class Employee {
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	private final BirthDate birthDate;

	/**
	 * Constructs an Employee object with the specified details.
	 * 
	 * @param firstName            the first name of the employee
	 * @param lastName             the last name of the employee
	 * @param socialSecurityNumber the social security number of the employee
	 * @param yearOfBirth          the year of birth of the employee
	 * @param monthOfBirth         the month of birth of the employee (1-12)
	 * @param dayOfBirth           the day of the month of birth of the employee
	 */
	public Employee(String firstName, String lastName, String socialSecurityNumber, int yearOfBirth, int monthOfBirth,
			int dayOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.birthDate = new BirthDate(yearOfBirth, monthOfBirth, dayOfBirth);
	}

	/**
	 * Retrieves the first name of the employee.
	 * 
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Retrieves the last name of the employee.
	 * 
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Retrieves the social security number of the employee.
	 * 
	 * @return the social security number
	 */
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	/**
	 * Retrieves the birth date of the employee.
	 * 
	 * @return the birth date
	 */
	public BirthDate getBirthDate() {
		return birthDate;
	}

	/**
	 * Retrieves the month of birth of the employee.
	 * 
	 * @return the month of birth
	 */
	public int getBirthDateMonth() {
		return birthDate.getMonth();
	}

	/**
	 * Calculates the earnings of the employee.
	 * 
	 * @return the earnings of the employee
	 */
	public abstract double earnings(); // no implementation here

	/**
	 * Returns a string representation of this Employee object.
	 * 
	 * @return a string representation including salary and birthday bonus if
	 *         applicable
	 */
	@Override
	public String toString() {
		int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
		String earnings;
		if (getBirthDateMonth() == currentMonth) {
			earnings = "Salary earned: $" + (earnings() + 200)
					+ ". Earned an extra $200 because it's their birthday this month!";
		} else {
			earnings = "Salary earned: $" + earnings();
		}
		return String.format("%s %s%nsocial security number: %s%n%s%n%s", getFirstName(), getLastName(),
				getSocialSecurityNumber(), getBirthDate().toString(), earnings);
	}
}