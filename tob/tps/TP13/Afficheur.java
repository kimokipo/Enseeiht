import java.lang.*;
import java.util.*;
public class Afficheur implements Observer {
	private Chat chat;
	
	public Afficheur(Chat chat){
		this.chat = chat;
		this.chat.enregistrer(this);
	}

	void update(){
		Iterator<Message> it = this.chat.iterator();
		Message message;
		do {
			message = it.next();
		}while(it.hasNext());
		System.out.println(message);
	}
}
		
