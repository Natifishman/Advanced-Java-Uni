/**
 * Represents a base plus commission employee.
 * 
 * Written by Natanel Fishman for Maman 12, Question 1.
 */
public class BasePlusCommissionEmployee extends CommissionEmployee {
	private double baseSalary; // Base salary per week

	/**
	 * Constructs a BasePlusCommissionEmployee object with the specified details.
	 * 
	 * @param firstName            the first name of the employee
	 * @param lastName             the last name of the employee
	 * @param socialSecurityNumber the social security number of the employee
	 * @param grossSales           the gross sales made by the employee
	 * @param commissionRate       the commission rate of the employee
	 * @param baseSalary           the base salary per week of the employee
	 * @param year                 the year of employment
	 * @param month                the month of employment (1-12)
	 * @param dayOfMonth           the day of the month of employment
	 */
	public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate, double baseSalary, int year, int month, int dayOfMonth) {
		super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate, year, month, dayOfMonth);

		if (baseSalary < 0.0) { // Validate baseSalary
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}

		this.baseSalary = baseSalary;
	}

	/**
	 * Sets the base salary per week of the employee.
	 * 
	 * @param baseSalary the base salary per week to set
	 */
	public void setBaseSalary(double baseSalary) {
		if (baseSalary < 0.0) { // Validate baseSalary
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}

		this.baseSalary = baseSalary;
	}

	/**
	 * Retrieves the base salary per week of the employee.
	 * 
	 * @return the base salary per week
	 */
	public double getBaseSalary() {
		return baseSalary;
	}

	/**
	 * Calculates the earnings of the employee.
	 * 
	 * @return the earnings of the employee
	 */
	@Override
	public double earnings() {
		return getBaseSalary() + super.earnings();
	}

	/**
	 * Returns a string representation of this BasePlusCommissionEmployee object.
	 * 
	 * @return a string representation including the base salary
	 */
	@Override
	public String toString() {
		return String.format("%s %s; %s: $%,.2f", "base-salaried", super.toString(), "base salary", getBaseSalary());
	}
}