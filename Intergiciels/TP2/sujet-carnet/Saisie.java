/* ------------------------------------------------------- 
		Les packages Java qui doivent etre importes.
*/
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.rmi.*;
import javax.swing.*;



/* ------------------------------------------------------- 
		Implementation de l'application
*/

public class Saisie extends JApplet {
	private static final long serialVersionUID = 1;
	TextField nom, email;
	Choice carnets;
	Label message;
	public void init() {
		setSize(300,200);
		setLayout(new GridLayout(6,2));
		add(new Label("  Nom : "));
		nom = new TextField(30);
		add(nom);
		add(new Label("  Email : "));
		email = new TextField(30);
		add(email);
		add(new Label("  Carnet : "));
		carnets = new Choice();
		carnets.addItem("Carnet1");
		carnets.addItem("Carnet2");
		add(carnets);
		add(new Label(""));
		add(new Label(""));
		Button Abutton = new Button("Ajouter");
		Abutton.addActionListener(new AButtonAction());
		add(Abutton);
		Button Cbutton = new Button("Consulter");
		Cbutton.addActionListener(new CButtonAction());
		add(Cbutton);
		message = new Label();
		add(message);
	}

	// La reaction au bouton Consulter
	class CButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			String n, c;
			n = nom.getText();
			c = carnets.getSelectedItem();
			message.setText("Consulter("+n+","+c+")        ");
			try {
				Carnet carnet = (Carnet) Naming.lookup("//localhost:4000/"+c);
				RFiche rf = carnet.Consulter(n,true);
				if (rf != null){
					String e = rf.getEmail();
					message.setText("l'email trouvé est :"+e);
				}else{
					message.setText("l'email n'a pas été trouvé");
				}
			} catch (Exception exc) {
				  exc.printStackTrace();
			}
		}
	}
	// La reaction au bouton Ajouter
	class AButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			String n, e, c;
			n = nom.getText();
			e = email.getText();
			c = carnets.getSelectedItem();
			message.setText("Ajouter("+n+","+e+","+c+")        ");
			try {
				Carnet carnet = (Carnet) Naming.lookup("//localhost:4000/"+c);
				carnet.Ajouter(new SFicheImpl(n,e));
			  } catch (Exception exc) {
				  exc.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]) {
		Saisie a = new Saisie();
		a.init();
		a.start();
		JFrame frame = new JFrame("Applet");
		frame.setSize(400,200);
  	frame.getContentPane().add(a);
  	frame.setVisible(true);
	}
	
}


