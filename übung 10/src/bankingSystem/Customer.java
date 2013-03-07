/**
 * @author Can Pekesen
 */
package bankingSystem;

public class Customer {

	/**
	 * the surname of a customer
	 */
	String surname;

	/**
	 * the name of a customer
	 */
	String name;

	/**
	 * the address of a customer
	 */
	String address;

	public Customer() {

	}

	/**
	 * creates an instance of customer and sets the surname, name and address
	 * 
	 * @param surname
	 *            is the surname of a customer
	 * @param name
	 *            is the name of a customer
	 * @param adress
	 *            is the address of a customer
	 */
	public Customer(String surname, String name, String address) {
		this.surname = surname;
		this.name = name;
		this.address = address;

	}

	/**
	 * get the surname
	 */
	public String getSurname() {
		return this.surname;
	}

	/**
	 * get the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * get the address
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * get the full name
	 */
	public String getFullName() {
		return (surname + " " + name);
	}

	@Override
	public boolean equals(Object obj) {
		Customer customer = (Customer) obj;
		if ((customer.getFullName() == this.getFullName())
				|| (customer.getAddress() == this.getAddress()))
			return true;
		else
			return false;

	}

}
