
import javax.swing.*;
import java.awt.*;
public class ChatSwing extends JFrame {
	public ChatSwing(String nom) {
		super("Chat de "+nom);
		Chat chat = new Chat();
		VueChat vue = new VueChat(chat);
		ControleurChat controleur = new ControleurChat(chat,nom);
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(controleur);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		}
	public static void main(String[] args) {
		new ChatSwing("moi");
		new ChatSwing("toi");
		new ChatSwing("lui");
		} }

