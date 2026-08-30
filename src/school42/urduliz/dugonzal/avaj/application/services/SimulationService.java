package school42.urduliz.dugonzal.avaj.application.services;

import school42.urduliz.dugonzal.avaj.domain.model.exception.SimulationException;
import school42.urduliz.dugonzal.avaj.domain.model.factory.AircraftFactory;
import school42.urduliz.dugonzal.avaj.domain.model.records.AircraftSpect;
import school42.urduliz.dugonzal.avaj.domain.model.records.Scenario;
import school42.urduliz.dugonzal.avaj.domain.model.weather.WeatherTower;
import school42.urduliz.dugonzal.avaj.infrastructure.contracts.Flyable;

public class SimulationService {

  private SimulationService() {
  }

  public static void run(Scenario scenario) throws SimulationException {
    WeatherTower tower = new WeatherTower();
    AircraftFactory factory = AircraftFactory.getInstance();

    for (AircraftSpect spec : scenario.aircrafts()) {
      Flyable aircraft = factory.newAircraft(spec.type(), spec.name(), spec.coordinates());
      aircraft.registerTower(tower);
      tower.register(aircraft);
    }

    for (int i = 0; i < scenario.iterations(); i++)
      tower.changeWeather();
  }
}
