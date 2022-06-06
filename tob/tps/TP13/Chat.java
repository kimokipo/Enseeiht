import java.util.*;
import java.util.ArrayList;
import java.util.Collections;

public class Chat extends Observable implements Iterable<Message>{

	private List<Message> messages;
	private List<Observer> observateurs;
	public Chat() {
		this.messages = new ArrayList<Message>();
		this.observateurs = new ArrayList<Observer>();
	}

	public Iterator<Message> iterator(){
		return this.messages.iterator();
	}

	public void ajouter(Message m) {
		this.messages.add(m);
		this.avertir();
	}
	
	public void enregistrer(Observer o){
		 this.observateurs.add(o);
	}

	private void avertir(){
		this.setChanged();
		this.notifyObservers();
	}	
}
