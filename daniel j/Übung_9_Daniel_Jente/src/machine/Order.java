/**
 * 
 */
package machine;

/**
 * @author Daniel Jente
 *
 */
public class Order {
	
	private int Milk = 0;
	private int Water = 0;
	private int drink = 0;
			

	/**
	 * f�gt der Bestellliste Milch(in ml) hinzu
	 * @param amount (Menge in Milliliter)
	 */
	public boolean addMilk (int amount){
		if ((Water + Milk + amount) > 250){
			System.out.println("Diese Menge Milch kann nicht hinzugef�gt werden, da der 250 ml Becher sonst �berf�llt ist.");
			return false;
		}
		else{
			if (amount <0){
				System.out.println("Es darf keine Fl�ssigkeit abgezogen werden.");
				return false;
			}
			else{
			Milk +=amount;
			return true;
			}
		}
	
	}
	
	/**
	 * f�gt der Bestellliste Wasser(in ml) hinzu
	 * @param amount (Menge in Milliliter)
	 */
	public boolean addWater (int amount){
		if ((Milk + Water + amount) > 250){
			System.out.println("Diese Menge Wasser kann nicht hinzugef�gt werden, da der 250 ml Becher sonst �berf�llt ist.");
			return false;
		}
		else{
			if (amount <0){
				System.out.println("Es darf keine Fl�ssigkeit abgezogen werden.");
				return false;
			}
			else{
			Water +=amount;
			return true;
			}
		}
	
	}
	
	/**
	 * gibt Milchanteil des Getr�nks aus (in Milliliter)
	 * @return Milk
	 */
	public int getMilk() {
		return Milk;
	}
	
	/**
	 * gibt Wasseranteil des Getr�nks aus  (in Milliliter)
	 * @return Water
	 */
	public int getWater() {
		return Water;
	}
	
	/**
	 * gibt F�llstand des Getr�nks aus  (in Milliliter)
	 * @return Milk+Water
	 */
	public int getLevel() {
		return Milk+Water;

	}
	
	/**
	 * setzt Zahlenwert f�r das entsprechende Getr�nk
	 * wenn es nicht verifiziert werden kann, ist es 0
	 * @param Getr�nk = Art des Getr�nks
	 * @return Zahlenwert des Getr�nk
	 */
	
	public void setDrink(String Getr�nk) {
		if (Getr�nk.equals("Kaffee")) drink = 1;
		else if (Getr�nk.equals("Cappuccino")) drink = 2;
				else if (Getr�nk.equals("Tee")) drink = 3;
					else drink = 0;
	}
	
	/**
	 * 	liefert Zahlenwert vom Getr�nk
	 * @return Zahlenwert vom Getr�nk
	 */
	public int getDrink() {
		return drink;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Meine Tests
		
		Order my_object = new Order();
		
		System.out.println(my_object.addMilk(500));
		System.out.println(my_object.addMilk(100));
		System.out.println(my_object.addMilk(151));
		System.out.println(my_object.addMilk(-1));

		System.out.println(my_object.getMilk());
		
		
		System.out.println(my_object.addWater(500));
		System.out.println(my_object.addWater(250));
		System.out.println(my_object.addWater(1));
		System.out.println(my_object.addWater(-250));
		
		System.out.println(my_object.getWater());
		
		System.out.println(my_object.getLevel());
		
		my_object.setDrink("Kaffee");
		System.out.println(my_object.getDrink());
		
		my_object.setDrink("Cappuccino");
		System.out.println(my_object.getDrink());
		
		my_object.setDrink("Tee");
		System.out.println(my_object.getDrink());
		
		my_object.setDrink("Cola");
		System.out.println(my_object.getDrink());
		
	}

}
