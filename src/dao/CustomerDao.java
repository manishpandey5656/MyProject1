package dao;

import java.sql.SQLException;

import model.Customer;

public interface CustomerDao {

	 public int addCustomer(Customer customer)throws SQLException ;
	 public Customer getCustomerById(int customerId) throws SQLException;
}
