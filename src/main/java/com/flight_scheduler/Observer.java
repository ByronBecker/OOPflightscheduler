
/**
 * @author raghavsharma
 *
 */
public interface Observer {
	 public Arraylist<int> checkRecentUpdates();
	 
	 public void updateNotifications(String airline, int flightNumber, boolean approved);
}
