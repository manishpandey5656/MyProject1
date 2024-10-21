package model;

public class Bus {
	
    private int id;
    private String name;
    private String route;
    private String type;
    private int seats;
    private String departureTime;
    private String arrivalTime;
    
    //getters and setters
	public int getId() {
		return id;
	}
	  // Getters and Setters
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	// constructors
	public Bus(int id, String name, String route, String type, int seats, String departureTime, String arrivalTime) {
		super();
		this.id = id;
		this.name = name;
		this.route = route;
		this.type = type;
		this.seats = seats;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}
	public Bus() {
		
	}
	public Bus( String name, String route, String type, int seats, String departureTime, String arrivalTime) {
		super();
		 
		this.name = name;
		this.route = route;
		this.type = type;
		this.seats = seats;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}
	@Override
	public String toString() {
		return "Bus [id=" + id + ", name=" + name + ", route=" + route + ", type=" + type + ", seats=" + seats
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + "]";
	}

	
  
    
}
