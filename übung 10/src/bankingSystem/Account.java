/**
 * @author Can Pekesen
 */
package bankingSystem;

public class Account {

	/**
	 * represents the account number for an account and it's after its
	 * initialization not changeable
	 */
	final long accNumber;

	/**
	 * it's the amount which must be on an account by minimum in cents (also not
	 * changeable)
	 */
	final long minAmount;

	/**
	 * this is the current amount of money in cents
	 */
	long amount;

	/**
	 * an account belongs to a customer
	 */
	Customer customer;

	/**
	 * creates an instance of Account with accnumber and amount
	 * 
	 * @param accNumber
	 *            represents the accnumber
	 * @param amount
	 *            represents the amount on the account
	 */
	public Account(long accNumber, long amount, Customer customer) {
		this.accNumber = accNumber;
		this.minAmount = 0;
		this.amount = amount;
		this.customer = customer;

	}

	/**
	 * additional constructor which initializes minAmount and Amount with 0
	 */
	public Account(long accNumber, Customer customer) {
		this.accNumber = accNumber;
		this.amount = 0;
		this.minAmount = 0;
		this.customer = customer;
	}

	/**
	 * get the amount of an account
	 * 
	 * @return returns the amount
	 */
	public long getAmount() {
		return amount;
	}

	/**
	 * get the accnumber of an account
	 * 
	 * @return returns the accnumber
	 */
	public long getAccNumber() {
		return accNumber;
	}

	/**
	 * get the min. amount of an account
	 * 
	 * @return returns the min. amount of an account
	 */
	public long getMinAmount() {
		return minAmount;
	}

	/**
	 * increases the total amount of an account by the given amount
	 * 
	 * @param amount
	 *            this is the amount to increase
	 */
	void deposit(long amount) {
		if (amount > 0)
			this.amount += amount;
	}

	/**
	 * withdraws the total amount of an account by the given amount if it's
	 * possible
	 * 
	 * @param amount
	 *            this is the amount to withdraw
	 * @return returns if it is possible to withdraw the total amount without
	 *         beeing less than minAmount (true or false)
	 */
	boolean withdraw(long amount) {
		if ((this.amount - amount) >= this.minAmount) {
			this.amount -= amount;
			return true;
		} else
			return false;

	}

	/**
	 * transfers an given amount from one account to another given
	 * 
	 * @param amount
	 *            this is the amount to transfer
	 * @param target
	 *            this is the target account to transfer to
	 * @return true or false whether it's possible to do the transfer or not
	 */
	boolean transfer(long amount, Account target) {
		if (this.withdraw(amount)) {
			target.deposit(amount);
			return true;
		} else
			return false;
	}

	public static void main(String[] args) {
	}

}
