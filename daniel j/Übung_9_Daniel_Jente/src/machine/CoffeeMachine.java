/**
 * 
 */
package machine;

/**
 * @author Daniel Jente
 *
 */
public class CoffeeMachine {
	
	private int Becher = 0;
	private int Kaffeebohnen = 0;
	private int Milch = 0;
	private int Teebeutel = 0;
	
	/**
	 * füllt die Bestände des Automaten neu auf
	 */
	public void refill (){
		Becher = 100;
		Kaffeebohnen = 1000;
		Milch = 500;
		Teebeutel = 50;
	}
	
	/**
	 * gibt eine Bestellung auf
	 * @param Getränk
	 * @return true & Bestellung, wenn eine Bestellung aufgegeben werden konnte
	 *         und false, wenn keine Bestellung getätigt werden konnte
	 */

	public boolean order (int Getränk){
		
		boolean value = true;
		
		Order Bestellung = new Order();
		
		switch (Getränk){
		
		case 1:{
			if (Kaffeebohnen < 15){
				System.out.println("Es mangelt an Kaffeebohnen.");
				value = false;
			}
			if (Becher < 1){
				System.out.println("Es mangelt an Bechern.");
				value = false;
			}
			if (value){
				Kaffeebohnen -= 15;
				Becher -=1;
				Bestellung.setDrink("Kaffee");
				Bestellung.addWater(250);
			}
			break;			
		}	
		
		case 2:{
			if (Kaffeebohnen < 10){
				System.out.println("Es mangelt an Kaffeebohnen.");
				value = false;
			}
			if (Milch <100){
				System.out.println("Es mangelt an Milch.");
				value = false;
			}
			if (Becher < 1){
				System.out.println("Es mangelt an Bechern.");
				value = false;
			}
			
			if (value){
				Kaffeebohnen -= 10;
				Milch -= 100;
				Becher -=1;
				Bestellung.setDrink("Cappuccino");
				Bestellung.addMilk(100);
				Bestellung.addWater(150);
			}
			break;			
		}
		
		case 3:{
			if (Teebeutel < 1){
				System.out.println("Es mangelt an Teebeuteln.");
				value = false;
			}
			if (Becher < 1){
				System.out.println("Es mangelt an Bechern.");
				value = false;
			}
			if (value){
				Teebeutel -= 1;
				Becher -= 1;
				Bestellung.setDrink("Tee");
				Bestellung.addWater(250);
			}
			break;			
		}
		
		default:{
			System.out.println("Getränk nicht vorhanden.");
			value = false;
			}
		
		}
		
		if (value) OutputUnit.OutputOrder(Bestellung);
		
		return value;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		CoffeeMachine my_object = new CoffeeMachine();
		
		System.out.println(my_object.order(1));
		
		my_object.refill();
		
		System.out.println(my_object.order(1));
	}

}
