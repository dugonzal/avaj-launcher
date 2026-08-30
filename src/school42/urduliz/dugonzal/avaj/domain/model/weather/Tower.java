package school42.urduliz.dugonzal.avaj.domain.model.weather;

import java.util.ArrayList;
import java.util.List;
import school42.urduliz.dugonzal.avaj.domain.model.aircraft.Aircraft;
import school42.urduliz.dugonzal.avaj.infrastructure.contracts.Flyable;

public class Tower {

  private List<Flyable> observers = new ArrayList<>();

  public void register(Flyable flyable) {
    observers.add(flyable);
    Aircraft a = (Aircraft)flyable;
    System.out.println("Tower says: " + a.getTypeName() + "#" + a.getName() +
                       "(" + a.getId() + ") registered to weather tower.");
  }

  public void unregister(Flyable flyable) {
    observers.remove(flyable);
    Aircraft a = (Aircraft)flyable;
    System.out.println("Tower says: " + a.getTypeName() + "#" + a.getName() +
                       "(" + a.getId() +
                       ") unregistered from weather tower.");
  }

  protected void conditionChanged() {
    for (Flyable f : new ArrayList<>(observers))
      f.updateConditions();
  }
}
