package school42.urduliz.dugonzal.avaj.domain.model.aircraft;

import school42.urduliz.dugonzal.avaj.domain.enums.Weather;
import school42.urduliz.dugonzal.avaj.domain.model.records.Coordinates;

public class Helicopter extends Aircraft {

  public Helicopter(long id, String name, Coordinates coordinates) {
    super(id, name, coordinates);
  }

  @Override
  protected WeatherUpdate weatherUpdate(Weather weather) {
    int longitude = coordinates.longitude();
    int latitude = coordinates.latitude();
    int height = coordinates.height();
    return switch (weather) {
      case SUN  -> new WeatherUpdate(longitude + 10, latitude, height + 2, "This is hot.");
      case RAIN -> new WeatherUpdate(longitude + 5,  latitude, height,     "Damn you rain! You messed up my helicopter.");
      case FOG  -> new WeatherUpdate(longitude + 1,  latitude, height,     "I can't see anything.");
      case SNOW -> new WeatherUpdate(longitude,      latitude, height - 12, "My rotor is going to freeze!");
    };
  }
}
