 


package daoImplemet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BusDAO;
import model.Bus;
import utility.DBConnection;

public class BusDAOImp implements BusDAO {

    @Override
    public boolean addBuses(Bus bus) throws SQLException {
        String sql = "INSERT INTO bus (name, route, seats, departure_time, arrival_time) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setString(1, bus.getName());
            statement.setString(2, bus.getRoute());
            statement.setInt(3, bus.getSeats());
            statement.setString(4, bus.getDepartureTime());
            statement.setString(5, bus.getArrivalTime());

            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public List<Bus> getAllBuses() throws SQLException {
        String sql = "SELECT * FROM bus";
        List<Bus> busList = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Bus bus = new Bus();
                bus.setId(resultSet.getInt("id"));
                bus.setName(resultSet.getString("name"));
                bus.setRoute(resultSet.getString("route"));
                bus.setSeats(resultSet.getInt("seats"));
                bus.setDepartureTime(resultSet.getString("departure_time"));
                bus.setArrivalTime(resultSet.getString("arrival_time"));
                busList.add(bus);
            }
        }
        return busList;
    }

    @Override
    public boolean updateSeats(int busId, int newSeatCount) throws SQLException {
        String sql = "UPDATE bus SET seats = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, newSeatCount);
            statement.setInt(2, busId);

            return statement.executeUpdate() > 0;
        }
    }
}
