package by.mikhalachkin.airport.controller;

import by.mikhalachkin.airport.model.Airplane;
import by.mikhalachkin.airport.service.AirplaneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airplanes")
public class AirplaneController {

  private final AirplaneService airplaneService;

  public AirplaneController(AirplaneService airplaneService) {
    this.airplaneService = airplaneService;
  }

  @PostMapping
  public void save(@RequestBody Airplane airplane) {
    airplaneService.save(airplane);
  }

  @GetMapping
  public List<Airplane> getAll() {
    return airplaneService.getAll();
  }

  @GetMapping("/{id}")
  public Airplane getById(@PathVariable Long id) {
    return airplaneService.getById(id);
  }

  @PutMapping("/{id}")
  public void update(@PathVariable Long id, @RequestBody Airplane airplane) {
    airplane.setId(id);
    airplaneService.update(airplane);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    airplaneService.delete(id);
  }
}
