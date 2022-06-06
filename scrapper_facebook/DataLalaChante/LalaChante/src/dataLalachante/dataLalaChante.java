package dataLalachante;

import java.awt.EventQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;

public class dataLalaChante {

	private JFrame frame;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_7;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dataLalaChante window = new dataLalaChante();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public dataLalaChante() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("lien Google Sheet des Groupes");
		lblNewLabel_1.setBounds(23, 107, 234, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(259, 105, 114, 19);
		frame.getContentPane().add(textField_3);
		
		JLabel lblPremi_1 = new JLabel("Première Cellule");
		lblPremi_1.setBounds(75, 130, 130, 15);
		frame.getContentPane().add(lblPremi_1);
		
		JLabel lblIdCampagne = new JLabel("id Campagne");
		lblIdCampagne.setBounds(13, 239, 130, 15);
		frame.getContentPane().add(lblIdCampagne);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(117, 237, 114, 19);
		frame.getContentPane().add(textField_6);
		
		JButton btnScrapperPostsTrouvs = new JButton("Scrapper Posts");
		btnScrapperPostsTrouvs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnScrapperPostsTrouvs.setBounds(256, 233, 180, 25);
		frame.getContentPane().add(btnScrapperPostsTrouvs);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, -18, 448, 309);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(116, 27, 114, 19);
		panel.add(textField);
		
		JLabel lblNewLabel = new JLabel("nom");
		lblNewLabel.setBounds(12, 29, 104, 15);
		panel.add(lblNewLabel);
		
		JLabel lblPremi = new JLabel("login");
		lblPremi.setBounds(12, 54, 130, 15);
		panel.add(lblPremi);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(116, 52, 114, 19);
		panel.add(textField_1);
		
		JButton btnNewButton = new JButton("Ajouter Ambassadeur");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(242, 49, 193, 25);
		panel.add(btnNewButton);
		
		textField_5 = new JTextField();
		textField_5.setBounds(169, 199, 114, 19);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNomCampagne = new JLabel("mots clés Campagne");
		lblNomCampagne.setBounds(12, 201, 161, 15);
		panel.add(lblNomCampagne);
		
		JButton btnNewButton_1 = new JButton("Scrapper Groupes de lien");
		btnNewButton_1.setBounds(12, 164, 218, 25);
		panel.add(btnNewButton_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(295, 199, 114, 19);
		panel.add(textField_7);
		
		JButton btnChercher = new JButton("Chercher");
		btnChercher.setBounds(114, 221, 180, 25);
		panel.add(btnChercher);
		
		JButton btnNewButton_1_1 = new JButton("Rescrapper Groupes");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Process processus = Runtime.getRuntime().exec("node ../../rescrappeGroupFB.js "); 
					
					StringBuilder resultat = new StringBuilder(); 
					
					BufferedReader lecteur = new BufferedReader(new InputStreamReader(processus.getInputStream())); 
					
					String ligne;
					
					while (((ligne = lecteur.readLine()) != null)  && (!ligne.equals("fini"))) {
						System.out.println(ligne); 
					}
					System.out.println(ligne);
					if ( ligne.equals("fini") ) {
					
						processus.destroy();
						}
					
						
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setBounds(255, 162, 180, 25);
		panel.add(btnNewButton_1_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(262, 143, 114, 19);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(116, 81, 114, 19);
		panel.add(textField_2);
		
		JLabel lblPremi_2 = new JLabel("mot de passe");
		lblPremi_2.setBounds(12, 83, 130, 15);
		panel.add(lblPremi_2);
		btnChercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String lien = textField_3.getText();
				String cellule = textField_4.getText();

					try {
							Process processus = Runtime.getRuntime().exec("node ../../scrappeGroupFB.js "+lien +" "+cellule); 
							 
							
							BufferedReader lecteur = new BufferedReader(new InputStreamReader(processus.getInputStream())); 
							
							String ligne;
							
							while (((ligne = lecteur.readLine()) != null)  && (!ligne.equals("fini"))) {
								System.out.println(ligne); 
							}
							System.out.println(ligne);
							if (ligne.equals("fini")) {
							
								processus.destroy();
								}
							
								
						} catch (IOException e) {
							e.printStackTrace();
						}
					

				
				
			}
		});
	}
}
