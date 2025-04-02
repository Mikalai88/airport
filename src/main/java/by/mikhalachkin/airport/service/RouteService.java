package by.mikhalachkin.airport.service;

import by.mikhalachkin.airport.model.Route;
import java.util.List;

public interface RouteService {
  void save(Route route);
  List<Route> getAll();
  Route getById(Long id);
  void update(Route route);
  void delete(Long id);
}