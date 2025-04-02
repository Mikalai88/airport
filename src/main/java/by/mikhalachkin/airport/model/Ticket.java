package by.mikhalachkin.airport.model;

import lombok.Data;

@Data
public class Ticket {
  private Long id;
  private Long routeId;
  private Long passangerId;
  private String passport;
  private Long personalId;
  private TicketClass ticketClass;
  private Long luggageId;
}
