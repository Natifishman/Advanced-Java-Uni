/**
 * AirPort class - Manage flight operations at an airport.
 * Handle flight departures and landings, utilizing a queue based runway allocation system.
 * 
 * Written by Natanel Fishman for Maman 15, Question 2.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class AirPort {

	private static final int TOTAL_RUNWAYS = 3; // Total number of ways in the airport
	private final String airportName; // Name of the airport
	private Queue<Integer> flightQueue; // Queue to manage flights waiting for a way
	private int activeRunways; // Number of currently active (occupied) ways
	private boolean[] runwayStatus; // Array to track the status of each way, true if occupied, false if free
	private Random randomGenerator = new Random(); // Random number generator instance

	// Constructor
	public AirPort(String airportName) {
		this.flightQueue = new LinkedList<>(); // Initialize the flight queue
		this.activeRunways = 0; // Initially, no ways are active
		this.runwayStatus = new boolean[TOTAL_RUNWAYS]; // Initialize the way status array with the total number of
														// ways
		this.airportName = airportName; // Set the name of the airport
	}

	// Handles the departure procedure for a specific flight
	public void depart(int flightId) {
		int runwayIndex = initiateProcedure(flightId);
		printFlightStatus(flightId, runwayIndex, "is preparing for departure");
		simulateOperation();
		printFlightStatus(flightId, runwayIndex, "has departed");
		releaseRunway(runwayIndex);
	}

	// Handles the landing procedure for a specific flight
	public void land(int flightId) {
		print("Flight number " + flightId + " is waiting to land");
		int runwayIndex = initiateProcedure(flightId);
		printFlightStatus(flightId, runwayIndex, "is landing");
		simulateOperation();
		printFlightStatus(flightId, runwayIndex, "has landed");
		releaseRunway(runwayIndex);
	}

	// Initiates a departure or landing procedure and allocates a way
	private synchronized int initiateProcedure(int flightId) {
		flightQueue.add(flightId);
		while (activeRunways == TOTAL_RUNWAYS || flightQueue.peek() != flightId) {
			print("Flight number " + flightId + " is waiting for an available runway.");
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		flightQueue.poll();
		activeRunways++;
		return findAvailableRunway();
	}

	// Finishes a departure or landing procedure and releases the way
	private synchronized void releaseRunway(int runwayIndex) {
		activeRunways--;
		runwayStatus[runwayIndex] = false;
		notifyAll();
	}

	// Finds an available way and returns its index
	private int findAvailableRunway() {
		for (int i = 0; i < runwayStatus.length; i++) {
			if (!runwayStatus[i]) {
				runwayStatus[i] = true;
				return i;
			}
		}
		throw new IllegalStateException("No available runways found");
	}

	// Simulates the operation (departure/landing) by pausing for 2 to 5 seconds
	private void simulateOperation() {
		try {
			Thread.sleep((long) (randomGenerator.nextInt(3000) + 2000));
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	// Prints a message with the airport name
	private void print(String message) {
		System.out.println(message + " at airport " + airportName);
	}

	// Prints a flight status message with the flight ID and way index
	private void printFlightStatus(int flightId, int runwayIndex, String status) {
		print("Flight number " + flightId + " " + status + " using runway " + (runwayIndex + 1));
	}
}