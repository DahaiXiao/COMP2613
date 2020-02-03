/**
 * Project: A00123456Lab3
 * File: Lab3.java
 * Copyright 2017 Sam Cirka. All rights reserved.
 */

package a00123456;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import a00123456.data.Customer;
import a00123456.io.CustomerReader;
import a00123456.io.CustomerReport;

/**
 * To demonstrate knowledge of Strings Simple regular expressions Formatting output Object design Jar Files.
 * Create a commandline program which reads customer data, creates Customer objects, adds them to an array, and prints a simple Customer report
 * 
 * @author Sam Cirka, A00123456
 *
 */
public class Lab3 {

	private static final Instant startTime = Instant.now();

	/**
	 * Entry point for Lab 3
	 * 
	 * @param args
	 *            the customer input data, passed as a quoted string in the first argument.
	 */
	public static void main(String[] args) {
		System.out.println(startTime);

		if (args.length == 0) {
			System.out.println("Input data is missing. Expecting customer data.");
			printEndTimeAndDuration();
			System.exit(-1);
		}

		new Lab3().run(args[0]);
	}

	public static void printEndTimeAndDuration() {
		Instant endTime = Instant.now();
		System.out.println(endTime);

		// three ways to print the duration, pick your favourite
		/* 1. */ System.out.println(String.format("Duration: %d ms", (endTime.getNano() - startTime.getNano()) / 1_000_000));
		/* 2. */ System.out.println(String.format("Duration: %d ms", ChronoUnit.MILLIS.between(startTime, endTime)));
		/* 3. */ System.out.println(String.format("Duration: %d ms", Duration.between(startTime, endTime).toMillis()));
	}

	/**
	 * Load the customers and print them out.
	 */
	private void run(String customerData) {
		try {
			Customer[] customers = CustomerReader.read(customerData);
			CustomerReport.write(customers);
		} catch (ApplicationException e) {
			System.out.println(e.getMessage());
		} finally {
			printEndTimeAndDuration();
		}
	}

}
