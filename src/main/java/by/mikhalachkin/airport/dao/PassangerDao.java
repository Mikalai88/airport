package by.mikhalachkin.airport.dao;

import by.mikhalachkin.airport.model.Passanger;

import java.util.List;

public interface PassangerDao {
  Passanger getById(Long id);
  List<Passanger> getAll();
  void save(Passanger passanger);
  void update(Passanger passanger);
  void delete(Long id);
}
