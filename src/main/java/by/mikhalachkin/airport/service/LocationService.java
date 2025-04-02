package by.mikhalachkin.airport.service;

import by.mikhalachkin.airport.model.Location;
import java.util.List;

public interface LocationService {
  void save(Location location);
  List<Location> getAll();
  Location getById(Long id);
  void update(Location location);
  void delete(Long id);
}