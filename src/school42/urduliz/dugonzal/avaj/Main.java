package school42.urduliz.dugonzal.avaj;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import school42.urduliz.dugonzal.avaj.utils.Utils;
import school42.urduliz.dugonzal.avaj.parser.Parser;

public class Main {

  public static void main(String[] args) {

    Parser parser = new Parser(args);

    parser.parse();
  }
}
