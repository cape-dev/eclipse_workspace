package GDICalendar;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import java.util.GregorianCalendar;

import junit.framework.JUnit4TestAdapter;

import org.junit.Test;

/**
 * Test the various calendar functionality.
 */
public class CalendarTest {

  /**
   * Test for the correct creation of users
   */
  @Test
  public void testUserCreation() {
    User sasha = new User("Sasha", "Dole");
    try {
      assertTrue(sasha.getClass().getMethod("setGivenName", String.class) != null);
      assertTrue(sasha.getClass().getMethod("getGivenName") != null);
      assertTrue(sasha.getClass().getMethod("setFamilyName", String.class) != null);
      assertTrue(sasha.getClass().getMethod("getFamilyName") != null);
    } catch (NoSuchMethodException e) {
      // TODO Auto-generated catch block
      assertTrue(e.getMessage(), false);
    }
    assertEquals(sasha.getGivenName(), "Sasha");
    assertEquals(sasha.getFamilyName(), "Dole");
  }

  /**
   * Test for the correct creation calendar entries
   */
  @Test
  public void testCalendarEntryCreation() {
    CalendarEntry meeting = new CalendarEntry(new GregorianCalendar(2010,
			        3, 12, 18, 30), "Meeting with Alex and Joseph",
					      new User("Sasha", "Dole"));
    try {
      assertTrue(meeting.getClass().getMethod("setDescription", String.class) != null);
      assertTrue(meeting.getClass().getMethod("getDescription") != null);
      assertTrue(meeting.getClass().getMethod("setOwner", User.class) != null);
      assertTrue(meeting.getClass().getMethod("getOwner") != null);
      assertTrue(meeting.getClass().getMethod("setPrivate", boolean.class) != null);
      assertTrue(meeting.getClass().getMethod("isPrivate") != null);
      assertTrue(meeting.getClass().getMethod("setTime", GregorianCalendar.class) != null);
      assertTrue(meeting.getClass().getMethod("getTime") != null);
      assertTrue(meeting.getClass().getMethod("toString") != null);
    } catch (NoSuchMethodException e) {
      // TODO Auto-generated catch block
      assertTrue(e.getMessage(), false);
    }
    assertFalse(meeting.isPrivate());
    assertEquals(meeting.getDescription(), "Meeting with Alex and Joseph");
    assertEquals(meeting.getOwner().getGivenName(), "Sasha");
  }

  /**
   * Test for the correct creation of a calendar
   */
  @Test
  public void testCalendarCreation() {
    Calendar cal = new Calendar();
    User bob = new User("Bob", "Smith");
    CalendarEntry meeting = new CalendarEntry(new GregorianCalendar(2010,
				3, 12, 18, 30), "Meeting with Alex and Joseph",
					      new User("Sasha", "Dole"));
    try {
      assertTrue(cal.getClass().getMethod("addCalendarEntry", CalendarEntry.class) != null);
      assertTrue(cal.getClass().getMethod("listEntries", User.class) != null);
    } catch (NoSuchMethodException e) {
      // TODO Auto-generated catch block
      assertTrue(e.getMessage(), false);
    }
    cal.addCalendarEntry(meeting);
    assertTrue(cal.listEntries(bob).length() > 0);
    assertTrue(cal.listEntries(bob).contains("Sasha"));
    assertTrue(cal.listEntries(bob).contains("Meeting with Alex and Joseph"));
    assertTrue(cal.listEntries(bob).contains("2010"));
    assertTrue(cal.listEntries(bob).contains("April"));
    assertFalse(cal.listEntries(bob).contains("Mon"));
  }

  /**
   * create a test suite to support command-line testing
   *
   * @return a test suite used for running these tests
   */
  public static junit.framework.Test suite() {
    return new JUnit4TestAdapter(CalendarTest.class);
  }

  /**
   * Main method of this test, used for command-line based testing
   *
   * @param args command-line arguments, ignored here.
   */
  public static void main(String[] args) {
    junit.textui.TestRunner.runAndWait(suite());
  }
}
