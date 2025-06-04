/**
 * Represents a commission-based employee.
 * 
 * Written by Natanel Fishman for Maman 12, Question 1.
 */
public class CommissionEmployee extends Employee {
	private double grossSales; // Gross weekly sales
	private double commissionRate; // Commission percentage

	/**
	 * Constructs a CommissionEmployee object with the specified details.
	 * 
	 * @param firstName            the first name of the employee
	 * @param lastName             the last name of the employee
	 * @param socialSecurityNumber the social security number of the employee
	 * @param grossSales           the gross weekly sales made by the employee
	 * @param commissionRate       the commission rate of the employee
	 * @param year                 the year of employment
	 * @param month                the month of employment (1-12)
	 * @param dayOfMonth           the day of the month of employment
	 */
	public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate, int year, int month, int dayOfMonth) {
		super(firstName, lastName, socialSecurityNumber, year, month, dayOfMonth);

		if (commissionRate <= 0.0 || commissionRate >= 1.0) { // Validate commission rate
			throw new IllegalArgumentException("Commission rate must be more than 0.0 and less than 1.0");
		}

		if (grossSales < 0.0) { // Validate gross sales
			throw new IllegalArgumentException("Gross sales must be greater or equal to 0.0");
		}

		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}

	/**
	 * Sets the gross weekly sales of the employee.
	 * 
	 * @param grossSales the gross weekly sales to set
	 */
	public void setGrossSales(double grossSales) {
		if (grossSales < 0.0) { // Validate gross sales
			throw new IllegalArgumentException("Gross sales must be greater or equal to 0.0");
		}

		this.grossSales = grossSales;
	}

	/**
	 * Retrieves the gross weekly sales of the employee.
	 * 
	 * @return the gross weekly sales
	 */
	public double getGrossSales() {
		return grossSales;
	}

	/**
	 * Sets the commission rate of the employee.
	 * 
	 * @param commissionRate the commission rate to set
	 */
	public void setCommissionRate(double commissionRate) {
		if (commissionRate <= 0.0 || commissionRate >= 1.0) { // Validate commission rate
			throw new IllegalArgumentException("Commission rate must be more than 0.0 and less than 1.0");
		}

		this.commissionRate = commissionRate;
	}

	/**
	 * Retrieves the commission rate of the employee.
	 * 
	 * @return the commission rate
	 */
	public double getCommissionRate() {
		return commissionRate;
	}

	/**
	 * Calculates the earnings of the employee.
	 * 
	 * @return the earnings of the employee
	 */
	@Override
	public double earnings() {
		return getCommissionRate() * getGrossSales();
	}

	/**
	 * Returns a string representation of this CommissionEmployee object.
	 * 
	 * @return a string representation including gross sales and commission rate
	 */
	@Override
	public String toString() {
		return String.format("%s: %s%n%s: $%,.2f; %s: %.2f", "Commission employee", super.toString(), "Gross sales",
				getGrossSales(), "Commission rate", getCommissionRate());
	}
}