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
		
		
		// Récupérer les méthodes "preparer" et "nettoyer"
		Method methodeAvant = null;
		Method methodeApres = null;
		
		Method[] methodes = notreClasse.getMethods();
		HashMap<Method, Class<? extends Throwable>> Liste_tests = new HashMap<Method, Class<? extends Throwable>>();
		
 		for (Method  m : methodes) {
 			Avant annoAvant = m.getAnnotation(Avant.class);
 			if (annoAvant != null) {
 				methodeAvant = m;
 			}
 			Apres annoApres = m.getAnnotation(Apres.class);
 			if (annoApres != null) {
 				methodeApres = m;
 			}

 			UnTest annoUnTest = m.getAnnotation(UnTest.class);
			if (annoUnTest != null && annoUnTest.enabled() && Modifier.isPublic(m.getModifiers()) && !Modifier.isStatic(m.getModifiers()) && m.getParameterCount() == 0) {
				if (annoUnTest.expected() != UnTest.ExceptionValide.class) {
					Liste_tests.put(m,annoUnTest.expected());
				}else {
					Liste_tests.put(m,null);
				}
			}
		}
 		
		// Instancier l'objet qui sera le récepteur des tests

		Object obj = notreClasse.newInstance();
		
		
		// Exécuter les méthods de test
		for(Map.Entry<Method,Class<? extends Throwable>> e : Liste_tests.entrySet()) {
				Method m = e.getKey();
				Class<? extends Throwable> exception = e.getValue();
			if (exception == null) {
				try {
					if (methodeAvant != null) {
						methodeAvant.invoke(obj);
					}
					m.invoke(obj);
					if (methodeApres != null) {
						methodeApres.invoke(obj);
					}
					nbTestsLances++;
				}catch(InvocationTargetException f) {
					if (f.getCause() instanceof Echec) {
						nbEchecs ++;
					}else {
						erreurs.add(f);
						nbErreurs++;
					}
				}
			}else {
				int nbechecstatic = 0;
				try {
					nbTestsLances++;
					if (methodeAvant != null) {
						methodeAvant.invoke(obj);
					}
					m.invoke(obj);
					if (methodeApres != null) {
						methodeApres.invoke(obj);
					}
				}catch(InvocationTargetException f) {
					if (f.getCause().getClass() == exception) {
						nbechecstatic ++;
					}else {
						erreurs.add(f);
						nbErreurs++;
					}
				}
				if (nbechecstatic == 0) {
					nbEchecs++;
					System.out.println("l'exception "+exception+" est attendue");
					
				}
			}
		}
		
		
	}

	public static void main(String... args) {
		LanceurIndependant lanceur = new LanceurIndependant(args);
	}

}
