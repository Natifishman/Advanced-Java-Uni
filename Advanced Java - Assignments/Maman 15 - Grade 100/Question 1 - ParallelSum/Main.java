
/**
 * Written by Natanel Fishman for Maman 15 Question 1.
 * 
 * Main class - Entry point of this program. We generate an array of random integers 
 * and utilize multiple threads to calculate the sum of the array's elements in parallel.
 */

import java.util.Random;	// Import the Random class to generate random numbers
import java.util.Scanner; 	// Import the Scanner class to read user input

public class Main {

	private static final int MIN_NUMBER = 1;   // Minimum value (inclusive) for random numbers
	private static final int MAX_NUMBER = 101; // Maximum value (exclusive) for random numbers

	public static void main(String[] args) {
		// Create a Random object to generate random numbers
		Random rnd = new Random();
		// Create a Scanner object to read user input
		Scanner scan = new Scanner(System.in);
		int n, m;

		try {
			// Prompt the user to enter the number of array elements
			System.out.println("Enter the number of array elements (n): ");
			// Read and validate the integer input for the number of array elements
			n = getIntFromInput(scan);

			// Prompt the user to enter the number of threads
			System.out.println("Enter the number of summary processes (m): ");
			// Read and validate the integer input for the number of threads
			m = getIntFromInput(scan);
			// Close the Scanner object as it is no longer needed
			scan.close();

			// Generate an array of random integers within the specified range
			int[] array = rnd.ints(n, MIN_NUMBER, MAX_NUMBER).toArray();

			// Create a ParallelSum object to manage the summing process
			ParallelSum parallelSum = new ParallelSum(array, m);

			// Create an array to hold the SumThread objects
			SumThread[] threads = new SumThread[m];
			// Initialize and start each thread
			for (int i = 0; i < m; i++) {
				// Initialize each SumThread with the ParallelSum object
				threads[i] = new SumThread(parallelSum);
			}
			for (int i = 0; i < m; i++) {
				threads[i].start(); // Start each thread
			}

			// Loop through each SumThread and wait for it to complete using join()
			for (int i = 0; i < m; i++) {
				try {
					threads[i].join(); // Wait for the i-th SumThread to finish executing
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt(); // Preserve the interrupted status of the current thread
				}
			}

			// Print the sum of the array elements after all threads have completed
			System.out.println("The sum of the array elements is: " + parallelSum.getResult());
		} catch (Exception e) {
			//Saw on StackOverflow that it handles better in this situation
			System.err.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Method to safely get a positive integer from user input
	private static int getIntFromInput(Scanner scan) {
		int num = 0;
		// Loop until a valid positive integer is entered
		while (num <= 0) {
			if (scan.hasNextInt()) {  // Check if the next input is an integer
				num = scan.nextInt(); // Read the integer
			}
			if (num <= 0) { // Check if the integer is positive
				// Print an error message and prompt for input again
				System.out.println("Error! Enter an integer bigger than 0");
				scan.nextLine(); // Clear the invalid input
			}
		}
		return num; // Return the valid positive integer
	}
}
