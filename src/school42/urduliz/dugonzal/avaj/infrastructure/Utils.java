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
      throw new SimulationException("ERROR: no existe el archivo: " + filePath);
    }
    return path;
  }

  public static List<String> readLines(Path path) throws SimulationException {
    try {
      return Files.readAllLines(path);
    } catch (IOException e) {
      throw new SimulationException("ERROR: no se pudo leer el archivo: " + e.getMessage());
    }
  }

  // Número de iteraciones: entero estrictamente positivo.
  public static int parseIterations(String s) throws SimulationException {
    int v;
    try {
      v = Integer.parseInt(s.trim());
    } catch (NumberFormatException e) {
      throw new SimulationException("ERROR: la primera línea no es un número válido");
    }
    if (v < 1)
      throw new SimulationException("ERROR: el número de iteraciones debe ser mayor que 0");
    return v;
  }

  // Coordenada: entero no negativo (la altura puede ser 0; los negativos son inválidos).
  public static int parseCoordinate(String s) throws SimulationException {
    int v;
    try {
      v = Integer.parseInt(s.trim());
    } catch (NumberFormatException e) {
      throw new SimulationException("ERROR: coordenada inválida: \"" + s + "\"");
    }
    if (v < 0)
      throw new SimulationException("ERROR: coordenada inválida (no puede ser negativa): \"" + s + "\"");
    return v;
  }
}
