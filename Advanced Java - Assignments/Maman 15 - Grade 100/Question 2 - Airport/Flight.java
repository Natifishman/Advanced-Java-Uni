/**
 * Flight class - represent a flight from one airport to another.
 * Coordinates departure and landing procedures between two airports(using AirPort class).
 * 
 * Written by Natanel Fishman for Maman 15, Question 2.
 */

import java.util.Random;

// Represents a flight from one airport to another.
public class Flight extends Thread {

    private int flightId;
    private AirPort departure, destination;
    private Random random = new Random();

    // Constructor
    public Flight(int flightId, AirPort departure, AirPort destination) {
        this.flightId = flightId;
        this.departure = departure;
        this.destination = destination;
    }

    // Executes the flight - from airport "departure" to airport "destination"
    @Override
    public void run() {
        departure.depart(flightId);
        simulateFlight();
        destination.land(flightId);
    }

    // Simulates the flight duration by sleeping for 2 to 5 seconds
    private void simulateFlight() {
        try {
            Thread.sleep((long) (random.nextInt(3000) + 2000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}