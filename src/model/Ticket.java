 package model;

public class Ticket {
    private int id;
    private int busId;
    private int customerId;
    private String status;
    private int seatNumber;
    private int ticketId;
    
    
    // getter and settters
    
	public int getTicketId() {
		return ticketId;
	}


	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}


	public int getId() {
		return id;
	}
	 
    
	public void setId(int id) {
		this.id = id;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	//constructor
	public Ticket(int id, int busId, int customerId, String status) {
		super();
		this.id = id;
		this.busId = busId;
		this.customerId = customerId;
		this.status = status;
	}

	public Ticket() {
		// TODO Auto-generated constructor stub
	}

	 
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", busId=" + busId + ", customerId=" + customerId + ", status=" + status + "]";
	}

	public int getSeatNumber() {
		// TODO Auto-generated method stub
		return seatNumber;
	}


	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

  
    
}
