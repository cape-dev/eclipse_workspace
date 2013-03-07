package GDICalendar;

import java.util.GregorianCalendar;

/**
 * Instances of the Calendar class contain CalendarEntries.
 *
 * @author Please change this!
 * @version 1.0
 */
public class Calendar {

  /**
   * Construct a new calendar object.
   */
  public Calendar() {
	  // TODO Implement me!
  }

  /**
   * Add a CalendarEntry to this calendar instance.
   *
   * @param calEntry The entry to add.
   */
  public void addCalendarEntry(CalendarEntry calEntry) {
	  // TODO Implement me!
  }

  /**
   * Return a textual representation of all CalendarEntries 
   * visible for the given user.
   *
   * @param user The user object for whom to display the CalendarEntries.
   * @return A String representing all the CalendarEntries.
   */
  public String listEntries(User user) {
	  // TODO Implement me!
  }

  /**
   * Create a new calendar, three users and add some appointments to the
   * calendar.
   *
   * @param args command-line arguments (ignored in this application)
   */
  public static void main(String[] args) {
    Calendar cal = new Calendar();

    User paul = new User("Paul", "Anderson");
    User mary = new User("Mary", "Bobkins");
    User bob = new User("Adam", "Johanson");
    
    CalendarEntry plants = new CalendarEntry(
			       new GregorianCalendar(2010, 3, 12, 14, 30), 
			       "Water the plants", paul);
    plants.setPrivate(true);
    cal.addCalendarEntry(plants);
    
    CalendarEntry cinema = new CalendarEntry(
			       new GregorianCalendar(2010, 3, 12, 18, 30), 
			       "Meet Mary for cinema", paul);
    cal.addCalendarEntry(cinema);
    
    CalendarEntry call = new CalendarEntry(
                             new GregorianCalendar(2010, 3, 13, 9, 30), 
			     "Call Susi for an appointment with Ron", mary);
    cal.addCalendarEntry(call);
    
    CalendarEntry lunch = new CalendarEntry(
			      new GregorianCalendar(2010, 3, 13, 12, 00), 
			      "Lunch with Paul", bob);
    lunch.setPrivate(true);
    cal.addCalendarEntry(lunch);
    
    System.out.println(cal.listEntries(bob));
  }
}
