package by.mikhalachkin.airport.dao;

import by.mikhalachkin.airport.dao.RouteDao;
import by.mikhalachkin.airport.model.Route;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RouteDaoImpl implements RouteDao {

  private final DataSource dataSource;

  public RouteDaoImpl(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public void save(Route route) {
    String sql = "INSERT INTO route (airplaneid, arrivaltime, departuretime, arrivallocationid, departurelocationid) VALUES (?, ?, ?, ?, ?)";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setLong(1, route.getAirplaneId());
      stmt.setTimestamp(2, Timestamp.valueOf(route.getArrivalTime()));
      stmt.setTimestamp(3, Timestamp.valueOf(route.getDepartureTime()));
      stmt.setLong(4, route.getArrivalLocationId());
      stmt.setLong(5, route.getDepartureLocationId());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Route> findAll() {
    List<Route> list = new ArrayList<>();
    String sql = "SELECT * FROM route";
    try (Connection conn = dataSource.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
      while (rs.next()) {
        list.add(mapRow(rs));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return list;
  }

  @Override
  public Route findById(Long id) {
    String sql = "SELECT * FROM route WHERE id = ?";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setLong(1, id);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        return mapRow(rs);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public void update(Route route) {
    String sql = "UPDATE route SET airplaneid = ?, arrivaltime = ?, departuretime = ?, arrivallocationid = ?, departurelocationid = ? WHERE id = ?";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setLong(1, route.getAirplaneId());
      stmt.setTimestamp(2, Timestamp.valueOf(route.getArrivalTime()));
      stmt.setTimestamp(3, Timestamp.valueOf(route.getDepartureTime()));
      stmt.setLong(4, route.getArrivalLocationId());
      stmt.setLong(5, route.getDepartureLocationId());
      stmt.setLong(6, route.getId());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(Long id) {
    String sql = "DELETE FROM route WHERE id = ?";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setLong(1, id);
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Route mapRow(ResultSet rs) throws SQLException {
    Route route = new Route();
    route.setId(rs.getLong("id"));
    route.setAirplaneId(rs.getLong("airplaneid"));
    route.setArrivalTime(rs.getTimestamp("arrivaltime").toLocalDateTime());
    route.setDepartureTime(rs.getTimestamp("departuretime").toLocalDateTime());
    route.setArrivalLocationId(rs.getLong("arrivallocationid"));
    route.setDepartureLocationId(rs.getLong("departurelocationid"));
    return route;
  }
}