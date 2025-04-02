package by.mikhalachkin.airport.controller;

import by.mikhalachkin.airport.model.Passanger;
import by.mikhalachkin.airport.service.PassangerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passangers")
public class PassangerController {

  private final PassangerService passangerService;

  public PassangerController(PassangerService passangerService) {
    this.passangerService = passangerService;
  }

  @PostMapping
  public void create(@RequestBody Passanger passanger) {
    passangerService.save(passanger);
  }

  @GetMapping
  public List<Passanger> getAll() {
    return passangerService.getAll();
  }

  @GetMapping("/{id}")
  public Passanger getById(@PathVariable Long id) {
    return passangerService.getById(id);
  }

  @PutMapping("/{id}")
  public void update(@PathVariable Long id, @RequestBody Passanger passanger) {
    passanger.setId(id);
    passangerService.update(passanger);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    passangerService.delete(id);
  }
}
