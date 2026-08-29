package school42.urduliz.dugonzal.avaj.domain.model.aircraft;

import school42.urduliz.dugonzal.avaj.domain.enums.Weather;
import school42.urduliz.dugonzal.avaj.domain.model.records.Coordinates;

public class JetPlane extends Aircraft {

  public JetPlane(long id, String name, Coordinates coordinates) {
    super(id, name, coordinates);
  }

  @Override
  protected WeatherUpdate weatherUpdate(Weather weather) {
    int longitude = coordinates.longitude();
    int latitude = coordinates.latitude();
    int height = coordinates.height();
    return switch (weather) {
      case SUN  -> new WeatherUpdate(longitude, latitude + 10, height + 2, "Let's enjoy the good weather and take some pics.");
      case RAIN -> new WeatherUpdate(longitude, latitude + 5,  height,     "It's raining. Better watch out for lightings.");
      case FOG  -> new WeatherUpdate(longitude, latitude + 1,  height,     "I can't see anything.");
      case SNOW -> new WeatherUpdate(longitude, latitude,      height - 7, "OMG! Winter is coming!");
    };
  }
}
