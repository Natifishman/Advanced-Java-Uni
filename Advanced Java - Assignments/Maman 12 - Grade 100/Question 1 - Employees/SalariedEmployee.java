/**
 * The SalariedEmployee class represents an employee who is paid a fixed weekly
 * salary.
 * 
 * Written by Natanel Fishman for Maman 12, Question 1.
 */

// Represents an employee paid a fixed weekly salary
public class SalariedEmployee extends Employee {

	private double weeklySalary; // Salary per week

	// Constructor
	public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary,
			int year, int month, int dayOfMonth) {
		super(firstName, lastName, socialSecurityNumber, year, month, dayOfMonth);

		// Validation for weekly salary
		if (weeklySalary < 0.0) {
			throw new IllegalArgumentException("Weekly salary must be >= 0.0");
		}

		// Assigning weekly salary
		this.weeklySalary = weeklySalary;
	}

	// Set method for weekly salary
	public void setWeeklySalary(double weeklySalary) {
		// Validation
		if (weeklySalary < 0.0) {
			throw new IllegalArgumentException("Weekly salary must be >= 0.0");
		}

		// Setting weekly salary
		this.weeklySalary = weeklySalary;
	}

	// Get method for weekly salary
	public double getWeeklySalary() {
		return weeklySalary;
	}

	// Method to calculate earnings; override abstract method earnings in Employee
	@Override
	public double earnings() {
		return getWeeklySalary();
	}

	// String representation of SalariedEmployee object
	@Override
	public String toString() {
		return String.format("Salaried Employee: %s%n%s: $%,.2f", super.toString(), "Weekly Salary", getWeeklySalary());
	}
}