/**
 * Project: A00123456Lab2
 * File: Lab2.java
 */

package a00123456;

import a00123456.data.Customer;
import a00123456.io.CustomerReader;
import a00123456.io.CustomerReport;

/**
 * To demonstrate knowledge of Strings Simple regular expressions Formatting output, Object design, and Jar Files
 * 
 * Create a commandline program which reads customer data, creates customer objects, adds them to an array, and prints a
 * simple customer report
 * 
 * 
 * @author Sam Cirka, A00123456
 *
 */
public class Lab2 {

	private String customerData;
	private Customer[] customers;

	/**
	 * Entry point for Lab2
	 * 
	 * @param args
	 *            an input string containing all the customer details.
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Input data is missing. Expecting customer data.");
			System.exit(-1);
		}

		new Lab2(args[0]).run();
	}

	/**
	 * Lab2 constructor. Initialized the customers collection.
	 * 
	 * @param customerData
	 *            the customer details.
	 * 
	 */
	public Lab2(String customerData) {
		this.customerData = customerData;
	}

	/**
	 * Populate the customers and print them out.
	 */
	private void run() {
		customers = CustomerReader.read(customerData);
		CustomerReport.write(customers);
	}

}
