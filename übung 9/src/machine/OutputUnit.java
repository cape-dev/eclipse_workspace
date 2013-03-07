package machine;

/**
 * 
 * @author Can Pekesen
 * 
 */

public class OutputUnit {

	static void outputOrder(Order order) {

		switch (order.getDrink()) {

		case 1: {
			System.out.println("Hier ist ihre Bestellung:");

			System.out.println("Eine Tasse Kaffee zu " + order.getLevel()
					+ "ml befüllt.");

			System.out.println("Davon sind " + order.getWater() + "ml Wasser und "
					+ order.getMilk() + "ml Milch.");
		}
			break;
		case 2: {
			System.out.println("Hier ist ihre Bestellung:");

			System.out.println("Eine Tasse Capuccino zu " + order.getLevel()
					+ "ml befüllt.");

			System.out.println("Davon sind " + order.getWater() + "ml Wasser und "
					+ order.getMilk() + "ml Milch.");
		}
			break;
		case 3: {
			System.out.println("Hier ist ihre Bestellung:");

			System.out.println("Eine Tasse Tee zu " + order.getLevel()
					+ "ml befüllt.");

			System.out.println("Davon sind " + order.getWater() + "ml Wasser und "
					+ order.getMilk() + "ml Milch.");
		}
			break;
		default:
			System.out.println("Es Wurde nichts bestellt.");
		}

	}

}
