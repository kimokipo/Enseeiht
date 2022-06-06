package petrinet.manip;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import petrinet.Petri;
import petrinet.EArc;
import petrinet.Arc;
import petrinet.ReadArc;
import petrinet.Place;
import petrinet.Transition;
import petrinet.PetrinetFactory;
import petrinet.PetrinetPackage;

public class PetriNetManipulator {

	public static void main(String[] args) {
		
		// Chargement du package petrinet afin de l'enregistrer dans le registre d'Eclipse.
		PetrinetPackage packageInstance = PetrinetPackage.eINSTANCE;
		
		// Enregistrer l'extension ".xmi" comme devant Ãªtre ouverte Ã 
		// l'aide d'un objet "XMIResourceFactoryImpl"
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
		
		// CrÃ©er un objet resourceSetImpl qui contiendra une ressource EMF (notre modÃ¨le)
		ResourceSet resSet = new ResourceSetImpl();

		// Charger la ressource (notre modÃ¨le)
		URI modelURI = URI.createURI("models/petrinetCreator_Created_Process.xmi");
		Resource resource = resSet.getResource(modelURI, true);
		
		// RÃ©cupÃ©rer le premier Ã©lÃ©ment du modÃ¨le (Ã©lÃ©ment racine)
		Petri petri = (Petri) resource.getContents().get(0);
		
		/**
		 * Manipulation de notre instance
		 */
		// AccÃ©der aux informations du processus chargÃ©
	    System.out.println("Petri : ");
	    // Naviguer dans les rÃ©fÃ©rences
	    Integer nbPE = petri.getPetriElements().size();
	    System.out.println("Nombre de PetriElement dans reseau Petri : " + nbPE);

		// Afficher les places et les transitions
		System.out.println("Les Places et les transitions sont :");
		for (Object o : petri.getPetriElements()) {
			if (o instanceof Place) {
				Place p = (Place) o;
				System.out.println("  - " + p.getName()+" "+p.getJettons()+" jettons");
			}else if (o instanceof Transition) {
				Transition t = (Transition) o;
				System.out.println("  - " + t.getName());
			}
		}
		// Naviguer dans les rÃ©fÃ©rences
	    Integer nbArcs = petri.getEarc().size();
	    System.out.println("Nombre de Earcs dans reseau Petri : " + nbArcs);

		// Afficher les Earcs
		System.out.println("Les Earcs sont :");
		for (Object o : petri.getEarc()) {
			if (o instanceof Arc) {
				Arc arc = (Arc) o;
				System.out.println("  - Arc_simple "+arc.getPoids());
			}else if (o instanceof ReadArc) {
				ReadArc readarc = (ReadArc) o;
				System.out.println("  - Read_Arc " + readarc.getPoids());
			}
		}
	}

}

