package school42.urduliz.dugonzal.avaj.aircraft;

import school42.urduliz.dugonzal.avaj.aircraft.Coordenates;

public final class AircraftSpect {
  public static final String[] TYPES = {"Baloon", "JetPlane", "Helicopter"};
  public static final String[] WEATHER = {"SUN", "RAIN", "FOG", "SNOW"};
	private final String type;
	private final String name;
	private Coordenates coordinates;

  public AircraftSpect(String type, String name, Coordenates coordinates) {
	this.type = type;
	this.name = name;
	this.coordinates = coordinates;
  }

  public String getType() { return type; }

  public String getName() { return name; }

  public Coordenates getCoordinates() { return coordinates; }
public AircraftSpect() {
  }

}
