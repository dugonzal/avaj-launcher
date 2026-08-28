package school42.urduliz.dugonzal.avaj.infrastructure;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import school42.urduliz.dugonzal.avaj.domain.enums.AircraftType;
import school42.urduliz.dugonzal.avaj.domain.model.exception.SimulationException;
import school42.urduliz.dugonzal.avaj.domain.model.records.Scenario;
import school42.urduliz.dugonzal.avaj.domain.model.records.value.Coordinates;

public class ScenarioParser {

  private final Path path;

  public ScenarioParser(String[] args) throws SimulationException {
    if (args.length != 1)
      throw new SimulationException("ERROR: invalid number of arguments (expected the scenario path)");

    this.path = Utils.validateFile(args[0]);
  }

  public Scenario parse() throws SimulationException {
    List<AircraftSpect> aircrafts = new ArrayList<>();
    List<String> lines = Utils.readLines(path);

    if (lines.isEmpty())
      throw new SimulationException("ERROR: empty file");


    int iterations = Utils.parseIterations(lines.get(0));
    if (iterations < 1)
      throw new SimulationException("ERROR: invalid number of iterations: " + iterations);

    for (int i = 1; i < lines.size(); i++) {
      String line = lines.get(i).trim();
      if (line.isEmpty()) continue;

      String[] parts = line.split("\\s+");
      if (parts.length != 5)
        throw new SimulationException("ERROR: invalid line in the input file, line: " + (i + 1) + ", content: " + line);

      AircraftType type = AircraftType.from(parts[0]);

      int longitude = Utils.parseCoordinate(parts[2]);
      int latitude  = Utils.parseCoordinate(parts[3]);
      int height    = Utils.parseCoordinate(parts[4]);
      aircrafts.add(new AircraftSpect(type, parts[1], new Coordinates(longitude, latitude, height)));
    }
    return new Scenario(iterations, aircrafts);
  }
}
