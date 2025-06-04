/**
 * Written by Natanel Fishman for Maman 15 Question 1.
 * 
 * ParallelSum class - Manages a list of integers to be summed using the parallel sum process with multiple threads.
 * It provides synchronized methods for removing pairs of integers, inserting the sums back into the list, and returning the final result.
 */

import java.util.ArrayList; 	// Import the ArrayList class
import java.util.List; 			// Import the List interface

class ParallelSum {

    private final List<Integer> list; 	// List to hold the integers to be summed
    private final int maxThreads; 		// Maximum number of threads allowed
    private int waiting; 				// Counter for waiting threads
    private boolean done; 				// Flag to indicate if the summing process is done

    // Constructor to initialize the ParallelSum object
    public ParallelSum(int[] arr, int m) {
        list = new ArrayList<>(); 	// Initialize the list to hold integers
        for (int item : arr) {
            list.add(item); 		// Add each integer from the array to the list
        }
        done = false; 	// Initialize the done flag to false
        waiting = 0; 	// Initialize the waiting counter to 0
        maxThreads = m; // Set the maximum number of threads
    }

    // Synchronized method to remove a pair of elements from the list and sum them
    public synchronized List<Integer> removePair() {
        // Loop until there are at least two elements in the list or the summing process is done
        while (list.size() <= 1 && !done) {
            // Check if the number of waiting threads is less than the maximum number of threads minus one
            if (waiting < maxThreads - 1) {
                waiting++; // Increment the waiting counter
                try {
                    wait(); // Wait for notification
                } catch (InterruptedException e) {
                	//reset interrupt status and exit
                    Thread.currentThread().interrupt();
                    return null;
                }
                waiting--; 		// Decrement the waiting counter
            } else {
                done = true; 	// Set the done flag to true if there are no more pairs to sum
            }
        }
        if (done) {
            notifyAll(); // Notify all waiting threads if the summing process is done
            return null; // Return null as there are no more pairs to sum
        } else {
            List<Integer> result = new ArrayList<>(); // Create a list to hold the pair of integers
            result.add(list.remove(0)); // Remove the first element from the list and add it to the result
            result.add(list.remove(0)); // Remove the second element from the list and add it to the result
            return result; 				// Return the pair of integers
        }
    }

    // Synchronized method to insert the sum back into the list and notify all threads
    public synchronized void insert(int sum) {
        list.add(sum); 	// Add the sum back into the list
        notifyAll(); 	// Notify all waiting threads
    }

    // Synchronized method to get the final sum after the summing process is finished
    public synchronized int getResult() {
        // Loop until the summing process is done
        while (!done) {
            try {
                wait(); // Wait for notification
            } catch (InterruptedException e) {
                //reset interrupt status and exit
                Thread.currentThread().interrupt();
                return 0; // Return 0 if interrupted
            }
        }
        return list.get(0); // Return the final sum from the list
    }
}