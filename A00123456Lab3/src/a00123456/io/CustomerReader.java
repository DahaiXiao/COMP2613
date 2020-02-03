/**
 * Project: A00123456Lab3
 * File: CustomerReader.java
 * Copyright 2017 Sam Cirka. All rights reserved.
 */

package a00123456.io;

import java.time.LocalDate;
import java.util.Arrays;

import a00123456.ApplicationException;
import a00123456.data.Customer;
import a00123456.util.Validator;

/**
 * Read the customer input.
 * 
 * @author Sam Cirka, A00123456
 *
 */
public class CustomerReader {

	public static final String RECORD_DELIMITER = ":";
	public static final String FIELD_DELIMITER = "\\|";

	/**
	 * private constructor to prevent instantiation
	 */
	private CustomerReader() {
	}

	/**
	 * Read the customer input data.
	 * 
	 * @param data
	 *            The input data.
	 * @return An array of customers.
	 * @throws ApplicationException
	 *             throws an exception if the input contains invalid data
	 */
	public static Customer[] read(String data) throws ApplicationException {
		String[] rows = data.split(RECORD_DELIMITER);
		Customer[] customers = new Customer[rows.length];
		int i = 0;

		for (String row : rows) {
			Customer customer = readCustomerString(row);
			customers[i++] = customer;
		}

		return customers;
	}

	/**
	 * Parse a Customer data string into a CUstomer object;
	 * 
	 * @param row
	 *            a customer record string
	 * @throws ApplicationException
	 *             throws an exception if the input contains invalid data
	 */
	private static Customer readCustomerString(String row) throws ApplicationException {
		String[] elements = row.split(FIELD_DELIMITER);
		if (elements.length != Customer.ATTRIBUTE_COUNT) {
			throw new ApplicationException(String.format("Expected %d but got %d: %s", Customer.ATTRIBUTE_COUNT, elements.length, Arrays.toString(elements)));
		}

		int index = 0;
		long id = Integer.parseInt(elements[index++]);
		String firstName = elements[index++];
		String lastName = elements[index++];
		String street = elements[index++];
		String city = elements[index++];
		String postalCode = elements[index++];
		String phone = elements[index++];
		// should the email validation be performed here or in the customer class? I'm leaning towards putting it here.
		String emailAddress = Validator.getValidEmail(elements[index++]);
		LocalDate joinDate = Validator.getValidJoinedDate(elements[index]);
		Customer customer = null;

		customer = new Customer.Builder(id, phone) //
				.setFirstName(firstName) //
				.setLastName(lastName) //
				.setStreet(street) //
				.setCity(city) //
				.setPostalCode(postalCode) //
				.setEmailAddress(emailAddress) //
				.setJoinedDate(joinDate).build();

		return customer;
	}

}
