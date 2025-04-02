package by.mikhalachkin.airport.service;

import by.mikhalachkin.airport.dao.PassangerDao;
import by.mikhalachkin.airport.model.Passanger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassangerServiceImpl implements PassangerService {

  private final PassangerDao passangerDao;

  public PassangerServiceImpl(PassangerDao passangerDao) {
    this.passangerDao = passangerDao;
  }

  @Override
  public Passanger getById(Long id) {
    return passangerDao.getById(id);
  }

  @Override
  public List<Passanger> getAll() {
    return passangerDao.getAll();
  }

  @Override
  public void save(Passanger passanger) {
    passangerDao.save(passanger);
  }

  @Override
  public void update(Passanger passanger) {
    passangerDao.update(passanger);
  }

  @Override
  public void delete(Long id) {
    passangerDao.delete(id);
  }
}
