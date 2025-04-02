package by.mikhalachkin.airport.controller;

import by.mikhalachkin.airport.model.Luggage;
import by.mikhalachkin.airport.service.LuggageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/luggages")
public class LuggageController {

  private final LuggageService luggageService;

  public LuggageController(LuggageService luggageService) {
    this.luggageService = luggageService;
  }

  @PostMapping
  public void save(@RequestBody Luggage luggage) {
    luggageService.save(luggage);
  }

  @GetMapping
  public List<Luggage> getAll() {
    return luggageService.getAll();
  }

  @GetMapping("/{id}")
  public Luggage getById(@PathVariable Long id) {
    return luggageService.getById(id);
  }

  @PutMapping("/{id}")
  public void update(@PathVariable Long id, @RequestBody Luggage luggage) {
    luggage.setId(id);
    luggageService.update(luggage);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    luggageService.delete(id);
  }
}
