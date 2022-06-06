/** Afficheur postfixe, non parenthésé, d'une expression arithmétique.
  *
  * @author	Ikich Hammi
  * @version	$Revision$
  */
public class AfficheurPostfixe implements VisiteurExpression<String> {

	public String visiterDefinition(Definition def) {
		return def.getExpressionGauche().accepter(this) +" "+ def.getVariable().accepter(this) + " ni "+def.getExpressionDroite().accepter(this) +" tel";
	}
	
	public String visiterAccesVariable(AccesVariable v) {
		return v.getNom();
	}

	public String visiterConstante(Constante c) {
		return String.valueOf(c.getValeur());
	}

	public String visiterExpressionBinaire(ExpressionBinaire e) {
		return e.getOperandeGauche().accepter(this)
			+ " " + e.getOperandeDroite().accepter(this)
			+ " " + e.getOperateur().accepter(this);
	}

	public String visiterAddition(Addition a) {
		return "+";
	}

	public String visiterSoustraction(Soustraction s) {
		return "-";
	}
	
	public String visiterMultiplication(Multiplication m) {
		return "*";
	}

	public String visiterExpressionUnaire(ExpressionUnaire e) {
		return e.getOperande().accepter(this) + " " + e.getOperateur().accepter(this);
	}

	public String visiterNegation(Negation n) {
		return "~";
	}

}
