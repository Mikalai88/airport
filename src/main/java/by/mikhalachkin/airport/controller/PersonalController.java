package by.mikhalachkin.airport.controller;

import by.mikhalachkin.airport.model.Personal;
import by.mikhalachkin.airport.service.PersonalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personal")
public class PersonalController {

  private final PersonalService personalService;

  public PersonalController(PersonalService personalService) {
    this.personalService = personalService;
  }

  @PostMapping
  public void save(@RequestBody Personal personal) {
    personalService.save(personal);
  }

  @GetMapping
  public List<Personal> getAll() {
    return personalService.getAll();
  }

  @GetMapping("/{id}")
  public Personal getById(@PathVariable Long id) {
    return personalService.getById(id);
  }

  @PutMapping("/{id}")
  public void update(@PathVariable Long id, @RequestBody Personal personal) {
    personal.setId(id);
    personalService.update(personal);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    personalService.delete(id);
  }
}