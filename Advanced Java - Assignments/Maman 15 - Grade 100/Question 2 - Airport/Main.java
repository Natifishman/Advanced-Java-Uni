/**
 * Main - Entry point for managing flights between airports.
 * Initializes airports, creates flight instances, and starts the execution.
 * 
 * Written by Natanel Fishman for Maman 15, Question 2.
 */

import java.util.Random;

public class Main {

    // Define the number of flights as a constant
    private static final int NUM_OF_FLIGHTS = 10;

    public static void main(String[] args) {
        // Initialize a random number generator
        Random rnd = new Random();

        // Create airport instances for Ben Gurion Airport (Tel Aviv) and Heydar Aliyev
        // Airport (Baku)
        AirPort benGurionAirport = new AirPort("Ben Gurion Airport");
        AirPort heydarAliyevAirport = new AirPort("Heydar Aliyev Airport");

        // Initialize an array to hold flight instances
        Flight[] flights = new Flight[NUM_OF_FLIGHTS];

        // Loop to create and initialize flight instances
        for (int i = 0; i < NUM_OF_FLIGHTS; i++) {
            // Randomly decide the flight direction
            if (rnd.nextBoolean()) {
                flights[i] = new Flight(i + 1, benGurionAirport, heydarAliyevAirport); // Flight from Ben Gurion to Heydar Aliyev
            } else {
                flights[i] = new Flight(i + 1, heydarAliyevAirport, benGurionAirport); // Flight from Heydar Aliyev to Ben Gurion
            }
        }

        // Start each flight
        for (int i = 0; i < NUM_OF_FLIGHTS; i++) {
            flights[i].start();
        }
    }
}