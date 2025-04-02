package by.mikhalachkin.airport.model;

import lombok.Data;

@Data
public class Airplane {
  private Long id;
  private String model;
  private Integer capacity;
}