package by.mikhalachkin.airport.dao;

import by.mikhalachkin.airport.model.Location;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LocationDaoImpl implements LocationDao {

  private final DataSource dataSource;

  public LocationDaoImpl(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public void save(Location location) {
    String sql = "INSERT INTO location (city, country) VALUES (?, ?)";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, location.getCity());
      stmt.setString(2, location.getCountry());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  @Override
  public List<Location> findAll() {
    List<Location> list = new ArrayList<>();
    String sql = "SELECT * FROM location";
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
  public Location findById(Long id) {
    String sql = "SELECT * FROM location WHERE id = ?";
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
  public void update(Location location) {
    String sql = "UPDATE location SET city = ?, country = ? WHERE id = ?";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, location.getCity());
      stmt.setString(2, location.getCountry());
      stmt.setLong(3, location.getId());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(Long id) {
    String sql = "DELETE FROM location WHERE id = ?";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setLong(1, id);
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Location mapRow(ResultSet rs) throws SQLException {
    Location location = new Location();
    location.setId(rs.getLong("id"));
    location.setCity(rs.getString("city"));
    location.setCountry(rs.getString("country"));
    return location;
  }
}

