package by.mikhalachkin.airport.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Personal {
  private Long id;
  private String type;
  private String name;
  private LocalDate dateOfBirth;
}