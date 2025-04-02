package by.mikhalachkin.airport.model;

import lombok.Data;

@Data
public class Passanger {
  private Long id;
  private String passport;
  private String name;
  private String email;
}