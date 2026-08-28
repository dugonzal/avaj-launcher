package school42.urduliz.dugonzal.avaj.domain.model.records;

import java.util.List;

import school42.urduliz.dugonzal.avaj.infrastructure.AircraftSpect;

public record Scenario(int iterations, List<AircraftSpect> aircrafts) {
}
