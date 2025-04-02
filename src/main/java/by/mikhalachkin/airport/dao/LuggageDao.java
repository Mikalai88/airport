package by.mikhalachkin.airport.dao;

import by.mikhalachkin.airport.model.Luggage;

import java.util.List;

public interface LuggageDao {
  void save(Luggage luggage);
  List<Luggage> findAll();
  Luggage findById(Long id);
  void update(Luggage luggage);
  void delete(Long id);
}