/**
 * 
 * @author Can Pekesen
 * 
 */
public class LimitedWithdrawAccount extends Account {

	/**
	 * minimal amount of the account
	 */
	long maxWithdraw;

	/**
	 * constructor
	 */
	public LimitedWithdrawAccount(int pin, long actAmount, long maxWithdraw) {
		super(pin, actAmount);
		this.maxWithdraw = maxWithdraw;
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
		if ((this.PIN == PIN) && (amount <= this.maxWithdraw)) {
			this.actAmount -= amount;
			return true;
		} else
			return false;
	}

}
