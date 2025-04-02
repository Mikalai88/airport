package by.mikhalachkin.airport.service;

import by.mikhalachkin.airport.dao.AirplaneDao;
import by.mikhalachkin.airport.model.Airplane;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirplaneServiceImpl implements AirplaneService {

  private final AirplaneDao airplaneDao;

  public AirplaneServiceImpl(AirplaneDao airplaneDao) {
    this.airplaneDao = airplaneDao;
  }

  @Override
  public void save(Airplane airplane) {
    airplaneDao.save(airplane);
  }

  @Override
  public List<Airplane> getAll() {
    return airplaneDao.findAll();
  }

  @Override
  public Airplane getById(Long id) {
    return airplaneDao.findById(id);
  }

  @Override
  public void update(Airplane airplane) {
    airplaneDao.update(airplane);
  }

  @Override
  public void delete(Long id) {
    airplaneDao.delete(id);
  }
}
