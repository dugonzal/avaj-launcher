package school42.urduliz.dugonzal.avaj.domain.model.factory;

import school42.urduliz.dugonzal.avaj.domain.enums.AircraftType;
import school42.urduliz.dugonzal.avaj.domain.model.aircraft.Baloon;
import school42.urduliz.dugonzal.avaj.domain.model.aircraft.Flyable;
import school42.urduliz.dugonzal.avaj.domain.model.aircraft.Helicopter;
import school42.urduliz.dugonzal.avaj.domain.model.aircraft.JetPlane;
import school42.urduliz.dugonzal.avaj.domain.model.exception.SimulationException;
import school42.urduliz.dugonzal.avaj.domain.model.value.Coordinates;

public class AircraftFactory {

  private static long idCounter = 0;
  private static AircraftFactory instance = null;

  private AircraftFactory() {
  }

  public static AircraftFactory getInstance() {
    if (instance == null)
      instance = new AircraftFactory();
    return instance;
  }

  public Flyable newAircraft(AircraftType type, String name, Coordinates coordinates) throws SimulationException {
    return switch (type) {
      case HELICOPTER -> new Helicopter(++idCounter, name, coordinates);
      case JETPLANE   -> new JetPlane(++idCounter, name, coordinates);
      case BALOON     -> new Baloon(++idCounter, name, coordinates);
    };
  }
}
