package Service;

import java.sql.SQLException;

import model.Customer;

public interface CustomerService {

	 public int addCustomer(Customer customer)throws SQLException ;

	Customer getCustomerById(int customerId) throws SQLException;
}
