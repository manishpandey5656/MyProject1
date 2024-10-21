package Service;

import java.sql.SQLException;
import java.util.List;

import model.Bus;

 
public interface BusService {

public List<Bus> getAllBuses() throws SQLException;
	
	public boolean addBuses(Bus bus) throws SQLException;
	
	public boolean updateSeats(int busId, int newSeatCount) throws SQLException ;
}
