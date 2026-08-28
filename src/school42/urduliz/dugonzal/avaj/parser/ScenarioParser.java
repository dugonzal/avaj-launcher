package school42.urduliz.dugonzal.avaj.parser;

public class ScenarioParser {
	private final Path path;

	public ScenarioParser(String [] args) {
		if (args.length != 1) {
			System.out.println("ERROR: número de argumentos inválido");
			System.exit(1);
		}
		this.path = Utils.validateFile(args[0]);
	}


	public Path getPath() {
		return path;
	}
}
