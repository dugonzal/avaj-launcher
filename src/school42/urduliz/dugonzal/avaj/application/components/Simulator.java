package school42.urduliz.dugonzal.avaj.application.components;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import school42.urduliz.dugonzal.avaj.application.services.SimulationService;
import school42.urduliz.dugonzal.avaj.domain.model.exception.SimulationException;
import school42.urduliz.dugonzal.avaj.infrastructure.Scenario;
import school42.urduliz.dugonzal.avaj.infrastructure.ScenarioParser;

public class Simulator {

  public static void main(String[] args) {
    try {
      Scenario scenario = new ScenarioParser(args).parse();
      run(scenario);
    } catch (SimulationException e) {
      System.out.println(e.getMessage());
      System.exit(1);
    } catch (IOException e) {
      System.out.println("ERROR: no se pudo escribir simulation.txt: " + e.getMessage());
      System.exit(1);
    }
  }

  private static void run(Scenario scenario) throws SimulationException, IOException {
    PrintStream original = System.out;
    try (PrintStream fileOut = new PrintStream(new FileOutputStream("simulation.txt"))) {
      System.setOut(fileOut);
      SimulationService.run(scenario);
      System.out.flush();
    } finally {
      System.setOut(original);
    }
  }
}
