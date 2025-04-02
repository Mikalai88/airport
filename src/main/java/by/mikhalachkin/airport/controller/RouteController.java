package by.mikhalachkin.airport.controller;

import by.mikhalachkin.airport.model.Route;
import by.mikhalachkin.airport.service.RouteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

  private final RouteService routeService;

  public RouteController(RouteService routeService) {
    this.routeService = routeService;
  }

  @PostMapping
  public void save(@RequestBody Route route) {
    System.out.println("Saving route: " + route);
    routeService.save(route);
  }

  @GetMapping
  public List<Route> getAll() {
    return routeService.getAll();
  }

  @GetMapping("/{id}")
  public Route getById(@PathVariable Long id) {
    return routeService.getById(id);
  }

  @PutMapping("/{id}")
  public void update(@PathVariable Long id, @RequestBody Route route) {
    route.setId(id);
    routeService.update(route);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    routeService.delete(id);
  }
}
