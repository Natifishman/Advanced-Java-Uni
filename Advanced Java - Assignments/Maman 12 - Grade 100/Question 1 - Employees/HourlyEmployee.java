/**
 * Represents an employee paid hourly.
 * 
 * Written by Natanel Fishman for Maman 12, Question 1.
 */
public class HourlyEmployee extends Employee {

	private double wage; // Wage per hour
	private double hours; // Hours worked for the week

	/**
	 * Constructs an HourlyEmployee object with the specified details.
	 * 
	 * @param firstName            the first name of the employee
	 * @param lastName             the last name of the employee
	 * @param socialSecurityNumber the social security number of the employee
	 * @param wage                 the wage per hour of the employee
	 * @param hours                the hours worked for the week by the employee
	 * @param year                 the year of birth of the employee
	 * @param month                the month of birth of the employee (1-12)
	 * @param dayOfMonth           the day of the month of birth of the employee
	 */
	public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours,
			int year, int month, int dayOfMonth) {
		super(firstName, lastName, socialSecurityNumber, year, month, dayOfMonth);

		if (wage < 0.0) { // Validate wage
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");
		}

		if ((hours < 0.0) || (hours > 168.0)) { // Validate hours
			throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
		}

		this.wage = wage;
		this.hours = hours;
	}

	/**
	 * Sets the wage per hour for the employee.
	 * 
	 * @param wage the wage per hour to set
	 */
	public void setWage(double wage) {
		if (wage < 0.0) { // Validate wage
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");
		}

		this.wage = wage;
	}

	/**
	 * Retrieves the wage per hour of the employee.
	 * 
	 * @return the wage per hour
	 */
	public double getWage() {
		return wage;
	}

	/**
	 * Sets the hours worked for the week by the employee.
	 * 
	 * @param hours the hours worked to set
	 */
	public void setHours(double hours) {
		if ((hours < 0.0) || (hours > 168.0)) { // Validate hours
			throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
		}

		this.hours = hours;
	}

	/**
	 * Retrieves the hours worked for the week by the employee.
	 * 
	 * @return the hours worked
	 */
	public double getHours() {
		return hours;
	}

	/**
	 * Calculates the earnings of the employee.
	 * 
	 * @return the earnings of the employee
	 */
	@Override
	public double earnings() {
		if (getHours() <= 40) { // No overtime
			return getWage() * getHours();
		} else {
			return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
		}
	}

	/**
	 * Returns a string representation of this HourlyEmployee object.
	 * 
	 * @return a string representation including hourly wage and hours worked
	 */
	@Override
	public String toString() {
		return String.format("Hourly employee: %s%n%s: $%,.2f; %s: %,.2f", super.toString(), "Hourly wage", getWage(),
				"Hours worked", getHours());
	}
}