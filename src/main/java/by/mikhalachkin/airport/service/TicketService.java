package by.mikhalachkin.airport.service;

import by.mikhalachkin.airport.model.Ticket;
import java.util.List;

public interface TicketService {
  void save(Ticket ticket);
  List<Ticket> getAll();
  Ticket getById(Long id);
  void update(Ticket ticket);
  void delete(Long id);
}
