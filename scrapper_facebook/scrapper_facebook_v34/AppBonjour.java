import java.awt.*;
	import java.awt.event.*;

	public class AppBonjour extends Frame 
	 implements WindowListener { 
 
	 public AppBonjour() { 
	  addWindowListener(this);
	  add(new AppletBonjour());
	  setTitle("Fenêtre JAVA");
	  setSize(300,200);
	 } 

	 public void windowClosing(WindowEvent event) {
	  System.exit(0);
	 }

	 public void windowClosed(WindowEvent event) {}

	 public void windowDeiconified(WindowEvent event) {}

	 public void windowIconified(WindowEvent event) {}

	 public void windowActivated(WindowEvent event) {}

	 public void windowDeactivated(WindowEvent event) {}

	 public void windowOpened(WindowEvent event) {}

	 public static void main(String args[]) {
	  System.out.println("Démarrage de l'application...");
	  AppBonjour fr=new AppBonjour();
	  fr.show();
	 }

	}
