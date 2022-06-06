import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComprendreSwing extends JPanel {

	final private JLabel nomTxt = new JLabel("Nom : ");
	final private JTextField nom = new JTextField(25);
	final private JButton bA = new JButton("A");
	final private JButton bB = new JButton("B");
	final private JButton bC = new JButton("C");
	final private JButton bQ = new JButton("Q");

	public ComprendreSwing() {
		super();
		this.setLayout(new FlowLayout());
		nomTxt.setHorizontalAlignment(JLabel.CENTER);
		this.add(nomTxt);
		this.add(nom);
		this.add(bA);
		this.add(bB);
		this.add(bC);
		this.add(bQ);
		this.bQ.addActionListener(new ActionQuitter());
		this.bC.addActionListener(new ActionEffacer());
		ActionTrace trace = new ActionTrace();
		bA.addMouseListener(trace);
		bB.addMouseListener(trace);
	}

	public class ActionQuitter implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			System.out.println("Quitter");
			System.exit(1);
		}
	}

	public class ActionEffacer implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			if (((JButton) ev.getSource()).getText().equals("C")){
				nom.setText("");
			}
		}
	}

	public class ActionTrace extends MouseAdapter {

		public void mouseCliked(MouseEvent ev) {
			System.out.println("Appui sur "
					+ ((JButton) ev.getSource()).getText());	
		}

		public void mouseEntered(MouseEvent ev) {
			JButton source = (JButton) ev.getSource();
			System.out.println("EntrÃ©e dans "
					+ source.getText());
		}

		public void mouseExited(MouseEvent ev) {
			JButton source = (JButton) ev.getSource();
			System.out.println("Sortie de "
					+ source.getText());
		}

	}

	public static JFrame newJFrame(String titre) {
		JFrame fenetre = new JFrame("		"+titre);
		ComprendreSwing comprendre = new ComprendreSwing();
		fenetre.getContentPane().add(comprendre);
		fenetre.pack();
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		return fenetre;
	}


	public static void exemple1() {
		JFrame frame1 = newJFrame("FenÃªtre1");
		JFrame frame2 = newJFrame("FenÃªtre2");
		frame2.setLocation(300, 100);
		frame1.setVisible(true);
		frame2.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(ComprendreSwing::exemple1);
			// On demande au fil d'exÃ©cutin de Swing d'exÃ©cuter la mÃ©thode
			// exemple1 de la classe ComprendreSwing.
		System.out.println("Fin du programme principal !");
	}

}
