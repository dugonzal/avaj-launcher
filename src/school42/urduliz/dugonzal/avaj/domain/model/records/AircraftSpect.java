package school42.urduliz.dugonzal.avaj.domain.model.records;

import school42.urduliz.dugonzal.avaj.domain.enums.AircraftType;

public record AircraftSpect(AircraftType type, String name, Coordinates coordinates) {
}
