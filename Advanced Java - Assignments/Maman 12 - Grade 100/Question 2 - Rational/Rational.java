/**
 * Written by Natanel Fishman for Maman Number 12, Question 2.
 * 
 * A class representing rational numbers and providing operations on them.
 */
public class Rational {
	private int numerator; // Numerator of the rational number
	private int denominator; // Denominator of the rational number

	/**
	 * Constructs a Rational object with the given numerator and denominator.
	 * 
	 * @param numerator   the numerator of the rational number
	 * @param denominator the denominator of the rational number
	 * @throws IllegalArgumentException if the denominator is not positive or if
	 *                                  either numerator or denominator is not an
	 *                                  integer
	 */
	public Rational(int numerator, int denominator) {
		if (denominator <= 0) {
			throw new IllegalArgumentException("Denominator must be a positive number.");
		}

		if (numerator % 1 != 0 || denominator % 1 != 0) {
			throw new IllegalArgumentException("Both numerator and denominator must be integers.");
		}

		this.numerator = numerator;
		this.denominator = denominator;
	}

	/**
	 * Retrieves the numerator of the rational number.
	 * 
	 * @return the numerator
	 */
	public int getNumerator() {
		return numerator;
	}

	/**
	 * Retrieves the denominator of the rational number.
	 * 
	 * @return the denominator
	 */
	public int getDenominator() {
		return denominator;
	}

	/**
	 * Checks if this Rational number is greater than the given Rational number.
	 * 
	 * @param num the Rational number to compare with
	 * @return true if this Rational is greater than the given Rational, false
	 *         otherwise
	 */
	public boolean greaterThan(Rational num) {
		return (this.getNumerator() * num.getDenominator()) > (num.getNumerator() * this.getDenominator());
	}

	/**
	 * Checks if this Rational number is equal to the given Rational number.
	 * 
	 * @param num the Rational number to compare with
	 * @return true if this Rational is equal to the given Rational, false otherwise
	 */
	public boolean equals(Rational num) {
		return !this.greaterThan(num) && !num.greaterThan(this) && num instanceof Rational && this instanceof Rational;
	}

	/**
	 * Adds the given Rational number to this Rational number.
	 * 
	 * @param num the Rational number to add
	 * @return a new Rational object representing the sum
	 */
	public Rational plus(Rational num) {
		return new Rational((this.getNumerator() * num.getDenominator()) + (num.getNumerator() * this.getDenominator()),
				this.getDenominator() * num.getDenominator());
	}

	/**
	 * Subtracts the given Rational number from this Rational number.
	 * 
	 * @param num the Rational number to subtract
	 * @return a new Rational object representing the difference
	 */
	public Rational minus(Rational num) {
		return new Rational((this.getNumerator() * num.getDenominator()) - (num.getNumerator() * this.getDenominator()),
				this.getDenominator() * num.getDenominator());
	}

	/**
	 * Multiplies this Rational number by the given Rational number.
	 * 
	 * @param num the Rational number to multiply by
	 * @return a new Rational object representing the product
	 */
	public Rational multiply(Rational num) {
		return new Rational((this.getNumerator() * num.getNumerator()), this.getDenominator() * num.getDenominator());
	}

	/**
	 * Divides this Rational number by the given Rational number.
	 * 
	 * @param num the Rational number to divide by
	 * @return a new Rational object representing the quotient
	 * @throws ArithmeticException if attempting to divide by zero
	 */
	public Rational divide(Rational num) {
		// Check if the denominator of the parameter rational number is not zero
		if (num.getNumerator() == 0) {
			throw new ArithmeticException("Cannot divide by zero.");
		}

		// Calculate the quotient using the reciprocal of the parameter rational number
		int newNumerator = this.getNumerator() * num.getDenominator();
		int newDenominator = this.getDenominator() * num.getNumerator();

		// If the denominator is negative, multiply both numerator and denominator by -1
		if (newDenominator < 0) {
			newNumerator *= -1;
			newDenominator *= -1;
		}

		// Return a new Rational object representing the quotient
		return new Rational(newNumerator, newDenominator);
	}

	/**
	 * Returns a string representation of this Rational number.
	 * 
	 * @return a string representation of this Rational number in the form
	 *         "numerator/denominator"
	 */
	public String toString() {
		return this.getNumerator() + "/" + this.getDenominator();
	}

	/**
	 * Reduces this Rational number to its simplest form.
	 * 
	 * @return a new Rational object representing the reduced form of this Rational
	 *         number
	 */
	public Rational reduce() {
		int absNumerator = Math.abs(this.getNumerator());
		int absDenominator = Math.abs(this.getDenominator());
		int gcd = gcd(absNumerator, absDenominator);
		return new Rational(this.getNumerator() / gcd, this.getDenominator() / gcd);
	}

	/**
	 * Calculates the greatest common divisor (GCD) of two integers using the
	 * Euclidean algorithm.
	 * 
	 * @param x the first integer
	 * @param y the second integer
	 * @return the GCD of x and y
	 */
	public static int gcd(int x, int y) {
		while (y != 0) {
			int temp = y;
			y = x % y;
			x = temp;
		}
		return x;
	}
}