 

package main;

import dao.*;
import ServiceImp.*;
import daoImplemet.*;
import model.*;
import java.sql.SQLException;     
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        
        // Service implementations for interacting with the database
        BusServiceImp busService = new BusServiceImp();
        TIcketServiceImp ticketService = new TIcketServiceImp();
        CustomerDaoImp customerDao = new CustomerDaoImp();
        AdminServiceImp adminService = new AdminServiceImp();
        
        System.out.println("Welcome to Bus Ticket Reservation System");
        System.out.println("1. Press 1 (if you are a customer)");
        System.out.println("2. Press 2 (if you are an admin)");

        int userType = scanner.nextInt();

        switch (userType) {
            case 1:
                handleCustomerOperations(scanner, ticketService, customerDao, busService);
                break;
                
            case 2:
                handleAdminOperations(scanner, adminService, busService);
                break;
                
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
        
        scanner.close();
    }

    // Method to handle customer operations
    private static void handleCustomerOperations(Scanner scanner, TIcketServiceImp ticketService, CustomerDaoImp customerDao, BusServiceImp busService) {
        System.out.println("1. Press 1 (if you want to book a ticket)");
        System.out.println("2. Press 2 (if you want to cancel a ticket)");
        
        int customerChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (customerChoice) {
            case 1:
                // Booking a ticket
                System.out.println("Enter Customer Name: ");
                String name = scanner.nextLine();
                System.out.println("Enter Customer Contact: ");
                String contact = scanner.nextLine();

                Customer customer = new Customer();
                customer.setName(name);
                customer.setContact(contact);

                try {
                    int customerId = customerDao.addCustomer(customer);
                    System.out.println("Customer registered with ID: " + customerId);
                    
                    // Display available buses
                    System.out.println("Available Buses:");
                    for (Bus bus : busService.getAllBuses()) {
                        System.out.println(bus.getId() + " - " + bus.getName() + " - Seats: " + bus.getSeats());
                    }

                    System.out.println("Enter Bus ID to book: ");
                    int busId = scanner.nextInt();

                    System.out.println("Enter Seat Number to book: ");
                    int seatNumber = scanner.nextInt();

                    Ticket ticket = new Ticket();
                    ticket.setBusId(busId);
                    ticket.setCustomerId(customerId);
                    ticket.setSeatNumber(seatNumber);

                    if (ticketService.bookTicket(ticket)) {
                        System.out.println("Ticket booked successfully! Ticket ID: " + ticket.getId());
                    } else {
                        System.out.println("Booking failed. Please try again.");
                    }

                } catch (SQLException e) {
                    System.err.println("Error while booking ticket: " + e.getMessage());
                }
                break;

            case 2:
                // Canceling a ticket
                System.out.println("Enter Ticket ID to cancel: ");
                int ticketId = scanner.nextInt();
                try {
                    if (ticketService.cancelTicket(ticketId)) {
                        System.out.println("Ticket canceled successfully!");
                    } else {
                        System.out.println("Cancellation failed. Please check the ticket ID.");
                    }
                } catch (SQLException e) {
                    System.err.println("Error while canceling ticket: " + e.getMessage());
                }
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    // Method to handle admin operations
    private static void handleAdminOperations(Scanner scanner, AdminServiceImp adminService, BusServiceImp busService) throws SQLException {
        System.out.println("1. Press 1 to register as admin");
        System.out.println("2. Press 2 to login as admin");

        int adminChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (adminChoice) {
            case 1:
                // Registering an admin
                System.out.println("Register yourself as admin:");
                System.out.println("Enter username:");
                String newUsername = scanner.nextLine();
                System.out.println("Enter password:");
                String newPassword = scanner.nextLine();

                if (adminService.addAdmin( new Admin(newUsername, newPassword))) {
                    System.out.println("Admin registered successfully!");
                } else {
                    System.out.println("Admin registration failed.");
                }
                break;

            case 2:
                // Login as admin
                System.out.println("Login as admin:");
                System.out.println("Enter username:");
                String username = scanner.nextLine();
                System.out.println("Enter password:");
                String password = scanner.nextLine();

                Admin admin = new Admin(username, password);
                if (adminService.validateAdmin(admin)) {
                    System.out.println("Login successful!");
                    
                    System.out.println("1. Press 1 to add buses");
                    System.out.println("2. Press 2 to list all the buses");

                    int busChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (busChoice) {
                        case 1:
                            // Adding a new bus
                            System.out.println("Enter Bus Name:");
                            String busName = scanner.nextLine();
                            System.out.println("Enter Route:");
                            String route = scanner.nextLine();
                            System.out.println("Enter Total Seats:");
                            int seats = scanner.nextInt();
                            System.out.println("Enter Departure Time (HH:MM:SS):");
                            String departureTime = scanner.next();
                            System.out.println("Enter Arrival Time (HH:MM:SS):");
                            String arrivalTime = scanner.next();

                            Bus bus = new Bus();
                            bus.setName(busName);
                            bus.setRoute(route);
                            bus.setSeats(seats);
                            bus.setDepartureTime(departureTime);
                            bus.setArrivalTime(arrivalTime);

                            try {
                                busService.addBuses(bus);
                                System.out.println("Bus added successfully!");
                            } catch (SQLException e) {
                                System.err.println("Error while adding bus: " + e.getMessage());
                            }
                            break;

                        case 2:
                            // Listing all buses
                            System.out.println("Available Buses:");
                            for (Bus busObj : busService.getAllBuses()) {
                                System.out.println(busObj.getId() + " - " + busObj.getName() + " - Route: " + busObj.getRoute() + " - Seats: " + busObj.getSeats());
                            }
                            break;

                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                } else {
                    System.out.println("Invalid username or password. Login failed.");
                }
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
}
