package school42.urduliz.dugonzal.avaj.domain.model.aircraft;

import school42.urduliz.dugonzal.avaj.domain.enums.Weather;
import school42.urduliz.dugonzal.avaj.domain.model.value.Coordinates;

public class Helicopter extends Aircraft {

  public Helicopter(long id, String name, Coordinates coordinates) {
    super(id, name, coordinates);
  }

  @Override
  protected WeatherUpdate weatherUpdate(Weather weather) {
    int lon = coordinates.longitude();
    int lat = coordinates.latitude();
    int h = coordinates.height();
    return switch (weather) {
      case SUN  -> new WeatherUpdate(lon + 10, lat, h + 2, "This is hot.");
      case RAIN -> new WeatherUpdate(lon + 5,  lat, h,     "Damn you rain! You messed up my helicopter.");
      case FOG  -> new WeatherUpdate(lon + 1,  lat, h,     "I can't see anything.");
      case SNOW -> new WeatherUpdate(lon,      lat, h - 12, "My rotor is going to freeze!");
    };
  }
}
