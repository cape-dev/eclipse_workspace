package GDICalendar;
import java.util.GregorianCalendar;

/**
 * This class represents an entry in our calendar.
 * All entries in the Calendar are instances of the class CalendarEntry.
 *
 * @author Can Pekesen
 * @version 1.0
 */
public class CalendarEntry {
	
	private boolean priv;

  /**
   * the description of this calendar entry
   */
  private String description;

  /**
   * the owner of this calendar entry
   */
  private User owner;


  /**
   * the date and time for this entry
   */
  private GregorianCalendar time;

  /**
   * Construct a new CalendarEntry object.
   *
   * @param time the GregorianCalendar representing the date and 
   * time of the entry.
   * @param description a String describing the nature of the entry.
   * @param owner the User object who owns this entry.
   */
  public CalendarEntry(GregorianCalendar time, String description, 
		       User owner) {
	  // TODO Implement me!
  }


  /**
   * returns a String representation of this CalendarEntry.
   *
   * @return a String representing this object
   */
  @Override
  public String toString() {
	  // TODO Implement me!
  }
}
