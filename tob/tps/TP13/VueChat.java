import javax.swing.*;
public class VueChat extends JLabel{
	private Chat chat;
	public VueChat(Chat chat){
		this.chat = chat;
		chat.enregistrer(new java.util.Observer() {
			public void update(java.util.Observable o, Object arg) {
				mettreAJour();
			}
		});
	}

	private void mettreAJour() {
		new Afficheur(chat).update();
	}
}
