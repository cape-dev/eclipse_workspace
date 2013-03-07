/**
 * @author Can Pekesen
 */
package bankingSystem;



public class VIPCustomer extends Customer {
	

	/**
	 * the title of a VIPCustomer
	 */
	String title;
	
	public VIPCustomer(String title, String surname, String name, String address){
		super();
		this.title = title;
		this.surname = surname;
		this.name = name;
		this.address = address;
	}
	
	/**
	 * returns the title + fullname
	 */
	@Override
	public String getFullName(){
		return (this.title + " " + super.getFullName());
	}
	

}
