package ServiceImp;

import java.sql.SQLException;
import java.util.List;

import Service.BusService;
import daoImplemet.BusDAOImp;
import model.Bus;

public class BusServiceImp implements BusService{

	

	@Override
	public boolean addBuses(Bus bus)throws SQLException {
		 
		return  new BusDAOImp().addBuses(bus) ;
	}
	@Override
	public List<Bus> getAllBuses() throws SQLException{
		 
		return new BusDAOImp().getAllBuses();
	}

	@Override
	public boolean updateSeats(int busId, int newSeatCount) throws SQLException  {
		// TODO Auto-generated method stub
		return new BusDAOImp().updateSeats(busId, newSeatCount);
	}

}
