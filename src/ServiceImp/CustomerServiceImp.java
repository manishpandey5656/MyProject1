package ServiceImp;

import java.sql.SQLException;

import Service.CustomerService;
import daoImplemet.CustomerDaoImp;
import model.Customer;

public class CustomerServiceImp implements CustomerService{

	@Override
	public int addCustomer(Customer customer) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
@Override
	public Customer getCustomerById(int customerId) throws SQLException {
	return new CustomerDaoImp().getCustomerById(customerId);
}
}
