package school42.urduliz.dugonzal.avaj.domain.model.aircraft;

import school42.urduliz.dugonzal.avaj.domain.enums.Weather;
import school42.urduliz.dugonzal.avaj.domain.model.value.Coordinates;

public class Baloon extends Aircraft {

  public Baloon(long id, String name, Coordinates coordinates) {
    super(id, name, coordinates);
  }

  @Override
  public String getTypeName() {
    return "Balloon";
  }

  @Override
  protected WeatherUpdate weatherUpdate(Weather weather) {
    int lon = coordinates.longitude();
    int lat = coordinates.latitude();
    int h = coordinates.height();
    return switch (weather) {
      case SUN  -> new WeatherUpdate(lon + 2, lat, h + 4,  "Let's enjoy the good weather and take some pics.");
      case RAIN -> new WeatherUpdate(lon,     lat, h - 5,  "Damn you rain! You messed up my balloon.");
      case FOG  -> new WeatherUpdate(lon,     lat, h - 3,  "I can't see anything.");
      case SNOW -> new WeatherUpdate(lon,     lat, h - 15, "It's snowing. We're gonna crash.");
    };
  }
}
