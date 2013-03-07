package GDICalendar;
/**
 * Instances of the user class own CalendarEntries
 *
 * @author Can Pekesen
 * @version 1.0
 */
public class User {
	
	private String givenName, familyName;


  /**
   * The constructor for User objects
   *
   * @param givenName the first name.
   * @param familyName the last name.
   */
  public User(String givenName, String familyName) {
	  this.givenName = givenName;
	  this.familyName = familyName;
  }
  
  
  String getGivenName() {
	  return this.givenName;
  }
  
  String getFamilyName() {
	  return this.familyName;
  }

}
