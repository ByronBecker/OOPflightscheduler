import com.flight_scheduler.*;
import java.time.*;
/**
 * @author raghavsharma
 *
 */
public class Controller {
	public boolean login(String userName, String password) {
		return false;
	}
	public void logout() {

	}
	public boolean openGateExists(LocalDateTime early_time, LocalDateTime late_time) {
		return false;
	}
	public Flight requestFlight(FlightInfo requested_flight) {
		return new Flight();
	}
	public boolean checkPriority(FlightInfo requested_flight) {
		return false;
	}
	public Flight emptyFlight() {
		return new Flight();
	}
	public void receiveTimeWindow(LocalDateTime early_time, LocalDateTime late_time ) {

	}
	public void receiveFlight(int flight_number) {

	}
	public void receiveAirline(String airline) {

	}
}
