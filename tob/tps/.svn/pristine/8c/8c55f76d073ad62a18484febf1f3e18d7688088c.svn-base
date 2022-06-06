import java.awt.Color;

/** Cercle modélise une courbe plane fermée constituée des points
 * géométriques situés à égale distance (rayon) d'un point nommée centre
 *  Un cercle peut être affiché et translaté.
 * On peut savoir si un point est à l'intérieur d'un cercle.
 * @author  Kamal Hammi
 */
public class Cercle implements Mesurable2D {
	
	public static final double PI = Math.PI;	/** le nombre PI. */
	
	private Point centre;		/** centre du cercle */
	private double rayon;		/** rayon du cercle */
	private Color couleur;	        /** couleur du cercle */

	/** Construire un cercle à partir de son centre et de son rayon.
	 * @param vc centre
	 * @param vr rayon
	 */
	public Cercle(Point vc, double vr) {
		assert vc != null;
		assert 0 < vr;
		this.centre = new Point(vc.getX(), vc.getY());
		this.rayon = vr;
		this.couleur = Color.blue;
	}

        /** Construire un cercle à partir de deux points diamètralement opposés.
	 * @param p1 première point
	 * @param p2 deuzième point
	*/
	public Cercle(Point p1, Point p2) {
		assert p1 != null && p2 != null;
		double vr = p1.distance(p2) / 2;
		assert vr > 0;
		this.centre = new Point(p1.getX() / 2 + p2.getX() / 2,
                        p1.getY() / 2 + p2.getY() / 2);
		this.rayon = vr;
		this.couleur = Color.blue;
	}

        /** Construire un cercle à partir de deux points
         * diamètralement opposés et de sa couleur.
	 * @param p1 première point
	 * @param p2 deuzième point
         * @param couleur couleur
	*/
	public Cercle(Point p1, Point p2, Color couleur) {
		this(p1, p2);
	        this.setCouleur(couleur);
	}

	/** Construire un autre cercle à partir de deux points,
         * l'une c'est le centre et l'autre appartient à ce cercle.
	 * @param pc point centre
	 * @param p point circonférence
	 * @return le nouveau cercle
	*/
	public static Cercle creerCercle(Point pc, Point p) {
		assert pc != null && p != null;
		return new Cercle(pc, pc.distance(p));
	}

	/** Obtenir le centre du cercle.
	 * @return centre du cercle
	 */
	public Point getCentre() {
		return new Point(this.centre.getX(), this.centre.getY());
	}

	/** Obtenir le rayon du cercle.
	 * @return rayon du cercle
	 */
	public double getRayon() {
		return this.rayon;
	}

	/** Obtenir le diamètre du cercle.
	 * @return diamètre du cercle
	 */
	public double getDiametre() {
		return this.rayon * 2;
	}

	/** Savoir si un point est à l'itérieure de cercle.
	 * @param p un point
	 * @return vrai se le point est à l'intérieur du cercle 
	*/
	public boolean contient(Point p) {
		assert p != null;
		return this.centre.distance(p) <= this.rayon;
	}

	/** Obtenir le perimètre du cercle.
 	* @return le perimètre du cercle
 	*/
	public double perimetre() {
		return PI * this.getDiametre();
	}
	
	/** Obtenir l'aire du cercle.
	* @return l'aire du cercle
	*/
	public double aire() {
		return PI * this.rayon * this.rayon;
	}


	/** Changer le rayon du cercle.
	  * @param vr nouvelle rayon
	*/
	public void setRayon(double vr) {
		assert 0 < vr;
		this.rayon = vr;
	}

	/** Changer le diamètre du cercle.
	  * @param vd nouvelle diamètre
	*/
	public void setDiametre(double vd) {
		assert 0 < vd;
		this.rayon = vd / 2;
	}

	public String toString() {
		return "C" + this.rayon + "@" + this.centre.toString();
	}

	/** Afficher le cercle. */
	public void afficher() {
		System.out.print(this);
	}

        /** Translater le cercle.
	 * @param dx déplacement suivant l'axe des X
	 * @param dy déplacement suivant l'axe des Y
	 */
	public void translater(double dx, double dy) {
		this.centre.translater(dx, dy);
	}

        //  Gestion de la couleur

	/** Obtenir la couleur du cercle.
	 * @return la couleur du cerlce
	 */
	public Color getCouleur() {
		return this.couleur;
	}

	/** Changer la couleur du cercle.
	  * @param nouvelleCouleur nouvelle couleur
	  */
	public void setCouleur(Color nouvelleCouleur) {
		assert nouvelleCouleur != null;
		this.couleur = nouvelleCouleur;
	}

}
