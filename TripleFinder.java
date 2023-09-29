// Name: Brendan Doyle
// Student ID: A01329024
// Date: 29/09/2023

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Starter code for Lab 1 - finding a "mult37-triple" in a data file by 
 * two different algorithms and comparing the running times.
 * 
 * TODO: ADD YOUR NAME AND ID HERE!
 */
public class TripleFinder {

	/*
	 * RESULTS STORAGE ZONE Here is where you can declare private members of your class
	 * used to save results and other data so that they can be requested from the
	 * calling program at any time needed. Keep them private! Their values will be
	 * accessed via getter methods.
	 */
	private Integer[] theTriple = new Integer[3];

	/*
	 * Brute Force algorithm for finding the mult37-triple.
	 */
	public void findTripleBruteForce(Integer[] listOfIntegers) {
		// TODO: FINISH THIS METHOD
	}

	/*
	 * "Clever" algorithm for finding the mult37-triple.
	 */
	public void findTripleClever(Integer[] listOfIntegers) {
		// TODO: FINISH THIS METHOD
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
		// TODO: FINISH THIS METHOD
		return 373737;
	}

	/*
	 * Getter that returns the running time, in milliseconds, of the last time the
	 * Brute Force algorithm was used. This running time should include the entire
	 * contents of the findTripleBruteForce() method.
	 */
	public long getBruteForceRuntime() {
		// TODO: FINISH THIS METHOD
		return 373737;
	}

	/*
	 * Getter that returns the number of operations performed the last time the
	 * Clever algorithm was used. An operation should be counted every time 
	 * the "mod" operator (%) is used fr any purpose.
	 */
	public long getCleverOperations() {
		// TODO: FINISH THIS METHOD
		return 373737;
	}

	/*
	 * Getter that returns the running time, in milliseconds, of the last time the
	 * Clever algorithm was used. This running time should include the entire
	 * contents of the findTripleClever() method.
	 */
	public long getCleverRuntime() {
		// TODO: FINISH THIS METHOD
		return 373737;
	}

}
