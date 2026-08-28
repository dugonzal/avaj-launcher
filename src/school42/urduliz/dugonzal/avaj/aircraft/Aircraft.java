
package school42.urduliz.dugonzal.avaj.aircraft;

public abstract class Aircraft {

  private final AircraftSpect aircraftSpect;

  public Aircraft(String type, String name, int longitude, int latitude, int altitude) {
    this.aircraftSpect = new AircraftSpect(type, name, new Coordenates(longitude, latitude, altitude));
  }
}
