package school42.urduliz.dugonzal.avaj.domain.model.aircraft;

import school42.urduliz.dugonzal.avaj.domain.enums.Weather;
import school42.urduliz.dugonzal.avaj.domain.model.value.Coordinates;

public class JetPlane extends Aircraft {

  public JetPlane(long id, String name, Coordinates coordinates) {
    super(id, name, coordinates);
  }

  @Override
  protected WeatherUpdate weatherUpdate(Weather weather) {
    int lon = coordinates.longitude();
    int lat = coordinates.latitude();
    int h = coordinates.height();
    return switch (weather) {
      case SUN  -> new WeatherUpdate(lon, lat + 10, h + 2, "Let's enjoy the good weather and take some pics.");
      case RAIN -> new WeatherUpdate(lon, lat + 5,  h,     "It's raining. Better watch out for lightings.");
      case FOG  -> new WeatherUpdate(lon, lat + 1,  h,     "I can't see anything.");
      case SNOW -> new WeatherUpdate(lon, lat,      h - 7, "OMG! Winter is coming!");
    };
  }
}
