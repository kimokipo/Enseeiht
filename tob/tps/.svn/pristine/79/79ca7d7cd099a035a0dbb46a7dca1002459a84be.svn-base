import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ControleurChat extends JPanel {
	public ControleurChat( final Chat chat,String chateurNom ){
		super(new GridLayout(3,1));
	// Définition de la vue du contrôleur;
	final JTextField zoneSaisie = new JTextField(6);
	final JButton bFermer = new JButton("Fermer");
	final JButton bOK = new JButton("OK");
	final JLabel nom = new JLabel(chateurNom);
	final JLabel zoneAffichage = new JLabel("");
	
	this.add(bFermer);
	this.add(zoneAffichage);
	JPanel contenu = new JPanel();
	contenu.add(nom);
	contenu.add(zoneSaisie);
	contenu.add(bOK);
	this.add(contenu);
	bFermer.addActionListener(ev -> System.exit(1));
	bOK.addActionListener(ev -> {
		zoneAffichage.setText(zoneAffichage.getText()+zoneSaisie.getText()+"\n");
		chat.ajouter(new MessageTexte(nom.getText(),zoneSaisie.getText()));
		});
	}
}

