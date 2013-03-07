/**
 * 
 * @author Can Pekesen
 * 
 */
public class CheckingAccount extends Account {

	public static void main(String[] args) {

	}

	/**
	 * minimal amount of the account
	 */
	long minAmount;

	/**
	 * constructor
	 */
	public CheckingAccount(int pin, long actAmount, long minAmount) {
		super(pin, actAmount);
		this.minAmount = minAmount;
	}

	/**
	 * 
	 * allows you to pick up money if your pin is correct and if the actual
	 * amount of your account wouldn't be beneath the min amount
	 * 
	 * @return true or false
	 */
	@Override
	public boolean withdraw(int PIN, long amount) {
		if ((this.PIN == PIN) && ((this.actAmount - amount) >= this.minAmount)) {
			this.actAmount -= amount;
			return true;
		} else
			return false;

	}

}
