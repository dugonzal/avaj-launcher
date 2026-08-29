package school42.urduliz.dugonzal.avaj.domain.model.weather;

import school42.urduliz.dugonzal.avaj.domain.model.records.Coordinates;

public class WeatherTower extends Tower {

  public String getWeather(Coordinates coordinates) {
    return WeatherProvider.getInstance().getCurrentWeather(coordinates);
  }

  public void changeWeather() {
    conditionChanged();
  }
}
