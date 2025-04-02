package by.mikhalachkin.airport.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Route {
  private Long id;
  private Long airplaneId;
  private LocalDateTime arrivalTime;
  private LocalDateTime departureTime;
  private Long arrivalLocationId;
  private Long departureLocationId;
}