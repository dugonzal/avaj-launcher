all: build
	java -cp out school42.urduliz.dugonzal.avaj.application.components.Simulator $(SCENARIO)
build:
	find src -name "*.java" > sources.txt
	javac -d out @sources.txt

clean:
	rm -rf out
	rm -rf simulation.txt

fclean: clean
	rm -rf sources.txt

re: fclean all
