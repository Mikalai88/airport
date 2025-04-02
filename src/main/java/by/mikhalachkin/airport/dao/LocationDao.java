package by.mikhalachkin.airport.dao;
import by.mikhalachkin.airport.model.Location;

import java.util.List;

public interface LocationDao {
  void save(Location location);
  List<Location> findAll();
  Location findById(Long id);
  void update(Location location);
  void delete(Long id);
}