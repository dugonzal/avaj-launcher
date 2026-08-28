package school42.urduliz.dugonzal.avaj.domain.model.aircraft;

import school42.urduliz.dugonzal.avaj.domain.enums.AircraftType;
import school42.urduliz.dugonzal.avaj.domain.enums.Weather;
import school42.urduliz.dugonzal.avaj.domain.model.records.value.Coordinates;

public class Baloon extends Aircraft {

  public Baloon(long id, String name, Coordinates coordinates) {
    super(id, name, coordinates);
  }

  @Override
  public String getTypeName() {
    return AircraftType.BALOON.getLabel();
  }

  @Override
  protected WeatherUpdate weatherUpdate(Weather weather) {
    int longitude = coordinates.longitude();
    int latitude = coordinates.latitude();
    int height = coordinates.height();
    return switch (weather) {
      case SUN  -> new WeatherUpdate(longitude + 2, latitude, height + 4,  "Let's enjoy the good weather and take some pics.");
      case RAIN -> new WeatherUpdate(longitude,     latitude, height - 5,  "Damn you rain! You messed up my balloon.");
      case FOG  -> new WeatherUpdate(longitude,     latitude, height - 3,  "I can't see anything.");
      case SNOW -> new WeatherUpdate(longitude,     latitude, height - 15, "It's snowing. We're gonna crash.");
    };
  }
}
