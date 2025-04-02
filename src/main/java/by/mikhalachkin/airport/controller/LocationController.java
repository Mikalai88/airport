package by.mikhalachkin.airport.controller;

import by.mikhalachkin.airport.model.Location;
import by.mikhalachkin.airport.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

  private final LocationService locationService;

  public LocationController(LocationService locationService) {
    this.locationService = locationService;
  }

  @PostMapping
  public void save(@RequestBody Location location) {
    locationService.save(location);
  }

  @GetMapping
  public List<Location> getAll() {
    return locationService.getAll();
  }

  @GetMapping("/{id}")
  public Location getById(@PathVariable Long id) {
    return locationService.getById(id);
  }

  @PutMapping("/{id}")
  public void update(@PathVariable Long id, @RequestBody Location location) {
    location.setId(id);
    locationService.update(location);
  }
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    locationService.delete(id);
  }
}

