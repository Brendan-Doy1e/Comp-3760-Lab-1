// Name: Brendan Doyle
// Student ID: A01329024
// Date: 29/09/2023

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Starter code for Lab 1 - finding a "mult37-triple" in a data file by 
 * two different algorithms and comparing the running times.
 *
 * This program reads a list of integers from a file, and then uses two different
 * algorithms to find a "mult37-triple" in the list. A mult37-triple is a set of
 * three integers from the list whose sum is a multiple of 37.
 * 
 * Brendan Doyle
 * A01329024
 *
 */

public class TripleFinder {

	/*
	 * RESULTS STORAGE ZONE Here is where you can declare private members of your class
	 * used to save results and other data so that they can be requested from the
	 * calling program at any time needed. Keep them private! Their values will be
	 * accessed via getter methods.
	 */
	public final int THIRTYSEVEN = 37;
	private Integer[] theTriple = new Integer[3];
	private long bruteForceOperations = 0;
	private long bruteForceRuntime = 0;
	private long cleverOperations = 0;
	private long cleverRuntime = 0;

	/*
	 * Brute Force algorithm for finding the mult37-triple.
	 *
	 */
	public void findTripleBruteForce(Integer[] listOfIntegers) {
		//initializes a counter for the number of brute force operations
		//bruteForceOperations = 0;
		// gets the current time in milliseconds and stores it in startTime
		long startTime = System.currentTimeMillis();

		// starts a for loop that will iterate through the list of integers
		for (int firstIndex = 0; firstIndex < listOfIntegers.length; firstIndex++) {
			// starts a for loop that will iterate through the list of integers starting at the second index
			for (int secondIndex = firstIndex + 1; secondIndex < listOfIntegers.length; secondIndex++) {
				// starts a for loop that will iterate through the list of integers starting at the third index
				for (int thirdIndex = secondIndex + 1; thirdIndex < listOfIntegers.length; thirdIndex++) {
					bruteForceOperations++; // count the number of operations
					// Adds up the 3 integers at the current indexes
					int sum = listOfIntegers[firstIndex] + listOfIntegers[secondIndex] + listOfIntegers[thirdIndex];
					// checks if the sum is a multiple of 37
					if(sum % THIRTYSEVEN == 0) {
						// if the sum is a multiple of 37, then the triple is found
						theTriple[0] = listOfIntegers[firstIndex];
						theTriple[1] = listOfIntegers[secondIndex];
						theTriple[2] = listOfIntegers[thirdIndex];
						break;
					}
				}
			}
		}
		// subtracts the start time from the current time to get the total runtime
		bruteForceRuntime = System.currentTimeMillis() - startTime;
	}

	/*
	 * "Clever" algorithm for finding the mult37-triple.
	 */
	public void findTripleClever(Integer[] listOfIntegers) {
		cleverOperations = 0;
		long startTime = System.currentTimeMillis();

		Integer[] congruenceArray = new Integer[THIRTYSEVEN];
		Arrays.fill(congruenceArray, -1);

//		for (int index = 0; index < listOfIntegers.length; index++) {
//			int congruenceClass = listOfIntegers[index] % THIRTYSEVEN;
//			cleverOperations++; // count the number of operations
//			congruenceArray[congruenceClass] = listOfIntegers[index];
//		}
		// Have the congruent array, now find the triple
		for (Integer numberX : listOfIntegers) {
			int congruenceClass = numberX % THIRTYSEVEN;
			congruenceArray[congruenceClass] = numberX;
		}

		// Have the congruent array, now find the triple
		for (int firstIndex = 0; firstIndex < THIRTYSEVEN; firstIndex++) {
			for (int secondIndex = firstIndex + 1; secondIndex < THIRTYSEVEN; secondIndex++) {
				for (int thirdIndex = secondIndex + 1; thirdIndex < THIRTYSEVEN; thirdIndex++) {
					cleverOperations++; // count the number of operations
					if (congruenceArray[firstIndex] != -1 && congruenceArray[secondIndex] != -1 && congruenceArray[thirdIndex] != -1) {
						int sum = congruenceArray[firstIndex] + congruenceArray[secondIndex] + congruenceArray[thirdIndex];
						if (sum % THIRTYSEVEN == 0) {
							theTriple[0] = congruenceArray[firstIndex];
							theTriple[1] = congruenceArray[secondIndex];
							theTriple[2] = congruenceArray[thirdIndex];
							break;
						}
					}
				}
			}
		}


		cleverRuntime = System.currentTimeMillis() - startTime;
	}

	/*
	 * Getter for the triple, returns the last triple that was found by this 
	 * instance of the class (either algorithm).
	 */
	public Integer[] getTheTriple() {
		return this.theTriple;
	}

	/*
	 * Getter that returns the number of operations performed the last time the
	 * Brute Force algorithm was used. An operation should be counted every time 
	 * the "mod" operator (%) is used for any purpose.
	 */
	public long getBruteForceOperations() {
		return bruteForceOperations;
	}

	/*
	 * Getter that returns the running time, in milliseconds, of the last time the
	 * Brute Force algorithm was used. This running time should include the entire
	 * contents of the findTripleBruteForce() method.
	 */
	public long getBruteForceRuntime() {
		return bruteForceRuntime;
	}

	/*
	 * Getter that returns the number of operations performed the last time the
	 * Clever algorithm was used. An operation should be counted every time 
	 * the "mod" operator (%) is used fr any purpose.
	 */
	public long getCleverOperations() {
		return cleverOperations;
	}

	/*
	 * Getter that returns the running time, in milliseconds, of the last time the
	 * Clever algorithm was used. This running time should include the entire
	 * contents of the findTripleClever() method.
	 */
	public long getCleverRuntime() {
		return cleverRuntime;
	}

	// ======================================================================================
	//
	// Reads the input file given by "filename", assumed to contain a list of
	// integer numbers. Clones the numbers into a plain array and returns the array.
	//
	public static Integer[] readArray(String filename) throws IOException {
		File file = new File(filename);
		Scanner sc = new Scanner(file);

		//
		// Read the items initially into an ArrayList (for dynamic growth)
		//
		ArrayList<Integer> input_list = new ArrayList<Integer>();
		while (sc.hasNext()) {
			int n = sc.nextInt();
			input_list.add(n);
		}
		sc.close();

		//
		// Copy the ArrayList to an Integer[] array of the proper size
		//
		Integer[] arr = new Integer[input_list.size()];
		arr = input_list.toArray(arr);
		return arr;

	}


}
