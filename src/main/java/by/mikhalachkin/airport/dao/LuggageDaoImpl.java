package by.mikhalachkin.airport.dao;

import by.mikhalachkin.airport.dao.LuggageDao;
import by.mikhalachkin.airport.model.Luggage;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LuggageDaoImpl implements LuggageDao {

  private final DataSource dataSource;

  public LuggageDaoImpl(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public void save(Luggage luggage) {
    String sql = "INSERT INTO luggage (weight) VALUES (?)";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setDouble(1, luggage.getWeight());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  @Override
  public List<Luggage> findAll() {
    List<Luggage> list = new ArrayList<>();
    String sql = "SELECT * FROM luggage";
    try (Connection conn = dataSource.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
      while (rs.next()) {
        Luggage luggage = new Luggage();
        luggage.setId(rs.getLong("id"));
        luggage.setWeight(rs.getDouble("weight"));
        list.add(luggage);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return list;
  }

  @Override
  public Luggage findById(Long id) {
    String sql = "SELECT * FROM luggage WHERE id = ?";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setLong(1, id);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        Luggage luggage = new Luggage();
        luggage.setId(rs.getLong("id"));
        luggage.setWeight(rs.getDouble("weight"));
        return luggage;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public void update(Luggage luggage) {
    String sql = "UPDATE luggage SET weight = ? WHERE id = ?";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setDouble(1, luggage.getWeight());
      stmt.setLong(2, luggage.getId());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(Long id) {
    String sql = "DELETE FROM luggage WHERE id = ?";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setLong(1, id);
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}