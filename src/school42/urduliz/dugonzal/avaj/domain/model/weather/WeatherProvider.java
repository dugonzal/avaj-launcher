package school42.urduliz.dugonzal.avaj.domain.model.weather;

import school42.urduliz.dugonzal.avaj.domain.model.records.value.Coordinates;

public class WeatherProvider {

  private static final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
  private static WeatherProvider instance = null;

  private WeatherProvider() {
  }

  public static WeatherProvider getInstance() {
    if (instance == null)
      instance = new WeatherProvider();
    return instance;
  }

  public String getCurrentWeather(Coordinates coordinates) {
    int sum = coordinates.longitude() + coordinates.latitude() + coordinates.height();
    return weather[Math.floorMod(sum, weather.length)];
  }
}
