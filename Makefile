SRCS = $(shell find src -name "*.java")
STAMP = out/.compiled

all: build
	java -cp out school42.urduliz.dugonzal.avaj.application.components.Simulator $(SCENARIO)

build: $(STAMP)

$(STAMP): $(SRCS)
	@mkdir -p out
	find src -name "*.java" > sources.txt
	javac -d out @sources.txt
	@touch $@

clean:
	rm -rf out
	rm -f simulation.txt

fclean: clean
	rm -f sources.txt

re: fclean all

.PHONY: all build clean fclean re
