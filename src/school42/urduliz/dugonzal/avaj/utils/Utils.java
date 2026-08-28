package school42.urduliz.dugonzal.avaj.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public final class Utils {
  public static Path validateFile(String filePath) {
    Path path = Path.of(filePath);

    if (!path.toFile().isFile()) {
      System.out.println("ERROR: no existe el archivo: " + filePath);
      System.exit(1);
    }
    return path;
  }

  public static String parseString(String line, String errorMessage) {
	if (line == null || line.trim().isEmpty()) {
	  System.out.println(errorMessage);
	  System.exit(1);
	}
	return line.trim();
  }
  
  public static int parseInt(String line, String errorMessage) {
    try {
      int iterations = Integer.parseInt(line.trim());

      if (iterations < 1) {
        System.out.println(errorMessage);
        System.exit(1);
      }

      return iterations;
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(
          "ERROR: primera línea no es un número válido");
    }
  }

  public static List<String> readLines(Path path) {
    try {
      return Files.readAllLines(path);
    } catch (IOException e) {
      System.out.println("ERROR: no se pudo leer el archivo: " +
                         e.getMessage());
      System.exit(1);
    }
    return Collections.emptyList();
  }
}
