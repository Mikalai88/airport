package by.mikhalachkin.airport.service;

import by.mikhalachkin.airport.dao.TicketDao;
import by.mikhalachkin.airport.model.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

  private final TicketDao ticketDao;

  public TicketServiceImpl(TicketDao ticketDao) {
    this.ticketDao = ticketDao;
  }

  @Override
  public void save(Ticket ticket) {
    ticketDao.save(ticket);
  }

  @Override
  public List<Ticket> getAll() {
    return ticketDao.findAll();
  }

  @Override
  public Ticket getById(Long id) {
    return ticketDao.findById(id);
  }

  @Override
  public void update(Ticket ticket) {
    ticketDao.update(ticket);
  }

  @Override
  public void delete(Long id) {
    ticketDao.delete(id);
  }
}