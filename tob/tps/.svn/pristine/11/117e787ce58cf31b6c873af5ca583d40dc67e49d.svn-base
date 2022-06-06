import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
import java.util.zip.*;
import java.time.LocalDateTime;


/**
 * La classe principale.
 *
 * Tous les traitements demandés sont faits dans la mêthode
 * {@code repondreQuestions}.
 * Il serait plus logique d'écrire des méthodes qui pemettraient d'améliorer
 * la structuration et la réutilisation.  Cependant l'objectif est ici la
 * manipulation de l'API des collections, pas la structuration du code
 * en sous-programmes.
 */

public class Main {

	private static void repondreQuestions(Reader in) {
		Iterable<PointDeVente> iterable = PointDeVenteUtils.fromXML(in);

		// Construire un tableau associatif (pdvs) des points de vente avec un
		// accès par identifiant
		Map<Long, PointDeVente> pdvs = new HashMap<>();
		for (PointDeVente pdv : iterable){
			pdvs.put(pdv.getIdentifiant(),pdv);
		}
		// Nombre de point de vente
		System.out.println("Nombre de point de vente : " + pdvs.size());
			
		// Afficher le nombre de services existants
		int nbrServices = 0;
		for (PointDeVente pdv : pdvs.values()){
			nbrServices += pdv.getServices().size();
		}
		System.out.println("Nombre de services existants : " + nbrServices);

		// Afficher les services fournis
		System.out.println("les services fournis : ");
		for (PointDeVente pdv : pdvs.values()){
			for (String service : pdv.getServices()){
				System.out.println(service);
			}	
		}

		// Afficher la ville correspondant au point de vente d'identifiant
		// 31075001 et le prix du gazole le 25 janvier 2017 à 10h.
		PointDeVente lepdv = pdvs.get(31075001);
		String laville = lepdv.getVille();
		System.out.print("la ville : ");
		System.out.println((laville != null) ? laville : "");
		System.out.println("le prix : " + lepdv.getPrix(Carburant.GAZOLE,LocalDateTime.parse("2017-01-25T10:00:00")));

		// Afficher le nombre de villes offrant au moins un point de vente
		System.out.println("le nombre de villes offrant au moins un point de vente");
		Map<String, Integer> villes = new HashMap<>();
		for(PointDeVente pdv : iterable	){
			String ville  = pdv.getVille();
			int ancien = (villes.containsKey(ville)) ? villes.get(ville) : 0;
			villes.put(ville,ancien + 1);
		} 					
	
		for (Map.Entry<String,Integer> ville : villes.entrySet()){
			if (ville.getValue() !=0){
				System.out.println(ville.getKey());
			}
		}
			
		// Afficher le nombre moyen de points de vente par ville
		int moyen = 0;
		for (Map.Entry<String,Integer> ville : villes.entrySet()){
			moyen += ville.getValue();
		}
		System.out.println("le nombre moyen de points de vente par ville : " + moyen / villes.size());

		// le nombre de villes offrants un certain nombre de carburants
		
		
		// Afficher le nombre et les points de vente dont le code postal est 31200


		// Nombre de PDV de la ville de Toulouse qui proposent et du Gazole
		// et du GPLc.

		long nbPdvTGazGPLc = pdvs.values().stream()
		.filter(p -> p.getVille().equals("Toulouse") & p.getPrix().containsKey(Carburant.GAZOLE) & p.getPrix().containsKey(Carburant.GPLc)).count();
		System.out.println("Nombre de PDV de la ville de Toulouse qui proposent et du Gazole et du GPLc : " + nbPdvTGazGPLc);

		// Afficher le nom et le nombre de points de vente des villes qui ont au
		// moins 20 points de vente
		System.out.println("le nom et le nombre de points de vente des villes qui ont au moins 20 points de vente");
		for (Map.Entry<String,Integer> ville : villes.entrySet()){
			int nbrpdv = ville.getValue();
			if (nbrpdv >= 20){
				System.out.println("le nom de la ville : " + ville.getKey() + " son nombre de points de vente : " + nbrpdv);
			}
		}
	}


	private static Reader ouvrir(String nomFichier)
			throws FileNotFoundException, IOException
	{
		if (nomFichier.endsWith(".zip")) {
			// On suppose que l'archive est bien formée :
			// elle contient fichier XML !
			ZipFile zfile = new ZipFile(nomFichier);
			ZipEntry premiere = zfile.entries().nextElement();
			return new InputStreamReader(zfile.getInputStream(premiere));
		} else {
			return new FileReader(nomFichier);
		}
	}


	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("usage : java Main <fichier.xml ou fichier.zip>");
		} else {
			try (Reader in = ouvrir(args[0])) {
				repondreQuestions(in);
			} catch (FileNotFoundException e) {
				System.out.println("Fichier non trouvé : " + args[0]);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}

}
