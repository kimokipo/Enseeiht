import java.lang.reflect.*;
import java.util.*;

/** L'objectif est de faire un lanceur simple sans utiliser toutes les clases
  * de notre architecture JUnit.   Il permet juste de valider la compréhension
  * de l'introspection en Java.
  */
public class LanceurIndependant {
	private int nbTestsLances;
	private int nbErreurs;
	private int nbEchecs;
	private List<Throwable> erreurs = new ArrayList<>();

	public LanceurIndependant(String... nomsClasses) {
	    System.out.println();

		// Lancer les tests pour chaque classe
		for (String nom : nomsClasses) {
			try {
				System.out.print(nom + " : ");
				this.testerUneClasse(nom);
				System.out.println();
			} catch (ClassNotFoundException e) {
				System.out.println(" Classe inconnue !");
			} catch (Exception e) {
				System.out.println(" Problème : " + e);
				e.printStackTrace();
			}
		}

		// Afficher les erreurs
		for (Throwable e : erreurs) {
			System.out.println();
			e.printStackTrace();
		}

		// Afficher un bilan
		System.out.println();
		System.out.printf("%d tests lancés dont %d échecs et %d erreurs.\n",
				nbTestsLances, nbEchecs, nbErreurs);
	}


	public int getNbTests() {
		return this.nbTestsLances;
	}


	public int getNbErreurs() {
		return this.nbErreurs;
	}


	public int getNbEchecs() {
		return this.nbEchecs;
	}


	private void testerUneClasse(String nomClasse)
		throws ClassNotFoundException, InstantiationException,
						  IllegalAccessException
	{
		nbEchecs = 0;
		nbErreurs = 0;
		nbTestsLances = 0;
		
		// Récupérer la classe
		Class notreClasse = Class.forName(nomClasse);
		
		Object obj = notreClasse.newInstance();
		
		// Récupérer les méthodes "preparer" et "nettoyer"
		Method preparer = null;
		Method nettoyer = null;
		try{
			preparer = notreClasse.getMethod("preparer");
			
		}catch(Exception e){
		}

		try{
			 nettoyer = notreClasse.getMethod("nettoyer");
		}catch(Exception e){}
		
		Method[] methodes = notreClasse.getMethods();
		List<Method> Liste_tests = new ArrayList<Method>();
		
 		for (Method  m : methodes) {
			if (m.getName().startsWith("test") && Modifier.isPublic(m.getModifiers()) && !Modifier.isStatic(m.getModifiers()) && m.getParameterCount() == 0) {
				Liste_tests.add(m);
			}
		}
 		
		// Instancier l'objet qui sera le récepteur des tests
		
		
		
		// Exécuter les méthods de test
		for(Method m : Liste_tests) {
			try {
				if (preparer != null) {
					preparer.invoke(obj);
				}
				m.invoke(obj);
				if (nettoyer != null) {
					nettoyer.invoke(obj);
				}
				nbTestsLances++;
			}catch(InvocationTargetException e) {
				if (e.getCause() instanceof Echec) {
					nbEchecs ++;
				}else {
					erreurs.add(e);
					nbErreurs++;
				}
			}
		}
		
		
	}

	public static void main(String... args) {
		LanceurIndependant lanceur = new LanceurIndependant(args);
	}

}
