
/**
 * Written by Natanel Fishman for Maman 15 Question 1.
 * 
 * SumThread - Thread that performs the summing of integer pairs in the ParallelSum class.
 * Each thread repeatedly removes pairs of integers, calculates their sum, 
 * and inserts the result back into the list until no more pairs are available.
 */

import java.util.List; // Import the List interface

class SumThread extends Thread { // SumThread extends the Thread class to perform parallel operations

	private final ParallelSum parallelSum; // Reference to the ParallelSum object for coordinated summing

	// Constructor to initialize the SumThread object with a ParallelSum object
	public SumThread(ParallelSum parallelSum) {
		this.parallelSum = parallelSum; // Set the ParallelSum object for this thread
	}

	// The run method is the entry point for the thread's execution
	public void run() {
		List<Integer> pair; // Declare a list to hold the pair of integers
		pair = parallelSum.removePair(); // Remove a pair of integers from the ParallelSum object
		// Loop until no more pairs are available
		while (pair != null) {
			int sum = pair.get(0) + pair.get(1); 	// Calculate the sum of the pair
			parallelSum.insert(sum); 				// Insert the sum back into the ParallelSum object
			pair = parallelSum.removePair(); 		// Remove the next pair of integers
		}
	}
}