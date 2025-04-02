package by.mikhalachkin.airport.service;

import by.mikhalachkin.airport.dao.LocationDao;
import by.mikhalachkin.airport.model.Location;
import by.mikhalachkin.airport.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

  private final LocationDao locationDao;

  public LocationServiceImpl(LocationDao locationDao) {
    this.locationDao = locationDao;
  }

  @Override
  public void save(Location location) {
    locationDao.save(location);
  }

  @Override
  public List<Location> getAll() {
    return locationDao.findAll();
  }

  @Override
  public Location getById(Long id) {
    return locationDao.findById(id);
  }

  @Override
  public void update(Location location) {
    locationDao.update(location);
  }

  @Override
  public void delete(Long id) {
    locationDao.delete(id);
  }
}