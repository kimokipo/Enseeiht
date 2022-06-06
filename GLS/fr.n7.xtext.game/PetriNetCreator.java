package petrinet.manip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import petrinet.Petri;
import petrinet.PetriElement;
import petrinet.EArc;
import petrinet.Arc;
import petrinet.ReadArc;
import petrinet.Place;
import petrinet.Transition;
import simplepdl.Process;
import simplepdl.SimplepdlPackage;
import simplepdl.WorkDefinition;
import simplepdl.WorkSequence;
import simplepdl.WorkSequenceType;
import simplepdl.Ressource;
import simplepdl.Poids;
import petrinet.PetrinetFactory;
import petrinet.PetrinetPackage;

public class PetriNetCreator {

	static int sommeWorkdefinition (WorkDefinition wd) {
		int somme = 0;
		if(wd.getPoids().size() == 0) {
		  return 1;	
		}
		else {
		for (Poids p : wd.getPoids()) {
			somme += p.getVal();
		}
		return somme;
		}
	}
	
	public static void main(String[] args) {
		// Chargement du package SimplePDL afin de le transformer en petrinet.
				SimplepdlPackage packageInstancesimplepdl = SimplepdlPackage.eINSTANCE;
				
				// Enregistrer l'extension ".xmi" comme devant Ãªtre ouverte Ã 
				// l'aide d'un objet "XMIResourceFactoryImpl"
				Resource.Factory.Registry regsimplepdl = Resource.Factory.Registry.INSTANCE;
				Map<String, Object> msipmlepdl = regsimplepdl.getExtensionToFactoryMap();
				msipmlepdl.put("xmi", new XMIResourceFactoryImpl());
				
				// CrÃ©er un objet resourceSetImpl qui contiendra une ressource EMF (notre modÃ¨le)
				ResourceSet resSetsimple = new ResourceSetImpl();

				// Charger la ressource simple pdl (notre modÃ¨le)
				URI modelURIsipmlepdl = URI.createURI("models/SimplePDLCreator_Created_Process.xmi");
				Resource resourcesimplepdl = resSetsimple.getResource(modelURIsipmlepdl, true);
		// Charger le package petrinet afin de l'enregistrer dans le registre d'Eclipse.
		PetrinetPackage packageInstance = PetrinetPackage.eINSTANCE;
		
		// Enregistrer l'extension ".xmi" comme devant Ãªtre ouverte Ã 
		// l'aide d'un objet "XMIResourceFactoryImpl"
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
		
		// CrÃ©er un objet resourceSetImpl qui contiendra une ressource EMF (le modÃ¨le)
		ResourceSet resSet = new ResourceSetImpl();

		// DÃ©finir la ressource (le modÃ¨le)
		URI modelURI = URI.createURI("models/petrinetCreator_Created_Process.xmi");
		Resource resource = resSet.createResource(modelURI);
		
		// La fabrique pour fabriquer les Ã©lÃ©ments de petrinet
	    PetrinetFactory myFactory = PetrinetFactory.eINSTANCE;


		// RÃ©cupÃ©rer le premier Ã©lÃ©ment du modÃ¨le (Ã©lÃ©ment racine)
		Process process = (Process) resourcesimplepdl.getContents().get(0);
		
		// CrÃ©er un Ã©lÃ©ment Process
		Petri petri = myFactory.createPetri();
		
		petri.setName(process.getName());
		
		// Ajouter le Process dans le modÃ¨le
		resource.getContents().add(petri);
		
		
		// Recupérer les WorkDefinition
		Map<WorkDefinition, List<PetriElement>> petrielement_list=new HashMap<WorkDefinition,List<PetriElement>>();
		
		Map<Ressource, Place> Ressource_list = new HashMap<Ressource,Place>();
		
		for (Object o : process.getProcessElements()) {
			if (o instanceof Ressource) {
				Ressource r = (Ressource) o;
				
				Place pr = myFactory.createPlace();
				pr.setName(r.getName());
			    pr.setJettons(r.getNb_occurence());
			    
				petri.getPetriElements().add(pr);
				Ressource_list.put(r, pr);
			}
		}
				for (Object o : process.getProcessElements()) {
					if (o instanceof WorkDefinition) {
						List<PetriElement> petrielements = new ArrayList<PetriElement>();
						WorkDefinition wd = (WorkDefinition) o;
						
						Place p1 = myFactory.createPlace();
					    p1.setName("Ready_"+wd.getName());
					    p1.setJettons(1);
					    
					    Transition trans1 = myFactory.createTransition();
					    trans1.setName("Start_"+wd.getName());
					    
					    Arc arc1 = myFactory.createArc();
					    arc1.setPoids(1);
					    arc1.setSource(p1);
					    arc1.setDestination(trans1);
					    
					    Transition trans2 = myFactory.createTransition();
					    trans2.setName("Finish_"+wd.getName());
					    
					    Place p2 = myFactory.createPlace();
					    p2.setName("Started_"+wd.getName());
					    p2.setJettons(1);
					    
					    Arc arc2 = myFactory.createArc();
					    arc2.setPoids(sommeWorkdefinition(wd));
					    arc2.setSource(trans1);
					    arc2.setDestination(p2);
					    
					    Place p3 = myFactory.createPlace();
					    p3.setName("Finished_"+wd.getName());
					    p3.setJettons(1);
					    
					    Arc arc3 = myFactory.createArc();
					    arc3.setPoids(sommeWorkdefinition(wd));
					    arc3.setSource(p2);
					    arc3.setDestination(trans2);
					    
					    Arc arc4 = myFactory.createArc();
					    arc4.setPoids(1);
					    arc4.setSource(trans2);
					    arc4.setDestination(p3);

					    Place p4 = myFactory.createPlace();
					    p4.setName("Demarree_"+wd.getName());
					    p4.setJettons(1);
					    
					    Arc arc5 = myFactory.createArc();
					    arc5.setPoids(1);
					    arc5.setSource(trans1);
					    arc5.setDestination(p4);
					    
					    for (Poids p : wd.getPoids()) {
							Ressource r = p.getRessource();
							int val = p.getVal();
							Place pr = Ressource_list.get(r);
							
							Arc ressource_arc1 = myFactory.createArc();
							ressource_arc1.setPoids(val);
							ressource_arc1.setSource(trans2);
							ressource_arc1.setDestination(pr);
							
							Arc ressource_arc2 = myFactory.createArc();
							ressource_arc2.setPoids(val);
							ressource_arc2.setSource(pr);
							ressource_arc2.setDestination(trans1);
							

						    petri.getEarc().add(ressource_arc1);
						    petri.getEarc().add(ressource_arc2);
						}
					    
					    petri.getPetriElements().add(p1);
					    petri.getPetriElements().add(p2);
					    petri.getPetriElements().add(p3);
					    petri.getPetriElements().add(p4);
					    

					    petri.getPetriElements().add(trans1);
					    petri.getPetriElements().add(trans2);
					    
					    petri.getEarc().add(arc1);
					    petri.getEarc().add(arc2);
					    petri.getEarc().add(arc3);
					    petri.getEarc().add(arc4);
					    petri.getEarc().add(arc5);
					    petrielements.add(p3);
					    petrielements.add(p4);
					    petrielements.add(trans1);
					    petrielements.add(trans2);
					    petrielement_list.put(wd,petrielements);
					}
				}
				for (Object o : process.getProcessElements()) {
					if (o instanceof WorkSequence) {
						WorkSequence ws = (WorkSequence) o;
						WorkSequenceType typelink = ws.getLinkType();
						WorkDefinition predecessor = ws.getPredecessor();
						WorkDefinition successor = ws.getSuccessor();
						ReadArc readarc = myFactory.createReadArc();
						switch(typelink.getValue()){
							case  WorkSequenceType.FINISH_TO_FINISH_VALUE: 
									readarc.setPoids(1);
									readarc.setSource(petrielement_list.get(predecessor).get(0));
									readarc.setDestination(petrielement_list.get(successor).get(3));
									break;
							case  WorkSequenceType.FINISH_TO_START_VALUE: 
								readarc.setPoids(1);
								readarc.setSource(petrielement_list.get(predecessor).get(0));
								readarc.setDestination(petrielement_list.get(successor).get(2));
								break;
							case  WorkSequenceType.START_TO_FINISH_VALUE: 
								readarc.setPoids(1);
								readarc.setSource(petrielement_list.get(predecessor).get(1));
								readarc.setDestination(petrielement_list.get(successor).get(3));
								break;
							default : 
								readarc.setPoids(1);
								readarc.setSource(petrielement_list.get(predecessor).get(1));
								readarc.setDestination(petrielement_list.get(successor).get(2));
						}
						petri.getEarc().add(readarc);
					}
				}
				
				
	    
		// Sauver la ressource
	    try {
	    	resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

