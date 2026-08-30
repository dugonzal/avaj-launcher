package school42.urduliz.dugonzal.avaj.infrastructure.contracts;

import school42.urduliz.dugonzal.avaj.domain.model.weather.WeatherTower;

public interface Flyable {

  void registerTower(WeatherTower weatherTower);

  void updateConditions();
}
