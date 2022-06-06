package ptolemy.plot.demo;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import ptolemy.plot.*;

public class afficher_results {
    public static final double Xmin = -5. , Xmax = 5. ; // Graph domain
    public static final int Npoint = 500;
    public static void main ( String [ ] args ) {
        Plot plotObj = new Plot() ; // Create Plot object
        plotObj.setTitle("f(x) vs x");
        plotObj.setXLabel("x");
        plotObj.setYLabel("f(x)");
        // plotObj . setSize (400 , 300) ;
        // plot O b j . s e tXRan g e ( Xmin , Xmax ) ;
        // plotObj . addPoint ( int Set , double x , double y , boolean connect )
        double xStep = (Xmax - Xmin ) / Npoint ;
        // Plotting loop
        for ( double x = Xmin ; x <= Xmax ; x += xStep ) {
            double y = Math.sin(x)*Math.sin(x);
            plotObj.addPoint(0, x, y, true) ;
        }
        PlotApplication app = new PlotApplication(plotObj) ; // Display
    }
}
