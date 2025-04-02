package by.mikhalachkin.airport.dao;

import by.mikhalachkin.airport.model.Personal;

import java.util.List;

public interface PersonalDao {
  void save(Personal personal);
  List<Personal> findAll();
  Personal findById(Long id);
  void update(Personal personal);
  void delete(Long id);
}