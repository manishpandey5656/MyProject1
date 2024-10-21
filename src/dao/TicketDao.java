package dao;

import java.sql.SQLException;
import java.util.List;

import model.Ticket;

public interface TicketDao {

	public boolean bookTicket(Ticket ticket)throws SQLException;
	
	public boolean cancelTicket(int ticket_Id) throws SQLException;
	public Ticket getTicketById(int ticketId) throws SQLException ;
	 
}
