import java.util.HashMap;
import java.util.Stack;

/** Afficheur infixe, complètement parenthésé, d'une expression arithmétique.
  *
  * @author	Xavier Crégut
  * @version	$Revision$
  */
public class EvaluateurExpression implements VisiteurExpression<Integer> {

	private HashMap<String,Integer> Environment;
	private Integer og;
	private Integer od;
	private Integer os;
	
	public Integer visiterDefinition(Definition def) {
		Environment.put(def.getVariable().getNom(),def.getExpressionGauche().accepter(this));
		return def.getExpressionDroite().accepter(this);
	}
	
	public EvaluateurExpression(HashMap<String,Integer> env) {
		this.Environment = env;
	}
	public Integer visiterAccesVariable(AccesVariable v) {
		Integer valeur = Environment.get(v.getNom());
		if (valeur == null) {
			throw new VariableIntrouvable();
		}else{
			return valeur;
		}
	}

	public Integer visiterConstante(Constante c) {
		return c.getValeur();
	}

	public Integer visiterExpressionBinaire(ExpressionBinaire e) {
		int ogl = e.getOperandeGauche().accepter(this);
		this.od = e.getOperandeDroite().accepter(this);
		this.og = ogl;
		
		return e.getOperateur().accepter(this);
	}

	public Integer visiterAddition(Addition a) {
		return og + od;
	}

	public Integer visiterSoustraction(Soustraction s) {
		return og - od;
	}
	
	public Integer visiterMultiplication(Multiplication m) {
		return og * od;
	}

	public Integer visiterExpressionUnaire(ExpressionUnaire e) {
			this.os = e.getOperande().accepter(this);
			return e.getOperateur().accepter(this);
	}

	public Integer visiterNegation(Negation n) {
		return -os;
	}

}
