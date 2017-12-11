import java.time.*;
import com.flight_scheduler.Flight;
public interface FlightChangeIterator {

	public boolean cancelFlightsByNumber(int flight_number);

	public boolean cancelFlightsByTimeWindow(LocalDateTime early_time, LocalDateTime late_time, String airline);

	public Flight addFlight(Flight flight);
}
