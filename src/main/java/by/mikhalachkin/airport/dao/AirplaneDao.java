package by.mikhalachkin.airport.dao;

import by.mikhalachkin.airport.model.Airplane;

import java.util.List;

public interface AirplaneDao {
  void save(Airplane airplane);
  List<Airplane> findAll();
  Airplane findById(Long id);
  void update(Airplane airplane);
  void delete(Long id);
}
