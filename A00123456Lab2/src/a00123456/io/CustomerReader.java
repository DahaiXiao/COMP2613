/**
 * Project: A00123456Lab2
 * File: CustomerReader.java
 */

package a00123456.io;

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
	 */
	public static Customer[] read(String data) {
		String[] rows = data.split(RECORD_DELIMITER);
		Customer[] customers = new Customer[rows.length];
		int i = 0;
		long id;
		String firstName;
		String lastName;
		String street;
		String city;
		String postalCode;
		String phone;
		String emailAddress;

		for (String row : rows) {
			String[] elements = row.split(FIELD_DELIMITER);
			int index = 0;
			id = Integer.parseInt(elements[index++]);
			firstName = elements[index++];
			lastName = elements[index++];
			street = elements[index++];
			city = elements[index++];
			postalCode = elements[index++];
			phone = elements[index++];
			// should the email validation be performed here or in the customer class? I'm leaning towards putting it here.
			emailAddress = elements[index++];
			if (!Validator.validateEmail(emailAddress)) {
				emailAddress = "N/A";
			}

			Customer customer = new Customer.Builder(id, phone).setFirstName(firstName).setLastName(lastName).setStreet(street).setCity(city)
					.setPostalCode(postalCode).setEmailAddress(emailAddress).build();
			customers[i++] = customer;
		}

		return customers;
	}
}
