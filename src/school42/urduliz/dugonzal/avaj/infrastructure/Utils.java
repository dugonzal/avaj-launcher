package school42.urduliz.dugonzal.avaj.infrastructure;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import school42.urduliz.dugonzal.avaj.domain.model.exception.SimulationException;

public final class Utils {

  private Utils() {}

  public static Path validateFile(String filePath) throws SimulationException {
    Path path = Path.of(filePath);
    if (!path.toFile().isFile()) {
      throw new SimulationException("ERROR: file not found: " + filePath);
    }
    return path;
  }

  public static List<String> readLines(Path path) throws SimulationException {
    try {
      return Files.readAllLines(path);
    } catch (IOException e) {
      throw new SimulationException("ERROR: could not read the file: " + e.getMessage());
    }
  }

  public static int parseIterations(String s) throws SimulationException {
    int v;
    try {
      v = Integer.parseInt(s.trim());
    } catch (NumberFormatException e) {
      throw new SimulationException("ERROR: the first line is not a valid number");
    }
    if (v < 1)
      throw new SimulationException("ERROR: the number of iterations must be greater than 0");
    return v;
  }

  public static int parseCoordinate(String s) throws SimulationException {
    int v;
    try {
      v = Integer.parseInt(s.trim());
    } catch (NumberFormatException e) {
      throw new SimulationException("ERROR: invalid coordinate: \"" + s + "\"");
    }
    if (v < 0)
      throw new SimulationException("ERROR: invalid coordinate (cannot be negative): \"" + s + "\"");
    return v;
  }
}
