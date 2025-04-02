package by.mikhalachkin.airport.service;

import by.mikhalachkin.airport.model.Personal;

import java.util.List;

public interface PersonalService {
  void save(Personal personal);
  List<Personal> getAll();
  Personal getById(Long id);
  void update(Personal personal);
  void delete(Long id);
}