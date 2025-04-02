package by.mikhalachkin.airport.service;

import by.mikhalachkin.airport.dao.LuggageDao;
import by.mikhalachkin.airport.model.Luggage;
import by.mikhalachkin.airport.service.LuggageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LuggageServiceImpl implements LuggageService {

  private final LuggageDao luggageDao;

  public LuggageServiceImpl(LuggageDao luggageDao) {
    this.luggageDao = luggageDao;
  }

  @Override
  public void save(Luggage luggage) {
    luggageDao.save(luggage);
  }

  @Override
  public List<Luggage> getAll() {
    return luggageDao.findAll();
  }

  @Override
  public Luggage getById(Long id) {
    return luggageDao.findById(id);
  }

  @Override
  public void update(Luggage luggage) {
    luggageDao.update(luggage);
  }


  @Override
  public void delete(Long id) {
    luggageDao.delete(id);
  }
}