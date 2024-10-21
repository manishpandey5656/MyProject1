package ServiceImp;

import java.sql.SQLException;
 

import Service.TicketService;
import daoImplemet.TicketDAOImp;
import model.Ticket;

public class TIcketServiceImp implements TicketService {

	@Override
	public boolean bookTicket(Ticket ticket) throws SQLException {
		// TODO Auto-generated method stub
		return new TicketDAOImp().bookTicket(ticket);
	}

	@Override
	public boolean cancelTicket(int ticket_Id) throws SQLException {
		// TODO Auto-generated method stub
		return new TicketDAOImp().cancelTicket(ticket_Id);
	}
@Override
	public Ticket getTicketById(int ticketId) throws SQLException {
		return new TicketDAOImp().getTicketById(ticketId);
		
	
}
}
