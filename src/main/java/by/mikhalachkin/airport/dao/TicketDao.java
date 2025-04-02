package by.mikhalachkin.airport.dao;

import by.mikhalachkin.airport.model.Ticket;

import java.util.List;

public interface TicketDao {
  void save(Ticket ticket);
  List<Ticket> findAll();
  Ticket findById(Long id);
  void update(Ticket ticket);
  void delete(Long id);
}