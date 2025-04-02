package by.mikhalachkin.airport.controller;

import by.mikhalachkin.airport.model.Ticket;
import by.mikhalachkin.airport.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

  private final TicketService ticketService;

  public TicketController(TicketService ticketService) {
    this.ticketService = ticketService;
  }

  @PostMapping
  public void save(@RequestBody Ticket ticket) {
    ticketService.save(ticket);
  }

  @GetMapping
  public List<Ticket> getAll() {
    return ticketService.getAll();
  }

  @GetMapping("/{id}")
  public Ticket getById(@PathVariable Long id) {
    return ticketService.getById(id);
  }

  @PutMapping("/{id}")
  public void update(@PathVariable Long id, @RequestBody Ticket ticket) {
    ticket.setId(id);
    ticketService.update(ticket);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    ticketService.delete(id);
  }
}