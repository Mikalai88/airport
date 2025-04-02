package by.mikhalachkin.airport.service;

import by.mikhalachkin.airport.dao.RouteDao;
import by.mikhalachkin.airport.model.Route;
import by.mikhalachkin.airport.service.RouteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

  private final RouteDao routeDao;

  public RouteServiceImpl(RouteDao routeDao) {
    this.routeDao = routeDao;
  }

  @Override
  public void save(Route route) {
    routeDao.save(route);
  }

  @Override
  public List<Route> getAll() {
    return routeDao.findAll();
  }

  @Override
  public Route getById(Long id) {
    return routeDao.findById(id);
  }

  @Override
  public void update(Route route) {
    routeDao.update(route);
  }

  @Override
  public void delete(Long id) {
    routeDao.delete(id);
  }
}
