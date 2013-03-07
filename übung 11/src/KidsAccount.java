/**
 * 
 * @author Can Pekesen
 * 
 */
public class KidsAccount extends Account {

	public KidsAccount(int pin, long actAmount) {
		super(pin, actAmount);
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
		if ((this.PIN == PIN) && (1000 >= amount)
				&& (this.getAmount() >= amount)) {
			this.actAmount -= amount;
			return true;
		} else
			return false;

	}

}
