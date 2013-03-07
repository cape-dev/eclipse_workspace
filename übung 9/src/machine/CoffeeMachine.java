package machine;

/**
 * 
 * @author Can Pekesen
 * 
 */

public class CoffeeMachine {

	int cup, beans, milk, bag;

	/**
	 * represents the tests for the whole project
	 * 
	 */
	public static void main(String[] args) {
		CoffeeMachine Tchibo_ax3000 = new CoffeeMachine();

		// variables for testbench:
		CoffeeMachine test1 = new CoffeeMachine(000, 100, 100, 100);
		CoffeeMachine test2 = new CoffeeMachine(100, 000, 100, 100);
		CoffeeMachine test3 = new CoffeeMachine(100, 100, 000, 100);
		CoffeeMachine test4 = new CoffeeMachine(100, 100, 100, 000);

		Tchibo_ax3000.Order(0);
		System.out.println();
		Tchibo_ax3000.Order(4);
		System.out.println();
		Tchibo_ax3000.Order(1);
		System.out.println();
		Tchibo_ax3000.Order(2);
		System.out.println();
		Tchibo_ax3000.Order(3);
		System.out.println();
		System.out.println("Ressourcenstand nach 3 Bestellungen:");
		System.out.println(Tchibo_ax3000.cup);
		System.out.println(Tchibo_ax3000.beans);
		System.out.println(Tchibo_ax3000.milk);
		System.out.println(Tchibo_ax3000.bag);
		System.out.println();

		Tchibo_ax3000.refill();
		System.out.println("Ressourcenstand nach dem Refill:");
		System.out.println(Tchibo_ax3000.cup);
		System.out.println(Tchibo_ax3000.beans);
		System.out.println(Tchibo_ax3000.milk);
		System.out.println(Tchibo_ax3000.bag);
		System.out.println();

		System.out
				.println("Folgend sind die Fälle für ungenügende Ressourcen:");
		test1.Order(1);
		test2.Order(1);
		test3.Order(2);
		test4.Order(3);
		System.out.println();

		System.out
				.println("Folgend sind die Fälle für negative Flüssigkeitsangaben:");

		Order neu = new Order();
		neu.addMilk(-20);
		neu.addWater(-30);
	}

	/**
	 * constructor for the class 'CoffeeMachine'
	 */
	CoffeeMachine() {
		cup = 100;
		beans = 1000;
		milk = 500;
		bag = 50;
	}

	/**
	 * second constructor. just for the testbench
	 */
	CoffeeMachine(int cup, int beans, int milk, int bag) {
		this.cup = cup;
		this.beans = beans;
		this.milk = milk;
		this.bag = bag;
	}

	/**
	 * resets the resources of the machine
	 * 
	 */
	void refill() {
		this.cup = 100;
		this.beans = 1000;
		this.milk = 500;
		this.bag = 50;
	}

	/**
	 * displays the chosen product with its ingredients if it's not affordable
	 * the reason why it isn't shows up in the console
	 * 
	 * @param sort
	 *            represents the chosen product
	 * @return returns a boolean whether the chosen product is affordable or not
	 */

	boolean Order(int sort) {
		Order order = new Order();
		order.setDrink(sort);

		if (cup >= 1)

			switch (sort) {

			case 1: {
				if (beans < 15) {
					System.out.println("Keine Bohnen mehr vorhanden.");
					return false;
				} else if (order.addWater(250) == false) {
					System.out
							.println("Der Becher ist nicht groß genug um die erforderliche Menge an Wasser hinzuzufügen.");
					return false;
				} else {
					order.addWater(250);
					beans -= 15;
					cup -= 1;
					OutputUnit.outputOrder(order);
					return true;
				}

			}
			case 2: {
				if (beans < 10) {
					System.out.println("Keine Bohnen mehr vorhanden.");
					return false;
				} else if (milk < 100) {
					System.out.println("Keine Milch mehr vorhanden.");
					return false;
				} else if (order.addWater(150) == false) {
					System.out
							.println("Der Becher ist nicht groß genug um die erforderliche Menge an Wasser hinzuzufügen.");
					return false;
				} else {
					order.addWater(150);
					if (order.addMilk(100) == false) {
						System.out
								.println("Der Becher ist nicht groß genug um die erforderliche Menge an Milch hinzuzufügen.");
						return false;
					} else {
						order.addMilk(100);
						beans -= 10;
						cup -= 1;
						milk -= 100;
						OutputUnit.outputOrder(order);
						return true;
					}
				}

			}
			case 3: {
				if (bag < 1) {
					System.out.println("Keine Beutel mehr vorhanden.");
					return false;
				} else if (order.addWater(250) == false) {
					System.out
							.println("Der Becher ist nicht groß genug um die erforderliche Menge an Wasser hinzuzufügen.");
					return false;
				} else {
					order.addWater(250);
					cup -= 1;
					bag -= 1;
					OutputUnit.outputOrder(order);
					return true;
				}
			}
			default: {
				OutputUnit.outputOrder(order);
				return false;
			}
			}
		else {
			System.out.println("Keine Becher mehr vorhanden.");
			return false;
		}

	}

}
