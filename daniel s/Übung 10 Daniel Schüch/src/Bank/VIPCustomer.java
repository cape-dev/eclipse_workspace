package Bank;

public class VIPCustomer extends Customer{
	
	String Titel;
	
	public void setTitel(String titel) {
		Titel = titel;
	}
	public String getTitel() {
		return Titel;
	}
	
	public VIPCustomer(String Titel, String Vorname, String Nachname, String Adresse) {
		this.Titel = Titel;
		this.Vorname = Vorname;
		this.Nachname = Nachname;
		this.Adresse = Adresse;
	}
	
	@Override
	public String getFullName() {
		return Titel+" "+Vorname+" "+Nachname;
	}
}
