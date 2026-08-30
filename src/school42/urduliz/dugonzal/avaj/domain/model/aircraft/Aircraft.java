package school42.urduliz.dugonzal.avaj.domain.model.aircraft;

import school42.urduliz.dugonzal.avaj.domain.enums.Weather;
import school42.urduliz.dugonzal.avaj.domain.model.records.Coordinates;
import school42.urduliz.dugonzal.avaj.domain.model.records.WeatherUpdate;
import school42.urduliz.dugonzal.avaj.domain.model.weather.WeatherTower;
import school42.urduliz.dugonzal.avaj.infrastructure.contracts.Flyable;

public abstract class Aircraft implements Flyable {

  protected long id;
  protected String name;
  protected Coordinates coordinates;
  protected WeatherTower weatherTower;

  protected Aircraft(long id, String name, Coordinates coordinates) {
    this.id = id;
    this.name = name;
    this.coordinates = coordinates;
  }

  @Override
  public void registerTower(WeatherTower weatherTower) {
    this.weatherTower = weatherTower;
  }

  public long getId() { return id; }
  public String getName() { return name; }
  public Coordinates getCoordinates() { return coordinates; }

  public String getTypeName() {
    return getClass().getSimpleName();
  }

  // Esqueleto común del update: consulta el clima, deja que el subtipo aplique su tabla
  // y cierra con finishUpdate. Así el flujo del tiempo vive una sola vez (Template Method).
  @Override
  public final void updateConditions() {
    Weather weather = Weather.valueOf(weatherTower.getWeather(coordinates));
    WeatherUpdate update = weatherUpdate(weather);
    finishUpdate(update.longitude(), update.latitude(), update.height(), update.message());
  }

  // Cada subtipo declara solo su tabla de movimiento + mensaje.
  protected abstract WeatherUpdate weatherUpdate(Weather weather);

  protected void writeMessage(String message) {
    System.out.println(getTypeName() + "#" + name + "(" + id + "): " + message);
  }

  protected void writeLanding() {
    System.out.println(getTypeName() + "#" + name + "(" + id + ") landing.");
  }

  protected final void finishUpdate(int longitude, int latitude, int height, String message) {
    if (height > 100)
      height = 100;
    else if (height < 0)
      height = 0;

    coordinates = new Coordinates(longitude, latitude, height);
    writeMessage(message);
    if (height == 0) {
      writeLanding();
      weatherTower.unregister(this);
    }
  }
}
