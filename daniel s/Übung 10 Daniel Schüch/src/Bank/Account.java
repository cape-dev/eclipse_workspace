package Bank;

public class Account {

	/**
	 * Kontonummer kann nach Intialiserung nicht mehr geändert werden
	 */
	final long Kontonummer;
	
	/**
	 * Kontostand in Cents
	 */
	long Kontostand;  
	
	/**
	 * minimaler Kontostand
	 */
	long minKontostand; 
	
	/**
	 * Gibt die Kontonummer zurück
	 * @return Kontonummer
	 */
	public long getKontonummer() {
		return Kontonummer;
	}
	
	/**
	 * Gibt den Kontostand zurück
	 * @return Kontostand
	 */
	public long getKontostand() {
		return Kontostand;
	}
	
	/**
	 * Gibt den minimalen Kontostand zurück
	 * @return minKontostand
	 */
	public long getMinKontostand() {
		return minKontostand;
	}
	
	/**
	 * Setzt den minimalen Kontotstand
	 * @param minKontostand
	 */
	public void setMinKontostand(long minKontostand) {
		this.minKontostand = minKontostand;
	}
	
	/**
	 * Setzt den Kontostand
	 * @param kontostand
	 */
	public void setKontostand(long kontostand) {
		Kontostand = kontostand;
	}
	
	/**
	 * Konstruktor, setzt die Variablen Kontonummer, Kontostand, minKontostand
	 * @param Kontonummer
	 * @param Kontostand
	 * @param minKontostand
	 */
	public Account(long Kontonummer, long Kontostand, long minKontostand) {
	 this.Kontonummer = Kontonummer;
	 this.Kontostand = Kontostand;
	 this.minKontostand = minKontostand;
	}
	
	/**
	 * Setzt den Kontostand und minKontostand auf 0
	 */
	public void Null(){
		Kontostand = 0;
		minKontostand = 0;
	}
	
	/**
	 * Erhöht den Kontastand um den gewünschten Betrag amount
	 * @param amount
	 */
	public void  deposit(long amount){
		Kontostand = Kontostand + amount;
	}
	
	/**
	 * Veringert den Kontostand um den gewünschten Betrag, wenn
	 * der Kontostand nicht unter den minimalen Kontostand sinkt
	 * @param amount
	 * @return boolean
	 */
	public boolean withdraw(long amount){
		if (Kontostand - amount < minKontostand){
			return false;
		}
		else {
			Kontostand = Kontostand - amount;
			return true;
		}
	}
	
	/**
	 * Zieht den Betrag amount vom Kontostand ab udn tranferiert ihn zu einem anderen Konto
	 * @param amount
	 * @param target
	 * @return boolean
	 */
	public boolean transfer(long amount, Account target){
		if (withdraw (amount)){
			target.deposit(amount);
			return true;
		} else return false;
	}
	
	
}
