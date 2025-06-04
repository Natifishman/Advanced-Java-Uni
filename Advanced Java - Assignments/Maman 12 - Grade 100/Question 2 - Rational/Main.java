import java.util.Scanner;

/**
 * Written by Natanel Fishman for Maman Number 12, Question 2.
 * 
 * * A program to perform operations on Rational numbers.
 */
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Input two rational numbers
		Rational num1 = inputRational(scanner, "First");
		Rational num2 = inputRational(scanner, "Second");

		// Perform operations and print results
		// Check if num1 is greater than num2
		if (num1.greaterThan(num2))
			System.out.println(num1 + " is greater than " + num2);
		else
			System.out.println(num1 + " is NOT greater than " + num2);

		// Check if num1 is equal to num2
		if (num1.equals(num2))
			System.out.println(num1 + " is equal to " + num2);
		else
			System.out.println(num1 + " is NOT equal to " + num2);

		// Print the result of addition of num1 and num2
		System.out.println(num1 + " + " + num2 + " = " + num1.plus(num2).reduce());

		// Print the result of subtraction of num2 from num1
		System.out.println(num1 + " - " + num2 + " = " + num1.minus(num2).reduce());

		// Print the result of multiplication of num1 and num2
		System.out.println(num1 + " * " + num2 + " = " + num1.multiply(num2).reduce());

		try {
			// Print the result of division of num1 by num2
			System.out.println(num1 + " / " + num2 + " = " + num1.divide(num2).reduce());
		} catch (ArithmeticException e) {
			// Handle division by zero exception
			System.out.println(e.getMessage());
		}

		// Close the scanner
		scanner.close();
	}

	/**
	 * Helper method to input a rational number from the user. (it's not written in
	 * the instructions that it's not allowed(I could leave it in main)).
	 * 
	 * @param scanner the Scanner object to read user input
	 * @param ordinal a string indicating the position of the rational number (e.g.,
	 *                "First", "Second")
	 * @return a Rational object representing the input rational number
	 */
	private static Rational inputRational(Scanner scanner, String ordinal) {
		int numerator, denominator;
		while (true) {
			System.out.println("Please insert the numerator for " + ordinal + " rational number: ");
			numerator = scanner.nextInt();
			System.out.println("Please insert the denominator for " + ordinal + " rational number: ");
			denominator = scanner.nextInt();

			try {
				// Attempt to create a Rational object with the input(numerator and denominator)
				return new Rational(numerator, denominator);
			} catch (IllegalArgumentException e) {
				// Handle invalid input and prompt the user to try again
				System.out.println(e.getMessage());
				System.out.println("Please try again.");
			}
		}
	}
}