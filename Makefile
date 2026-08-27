all:
	find src -name "*.java" > sources.txt
	javac @sources.txt
	java -cp src school42.urduliz.dugonzal.avaj.Main
clean:
	rm -rf out
fclean: clean 
	rm -rf sources.txt

re: fclean all 
