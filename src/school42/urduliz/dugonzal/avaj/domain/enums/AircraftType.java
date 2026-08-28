package school42.urduliz.dugonzal.avaj.domain.enums;

import school42.urduliz.dugonzal.avaj.domain.model.exception.SimulationException;

public enum AircraftType {

  BALOON("Baloon"),
  JETPLANE("JetPlane"),
  HELICOPTER("Helicopter");

  private final String label;

  AircraftType(String label) { this.label = label; }

  public String getLabel() { return label; }

  public static AircraftType from(String raw) throws SimulationException {
    for (AircraftType t : values())
      if (t.label.equals(raw) || t.name().equalsIgnoreCase(raw))
        return t;

    throw new SimulationException("ERROR: unknown aircraft type: " + raw);
  }
}
