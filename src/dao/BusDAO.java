 package dao;

import java.sql.SQLException;
import java.util.List;

import model.Bus;

public interface BusDAO {

	
	
	public boolean addBuses(Bus bus) throws SQLException;
	
	public List<Bus> getAllBuses() throws SQLException;
	
	public boolean updateSeats(int busId, int seats) throws SQLException;
}
