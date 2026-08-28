package school42.urduliz.dugonzal.avaj.infrastructure;

import school42.urduliz.dugonzal.avaj.domain.enums.AircraftType;
import school42.urduliz.dugonzal.avaj.domain.model.records.value.Coordinates;
public record AircraftSpect(AircraftType type, String name, Coordinates coordinates) {
}
