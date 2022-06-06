all : compiler

compiler : 
	javac -cp ./javax.json-api-1.0.jar ./Jeu/Entry.java ./Jeu/FichePersonnageSwing.java ./Jeu/MaitreJeuSwing.java ./Jeu/MenuSelectionSwing.java ./Jeu/MenuSelectionSwing.java  ./Jeu/Utils.java ./Jeu/Interfaces/Capacite.java  ./Jeu/Interfaces/Inventaire.java ./Jeu/Interfaces/Statistique.java ./Jeu/Modeles/CapaciteSimple.java ./Jeu/Modeles/InventaireSimple.java ./Jeu/Modeles/ModeleFichePersonnage.java ./Jeu/Modeles/ModeleMaitreJeu.java ./Jeu/Modeles/StatistiqueSimple.java ./Jeu/Vues/MenuItemVue.java ./Jeu/Vues/MenuListVue.java ./Jeu/Vues/TexteActionVue.java ./de/DeSwing.java ./de/LancerDe.java ./de/LancerleDe.java

run : compiler
	java Jeu.Entry 

clean :
	rm -f ./Jeu/*.class
	rm -f ./Jeu/Vues/*.class
	rm -f ./Jeu/Interfaces/*.class
	rm -f ./Jeu/Modeles/*.class
	rm -f ./de/*.class
	rm -f ./Tests/*.class

test : compiler compilationTest
	java -cp .:./Jeu:./Jeu/Modeles:./Jeu/Vues:./Jeu/Interfaces:junit4.jar org.junit.runner.JUnitCore Tests.CapaciteTest
	java -cp .:./Jeu:./Jeu/Modeles:./Jeu/Vues:./Jeu/Interfaces:junit4.jar org.junit.runner.JUnitCore Tests.FichePersonnageTest
	java -cp .:./Jeu:./Jeu/Modeles:./Jeu/Vues:./Jeu/Interfaces:junit4.jar org.junit.runner.JUnitCore Tests.InventaireTest

compilationTest : 
	javac -cp .:./Jeu:./Jeu/Modeles:./Jeu/Vues:./Jeu/Interfaces:junit4.jar ./Tests/CapaciteTest.java ./Tests/FichePersonnageTest.java ./Tests/InventaireTest.java
	
jar : compiler
	jar --create --file=sources3.jar ./Jeu/Entry.java ./Jeu/FichePersonnageSwing.java ./Jeu/MaitreJeuSwing.java ./Jeu/MenuSelectionSwing.java ./Jeu/MenuSelectionSwing.java  ./Jeu/Utils.java ./Jeu/Interfaces/Capacite.java  ./Jeu/Interfaces/Inventaire.java ./Jeu/Interfaces/Statistique.java ./Jeu/Modeles/CapaciteSimple.java ./Jeu/Modeles/InventaireSimple.java ./Jeu/Modeles/ModeleFichePersonnage.java ./Jeu/Modeles/ModeleMaitreJeu.java ./Jeu/Modeles/StatistiqueSimple.java ./Jeu/Vues/MenuItemVue.java ./Jeu/Vues/MenuListVue.java ./Jeu/Vues/TexteActionVue.java ./de/DeSwing.java ./de/LancerDe.java ./de/LancerleDe.java junit4.jar javax.json-api-1.0.jar Makefile
