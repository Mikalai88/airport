package by.mikhalachkin.airport.dao;

import by.mikhalachkin.airport.model.Airplane;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AirplaneDaoImpl implements AirplaneDao {

  private final DataSource dataSource;

  public AirplaneDaoImpl(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public void save(Airplane airplane) {
    String sql = "INSERT INTO airplane (model, capacity) VALUES (?, ?)";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, airplane.getModel());
      stmt.setInt(2, airplane.getCapacity());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Airplane> findAll() {
    List<Airplane> list = new ArrayList<>();
    String sql = "SELECT * FROM airplane";
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
  public Airplane findById(Long id) {
    String sql = "SELECT * FROM airplane WHERE id = ?";
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
  public void update(Airplane airplane) {
    String sql = "UPDATE airplane SET model = ?, capacity = ? WHERE id = ?";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, airplane.getModel());
      stmt.setInt(2, airplane.getCapacity());
      stmt.setLong(3, airplane.getId());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(Long id) {
    String sql = "DELETE FROM airplane WHERE id = ?";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setLong(1, id);
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Airplane mapRow(ResultSet rs) throws SQLException {
    Airplane airplane = new Airplane();
    airplane.setId(rs.getLong("id"));
    airplane.setModel(rs.getString("model"));
    airplane.setCapacity(rs.getInt("capacity"));
    return airplane;
  }
}
