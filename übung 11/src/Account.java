/**
 * 
 * @author Can Pekesen
 * 
 */
public abstract class Account {

	/**
	 * represents the pin number of an account
	 */
	int PIN;

	/**
	 * represents the actual amount of an account
	 */
	long actAmount;

	Account(int pin, long actAmount) {
		this.PIN = pin;
		this.actAmount = actAmount;
	}

	/**
	 * increase the amount of money (pay in)
	 */
	public void deposit(long amount) {
		if (amount > 0)
			this.actAmount += amount;
	}

	/**
	 * returns the actual amount
	 */
	public long getAmount() {
		return this.actAmount;
	}

	abstract boolean withdraw(int PIN, long amount);

}
