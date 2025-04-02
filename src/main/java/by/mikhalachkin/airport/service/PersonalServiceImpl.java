package by.mikhalachkin.airport.service;

import by.mikhalachkin.airport.dao.PersonalDao;
import by.mikhalachkin.airport.model.Personal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalServiceImpl implements PersonalService {

  private final PersonalDao personalDao;

  public PersonalServiceImpl(PersonalDao personalDao) {
    this.personalDao = personalDao;
  }

  @Override
  public void save(Personal personal) {
    personalDao.save(personal);
  }

  @Override
  public List<Personal> getAll() {
    return personalDao.findAll();
  }

  @Override
  public Personal getById(Long id) {
    return personalDao.findById(id);
  }

  @Override
  public void update(Personal personal) {
    personalDao.update(personal);
  }

  @Override
  public void delete(Long id) {
    personalDao.delete(id);
  }
}
