/**
 * 
 */
package machine;

/**
 * @author Daniel Jente
 *
 */
public class OutputUnit {

	/**
	 * gibt die Bestellung von object aus
	 * @param object (Objekt von Order)
	 */
	
	public static void OutputOrder (Order object){
	
	String help;
	
	System.out.println("Hier ist Ihre Bestellung:");
	
	switch (object.getDrink()){
	case 1: help = "Kaffee"; break;
	case 2: help = "Cappuccino"; break;
	case 3: help = "Tee"; break;
	default: help = "Unbekannt"; break;
	}

	
	System.out.println("Eine Tasse " + help + " zu " + object.getLevel() + "ml befüllt.");
	
	System.out.println("Davon sind " + object.getWater() + "ml Wasser und " + object.getMilk() + "ml Milch.");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Test
		
		Order my_object = new Order();
		
		my_object.addWater(150);
		my_object.addMilk(100);
		my_object.setDrink("Cappuccino");
		
		OutputOrder(my_object);

	}

}
