package by.mikhalachkin.airport.dao;

import by.mikhalachkin.airport.model.Passanger;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PassangerDaoImpl implements PassangerDao {
  private final DataSource dataSource;

  public PassangerDaoImpl(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public Passanger getById(Long id) {
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM passanger WHERE id = ?")) {
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

  public List<Passanger> getAll() {
    List<Passanger> list = new ArrayList<>();
    try (Connection conn = dataSource.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM passanger")) {
      while (rs.next()) {
        list.add(mapRow(rs));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return list;
  }

  public void save(Passanger passanger) {
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO passanger (passport, name, email) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
      stmt.setString(1, passanger.getPassport());
      stmt.setString(2, passanger.getName());
      stmt.setString(3, passanger.getEmail());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void update(Passanger passanger) {
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement("UPDATE passanger SET passport=?, name=?, email=? WHERE id=?")) {
      stmt.setString(1, passanger.getPassport());
      stmt.setString(2, passanger.getName());
      stmt.setString(3, passanger.getEmail());
      stmt.setLong(4, passanger.getId());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void delete(Long id) {
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement("DELETE FROM passanger WHERE id=?")) {
      stmt.setLong(1, id);
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Passanger mapRow(ResultSet rs) throws SQLException {
    Passanger p = new Passanger();
    p.setId(rs.getLong("id"));
    p.setPassport(rs.getString("passport"));
    p.setName(rs.getString("name"));
    p.setEmail(rs.getString("email"));
    return p;
  }
}
