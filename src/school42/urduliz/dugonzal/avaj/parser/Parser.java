package school42.urduliz.dugonzal.avaj.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import school42.urduliz.dugonzal.avaj.utils.Utils;

public class Parser {
  private final ScenarioParser scenarioParser;
  private static final Logger log = Logger.getLogger(Parser.class.getName());

  public Parser(String[] args) {
    this.scenarioParser = new ScenarioParser(args);
  }

  public void parse() {
    if (args.length != 1) {
      log.severe("ERROR: número de argumentos inválido");
      System.exit(1);
    }

    Path path = scenarioParser.getPath();
    List<String> lines = Utils.readLines(path);
    if (lines.isEmpty()) {
      log.severe("ERROR: archivo vacío");
      System.exit(1);
    }
    int iterations = Utils.parseIterations(lines.get(0));
    for (int i = 1; i < lines.size(); i++) {
      String line = lines.get(i).trim();
      if (line.isEmpty()) {
        log.warning("Línea vacía en el archivo de entrada, línea: " + (i + 1));
        continue;
      }
      String[] parts = line.split("\\s+");
      if (parts.length != 5) {
        log.severe("ERROR: línea inválida en el archivo de entrada, línea: " +
                   (i + 1));
        System.exit(1);
      }
      try {
        String type = Utils.parseString(parts[0], "ERROR: tipo de aeronave inválido en la línea: " + (i + 1));
        String name = Utils.parseString(parts[1], "ERROR: nombre de aeronave inválido en la línea: " + (i + 1));
        int longitude = Utils.parseInt(parts[2], "ERROR: longitud inválida en la línea: " + (i + 1));
        int latitude = Utils.parseInt(parts[3], "ERROR: latitud inválida en la línea: " + (i + 1));
        int altitude = Utils.parseInt(parts[4], "ERROR: altitud inválida en la línea: " + (i + 1));
      } catch (NumberFormatException e) {
        log.severe("ERROR: coordenadas inválidas en la línea: " + (i + 1));
        System.exit(1);
      }

    }
  }
}
