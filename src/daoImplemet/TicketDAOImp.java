 

package daoImplemet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.TicketDao;
import model.Ticket;
import utility.DBConnection;

public class TicketDAOImp implements TicketDao {

    @Override
    public boolean bookTicket(Ticket ticket) throws SQLException {
        String sql = "INSERT INTO ticket (bus_id, customer_id, seat_number, status) VALUES (?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, ticket.getBusId());
            statement.setInt(2, ticket.getCustomerId());
            statement.setInt(3, ticket.getSeatNumber());
            statement.setString(4, ticket.getStatus());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        ticket.setId(generatedKeys.getInt(1));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean cancelTicket(int ticketId) throws SQLException {
        String sql = "DELETE FROM ticket WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, ticketId);
            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public Ticket getTicketById(int ticketId) throws SQLException {
        String sql = "SELECT * FROM ticket WHERE id = ?";
        Ticket ticket = null;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, ticketId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                ticket = new Ticket();
                ticket.setId(resultSet.getInt("id"));
                ticket.setBusId(resultSet.getInt("bus_id"));
                ticket.setCustomerId(resultSet.getInt("customer_id"));
                ticket.setSeatNumber(resultSet.getInt("seat_number"));
                ticket.setStatus(resultSet.getString("status"));
            }
        }
        return ticket;
    }

}
