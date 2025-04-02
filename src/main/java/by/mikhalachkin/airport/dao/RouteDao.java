package by.mikhalachkin.airport.dao;

import by.mikhalachkin.airport.model.Route;
import java.util.List;

public interface RouteDao {
  void save(Route route);
  List<Route> findAll();
  Route findById(Long id);
  void update(Route route);
  void delete(Long id);
}