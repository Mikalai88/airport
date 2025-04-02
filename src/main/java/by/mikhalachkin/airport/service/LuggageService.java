package by.mikhalachkin.airport.service;

import by.mikhalachkin.airport.model.Luggage;
import java.util.List;

public interface LuggageService {
  void save(Luggage luggage);
  List<Luggage> getAll();
  Luggage getById(Long id);
  void update(Luggage luggage);
  void delete(Long id);
}