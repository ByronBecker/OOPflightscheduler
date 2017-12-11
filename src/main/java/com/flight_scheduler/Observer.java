import java.util.*;

public interface Observer {
	 public ArrayList<Integer> checkRecentUpdates();

	 public void updateNotifications(String airline, int flightNumber, boolean approved);
}
