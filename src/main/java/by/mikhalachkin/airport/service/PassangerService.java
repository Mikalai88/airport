package by.mikhalachkin.airport.service;

import by.mikhalachkin.airport.model.Passanger;

import java.util.List;

public interface PassangerService {
  Passanger getById(Long id);
  List<Passanger> getAll();
  void save(Passanger passanger);
  void update(Passanger passanger);
  void delete(Long id);
}