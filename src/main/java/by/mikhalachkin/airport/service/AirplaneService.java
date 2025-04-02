package by.mikhalachkin.airport.service;

import by.mikhalachkin.airport.model.Airplane;

import java.util.List;

public interface AirplaneService {
  void save(Airplane airplane);
  List<Airplane> getAll();
  Airplane getById(Long id);
  void update(Airplane airplane);
  void delete(Long id);
}
