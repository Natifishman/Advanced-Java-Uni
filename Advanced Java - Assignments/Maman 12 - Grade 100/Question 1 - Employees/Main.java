/**
 * The Main class represents the entry point for the employee management
 * program. It generates a random array of employees and displays their
 * information.
 * 
 * Written by Natanel Fishman for Maman 12, Question 1.
 */
public class Main {

	/**
	 * The main method is the entry point of the program.
	 * 
	 * @param args command-line arguments (not used)
	 */
	public static void main(String[] args) {

		// Generate a random array of employees
		Employee[] employees = RandomData.generateRandomEmployeeData();

		// Displaying one example for each employee type
		System.out.println("----------------------------------------");
		System.out.println("An example of one employee of each type:");
		System.out.println("----------------------------------------");

		// Display information for each employee
		for (int i = 0; i < employees.length; i++) {
			System.out.println(employees[i] + "\n");
		}

		// Presenting various examples of potential exceptions
		System.err.println("Here we present several examples of possible exceptions:");
		// Generate a random array of employees with exceptions
		employees = RandomData.generateExceptionEmployeeData();

		/*
		 * A cooler alternative loop version(line 26):
		 * for (Employee employee : employees) 
		 * { System.out.println(employee + "\n"); }
		 */
	}
}