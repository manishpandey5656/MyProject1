 

package daoImplemet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.CustomerDao;
import model.Customer;
import utility.DBConnection;

public class CustomerDaoImp implements CustomerDao {

    @Override
    public int addCustomer(Customer customer) throws SQLException {
        String sql = "INSERT INTO customer (name, contact) VALUES (?, ?)";
        int generatedId = 0;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, customer.getName());
            statement.setString(2, customer.getContact());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        generatedId = generatedKeys.getInt(1);
                    }
                }
            }
        }
        return generatedId;
    }

    @Override
    public Customer getCustomerById(int customerId) throws SQLException {
        String sql = "SELECT * FROM customer WHERE id = ?";
        Customer customer = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, customerId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setContact(resultSet.getString("contact"));
            }
        }
        return customer;
    }
}
