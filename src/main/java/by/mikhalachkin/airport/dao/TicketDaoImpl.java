package by.mikhalachkin.airport.dao;

import by.mikhalachkin.airport.model.Ticket;
import by.mikhalachkin.airport.model.TicketClass;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketDaoImpl implements TicketDao {

  private final DataSource dataSource;

  public TicketDaoImpl(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public void save(Ticket ticket) {
    String sql = "INSERT INTO ticket (routeId, passangerId, passport, personalId, class, luggageId) VALUES (?, ?, ?, ?, ?::ticket_class, ?)";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setLong(1, ticket.getRouteId());
      stmt.setLong(2, ticket.getPassangerId());
      stmt.setString(3, ticket.getPassport());
      stmt.setLong(4, ticket.getPersonalId());
      stmt.setString(5, ticket.getTicketClass().name());
      stmt.setLong(6, ticket.getLuggageId());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Ticket> findAll() {
    List<Ticket> list = new ArrayList<>();
    String sql = "SELECT * FROM ticket";
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
  public Ticket findById(Long id) {
    String sql = "SELECT * FROM ticket WHERE id = ?";
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
  public void update(Ticket ticket) {
    String sql = "UPDATE ticket SET routeId = ?, passangerId = ?, passport = ?, personalId = ?, class = ?, luggageId = ? WHERE id = ?";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setLong(1, ticket.getRouteId());
      stmt.setLong(2, ticket.getPassangerId());
      stmt.setString(3, ticket.getPassport());
      stmt.setLong(4, ticket.getPersonalId());
      stmt.setString(5, ticket.getTicketClass().name());
      stmt.setLong(6, ticket.getLuggageId());
      stmt.setLong(7, ticket.getId());
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(Long id) {
    String sql = "DELETE FROM ticket WHERE id = ?";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setLong(1, id);
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Ticket mapRow(ResultSet rs) throws SQLException {
    Ticket ticket = new Ticket();
    ticket.setId(rs.getLong("id"));
    ticket.setRouteId(rs.getLong("routeId"));
    ticket.setPassangerId(rs.getLong("passangerId"));
    ticket.setPassport(rs.getString("passport"));
    ticket.setPersonalId(rs.getLong("personalId"));
    ticket.setTicketClass(TicketClass.valueOf(rs.getString("class")));
    ticket.setLuggageId(rs.getLong("luggageId"));
    return ticket;
  }
}