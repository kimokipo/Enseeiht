package de;

import javax.swing.*;
import java.awt.*;

public class DeSwing {

	private JFrame fenetre;
	private JButton btnLancerDe = new JButton("Lancer un dé");
	private JButton btnChangerTailleDe = new JButton("Changer de taille de dé");
	private JTextField nbFaceTxt = new JTextField(6);
	private JLabel valeur_texte = new JLabel("Résultat : ");
	private JLabel valeur_resultat = new JLabel();
	private LancerleDe modele;

	public DeSwing(LancerleDe modele) {
		this.fenetre = new JFrame("Menu de lancer de Dés");
		this.fenetre.setLocation(400, 500);
		this.modele = modele;

		configurerVues();
		configurerActions();

		this.fenetre.pack();
		this.fenetre.setVisible(true);
		this.fenetre.setResizable(false);
	}

	private void configurerVues() {
		JPanel contenuPrincipal = new JPanel();
		contenuPrincipal.setLayout(new BorderLayout());
		//contenuPrincipal.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		this.fenetre.setContentPane(contenuPrincipal);
		Container contenuAffichage = new Container();
		Container contenuBtn = new Container();

		//Bas de la fenêtre
		contenuBtn.setLayout(new FlowLayout());
		contenuBtn.add(nbFaceTxt);
		contenuBtn.add(btnChangerTailleDe);
		contenuBtn.add(btnLancerDe);

		//Haut de la fenêtre
		contenuAffichage.setLayout(new FlowLayout());
		contenuAffichage.add(valeur_texte);

		valeur_resultat.setText("0");

		contenuAffichage.add(valeur_resultat);
		contenuPrincipal.add(contenuAffichage,BorderLayout.NORTH);
		contenuPrincipal.add(contenuBtn,BorderLayout.SOUTH);



	}


	private void configurerActions() {
		btnChangerTailleDe.addActionListener(e -> {
			String s = nbFaceTxt.getText();
			try {
				int nb = Integer.parseInt(s);
				if(nb <= 0) {
					JOptionPane.showMessageDialog(null, "La taille du dé doit être > 0");
					return;
				}

				modele.changerNbFaces(nb);
			} catch (NumberFormatException nb) {
				JOptionPane.showMessageDialog(null, "Vous devez donner un nombre");
			}
		});
		btnLancerDe.addActionListener(e -> {
			valeur_resultat.setText(Integer.toString(modele.getValeur()));
		});
	}
}
