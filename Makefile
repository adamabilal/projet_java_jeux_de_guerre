
author: AissatouIbrahima DIALLO Adama TRAORÉ
	
cls: 
	javac -encoding utf8 -d cls -cp cls  src/jeu/*.java src/personnage/*.java src/joueur/*.java src/plateau/*.java src/action/*.java src/plateau/tuile/util/*.java src/personnage/util/*.java src/plateau/tuile/*.java src/io/*.java


clean:
	rm -rf  cls  doc

doc : 
	javadoc -d  doc  -cp doc src/jeu/*.java src/personnage/*.java src/joueur/*.java src/plateau/*.java src/action/*.java src/plateau/tuile/util/*.java src/personnage/util/*.java src/plateau/tuile/*.java src/io/*.java 

guerre: 
	java -jar jar/guerre.jar Raymond Odette