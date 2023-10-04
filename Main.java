// Name: Brendan Doyle
// Student ID: A01329024
// Date: 29/09/2023

import java.io.IOException;

/*
  * Takes in a file of integers and finds a triple of integers whose sum is a multiple of 37.
 */
public class Main {
  /*
    * Main method for the program. Reads the file, executes the 2 algorithms, and displays the results.
   */
  public static void main(String[] args) {
    // Create an instance of the TripleFinder class
    TripleFinder finder = new TripleFinder();

    try {
      // Read the array from the file
      Integer[] numbers = TripleFinder.readArray("zzz151.txt");

      // Execute the brute force algorithm
      finder.findTripleBruteForce(numbers);
      // Retrieve and display results from the brute force algorithm
      displayResults("Brute Force", finder.getTheTriple(), finder.getBruteForceOperations(), finder.getBruteForceRuntime());

      // Execute the clever algorithm
      finder.findTripleClever(numbers);
      // Retrieve and display results from the clever algorithm
      displayResults("Clever Algorithm", finder.getTheTriple(), finder.getCleverOperations(), finder.getCleverRuntime());

    } catch (IOException e) {
      e.printStackTrace();
      System.err.println("Error reading the input file. Please ensure the file path is correct.");
    }
  }

  /*
    * Displays the results of the 2 algorithms, found triple, number of operations and run time.
   */
  private static void displayResults(String algorithmName, Integer[] triple, long operations, long runtime) {
    System.out.println("Results for: " + algorithmName);
    System.out.println("Found Triple: " + triple[0] + ", " + triple[1] + ", " + triple[2]);
    System.out.println("Number of operations performed: " + operations);
    System.out.println("Running time (ms): " + runtime);
    System.out.println("------------------------------------------------------");
  }
}

