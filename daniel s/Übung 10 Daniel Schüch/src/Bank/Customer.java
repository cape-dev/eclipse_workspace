package Bank;

public class Customer{

	
	String Vorname;
	String Nachname;
	String Adresse;
	
	/**
	 * Gibt die Adresse zurück
	 * @return Adresse
	 */
	public String getAdresse() {
		return Adresse;
	}
	/**
	 * Gibt den Nachname zurück
	 * @return Nachname
	 */
	public String getNachname() {
		return Nachname;
	}
	/**
	 * Gibt den Vornamen zurück
	 * @return Vorname
	 */
	public String getVorname() {
		return Vorname;
	}
	/**
	 * Setzt dden Vornamen
	 * @param vorname
	 */
	public void setVorname(String vorname) {
		Vorname = vorname;
	}
	/**
	 * Setzt den Nachnamen
	 * @param nachname
	 */
	public void setNachname(String nachname) {
		Nachname = nachname;
	}
	/**
	 * Setzt die Adresse
	 * @param adresse
	 */
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	/**
	 * Konstruktor, Setzt die Variablen Vorname, Nachname, Adresse
	 * @param Vorname
	 * @param Nachname
	 * @param Adresse
	 */
	public Customer(String Vorname, String Nachname, String Adresse) {
		this.Vorname = Vorname;
		this.Nachname = Nachname;
		this.Adresse = Adresse;
	}
	
	/**
	 * Gibt den kompletten Namen zurück
	 * @return String
	 */
	public String getFullName(){
		return Vorname+" "+Nachname;
	}
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean equals(Object obj){
		Customer a = (Customer) obj;
		if (this.Vorname == a.getVorname() && this.Nachname == a.getNachname() && this.Adresse == a.getAdresse()) return true;
		else return false;
		
	}
}
