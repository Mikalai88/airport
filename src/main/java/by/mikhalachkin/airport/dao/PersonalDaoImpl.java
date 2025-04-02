package by.mikhalachkin.airport.dao;

import by.mikhalachkin.airport.dao.PersonalDao;
import by.mikhalachkin.airport.model.Personal;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonalDaoImpl implements PersonalDao {

  private final DataSource dataSource;

  public PersonalDaoImpl(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public void save(Personal personal) {
    String sql = "INSERT INTO personal (type, name, date_of_birth) VALUES (?, ?, ?)";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, personal.getType());
      stmt.setString(2, personal.getName());
      stmt.setDate(3, Date.valueOf(personal.getDateOfBirth()));
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Personal> findAll() {
    List<Personal> list = new ArrayList<>();
    String sql = "SELECT * FROM personal";
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
  public Personal findById(Long id) {
    String sql = "SELECT * FROM personal WHERE id = ?";
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
  public void update(Personal personal) {
    String sql = "UPDATE personal SET type = ?, name = ?, date_of_birth = ? WHERE id = ?";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, personal.getType());
      stmt.setString(2, personal.getName());
      stmt.setDate(3, Date.valueOf(personal.getDateOfBirth()));
      stmt.setLong(4, personal.getId());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(Long id) {
    String sql = "DELETE FROM personal WHERE id = ?";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setLong(1, id);
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Personal mapRow(ResultSet rs) throws SQLException {
    Personal personal = new Personal();
    personal.setId(rs.getLong("id"));
    personal.setType(rs.getString("type"));
    personal.setName(rs.getString("name"));
    personal.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());
    return personal;
  }
}
