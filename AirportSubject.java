import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observer;

public class AirportSubject {
	private Arraylist<int> gatesInfo = new Arraylist<int>();
	private HashMap<int, Arraylist<Observer>> subscriberList = new HashMap<int, Arraylist<Observer>>();
	
	public void notifyObservers(int flightNumber, boolean approved) {
		Arraylist observer = subscriberList.get(flightNumber);
		for (Observer o: observer)
			o.updateNotification(flightNumber, approved);
	}
	
	public void subscribe(Observer observer, int flightNumber) {
		ArrayList<Observer> observerList = new Arraylist<Observer>();
		if(subscriberList.containKey(flightNumber)) {
			observerList = subscriberList.get(flightNumber);
		}
			
		observerList.add(observer);
		subscriberList.put(flightNumber, observerList);
	}
}
