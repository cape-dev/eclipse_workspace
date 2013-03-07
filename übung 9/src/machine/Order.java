package machine;

/**
 * 
 * @author Can Pekesen
 * 
 */

public class Order {
	int waterMl, milkMl, level, cupMl;

	private int drink;

	/**
	 * constructor for the class 'Order'
	 */
	Order() {
		cupMl = 250;
		level = waterMl + milkMl;
	}

	/**
	 * adds milk in ml to the order
	 * 
	 * @param ml
	 *            parameter for the amount of milk
	 * @return true or false whether the liquid could be add
	 */
	boolean addMilk(int ml) {
		if (ml < 0){
			System.out.println("Es dürfen keine negativen Flüssigkeitsangaben gemacht werden.");
			return false;
		}
		if ((level + ml) <= cupMl) {
			level += ml;
			milkMl += ml;
			return true;
		} else
			return false;
	}

	/**
	 * adds water in ml to the order
	 * 
	 * @param ml
	 *            parameter for the amount of water
	 * @return true or false whether the liquid could be add
	 */
	boolean addWater(int ml) {
		if (ml < 0){
			System.out.println("Es dürfen keine negativen Flüssigkeitsangaben gemacht werden.");
			return false;
		}
		if ((level + ml) <= cupMl) {
			level += ml;
			waterMl += ml;
			return true;
		} else
			return false;
	}

	/**
	 * method returns the amount of milk in the order
	 * 
	 * @return amount of milk
	 */
	int getMilk() {
		return milkMl;
	}

	/**
	 * method returns the amount of water in the order
	 * 
	 * @return amount of water
	 */
	int getWater() {
		return waterMl;
	}

	/**
	 * method returns the total amount of liquid in the order
	 * 
	 * @return total amount of liquid
	 */
	int getLevel() {
		return level;
	}

	/**
	 * sets the variable drink to chosen drink
	 * 
	 * @param drink
	 *            represents the chosen drink in an int variable
	 */
	void setDrink(int drink) {
		this.drink = drink;
	}

	/**
	 * method returns the chosen kind of drink
	 * 
	 * @return returns 1 for coffee, 2 for cappuccino, 3 for tea and 0 for no
	 *         choice
	 */
	int getDrink() {
		if ((this.drink >= 1) || (this.drink <= 3))
			return this.drink;
		else
			return 0;
	}

}
