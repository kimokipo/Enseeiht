/** Programme de construction du schéma de la figure 1  .
  * @author  Kamal Hammi
  * @version 1.0
  */
public class TestSegment {

	public static void main(String[] args) {
		// Créer trois points et trois segments à partir de ces points
		Point p1 = new Point(3, 2);
		Point p2 = new Point(6, 9);
		Point p2 = new Point(11, 4);
		Segment s12 = new Segment(p1, p2);
		Segment s23 = new Segment(p2, p3);
		Segment s31 = new Segment(p3, p1);

		// Afficher les segments
		System.out.print("s12 = "); s12.afficher(); System.out.println();
		System.out.print("s23 = "); s23.afficher(); System.out.println();
		System.out.print("s31 = "); s31.afficher(); System.out.println();

		// Afficher les longueurs des trois segments
		System.out.println("longueur de s12 = " + s12.longueur());
		System.out.println("longueur de s23 = " + s23.longueur());
		System.out.println("longueur de s31 = " + s31.longueur());
		// Créer le barycentre des trois points
		Point g = new Point(p1.getX()/3+p2.getX()/3+p3.getX()/3,p1.getY()/3+p2.getY()/3+p3.getY()/3);
		// Afficher le barrrycentre
		System.out.print("le barycentre du triangle est : ");
		g.afficher(); System.out.println();
	}
}
