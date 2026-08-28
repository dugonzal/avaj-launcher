all:
	find src -name "*.java" > sources.txt
	javac -d out @sources.txt
	java -cp out school42.urduliz.dugonzal.avaj.Main

clean:
	rm -rf out

fclean: clean 
	rm -rf sources.txt

re: fclean all 
