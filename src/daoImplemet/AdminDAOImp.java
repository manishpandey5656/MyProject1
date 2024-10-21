 
package daoImplemet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.AdminDao;
import model.Admin;
import utility.DBConnection;

public class AdminDAOImp implements AdminDao {
	
@Override
    public boolean addAdmin(Admin admin) throws SQLException {
        String query = "INSERT INTO admin (username, password) VALUES (?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, admin.getUsername());
            statement.setString(2, admin.getPassword());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        admin.setId(generatedKeys.getInt(1));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean validateAdmin(Admin admin) throws SQLException {
        String query = "SELECT * FROM admin WHERE username = ? AND password = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, admin.getUsername());
            statement.setString(2, admin.getPassword());
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();
        }
    }

	 
}
