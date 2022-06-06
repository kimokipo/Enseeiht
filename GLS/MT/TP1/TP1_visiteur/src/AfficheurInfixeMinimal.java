/** Afficheur infixe, complètement parenthésé, d'une expression arithmétique.
  *
  * @author	Xavier Crégut
  * @version	$Revision$
  */
public class AfficheurInfixeMinimal implements VisiteurExpression<String> {
	
	public String visiterDefinition(Definition def) {
		return "let " + def.getVariable().accepter(this) + " = "+def.getExpressionGauche().accepter(this) + " in "+ def.getExpressionDroite().accepter(this);
	}
	
	public String visiterAccesVariable(AccesVariable v) {
		return  v.getNom() ;
	}

	public String visiterConstante(Constante c) {
		return String.valueOf(c.getValeur());
	}

	public String visiterExpressionBinaire(ExpressionBinaire e) {
		String resultgauche = e.getOperandeGauche().accepter(this);
		if ((e.getOperandeGauche() instanceof ExpressionUnaire) | (e.getOperandeGauche() instanceof ExpressionBinaire)) {
			resultgauche = "("+resultgauche+")";
		}
		String resultdroite = e.getOperandeDroite().accepter(this);
		if ((e.getOperandeDroite() instanceof ExpressionUnaire) | (e.getOperandeDroite() instanceof ExpressionBinaire)) {
			resultdroite = "("+resultdroite+")";
		}
		return resultgauche
			+ " " + e.getOperateur().accepter(this)
			+ " " + resultdroite;
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
		String result = e.getOperande().accepter(this);
		if (e.getOperande() instanceof ExpressionBinaire) {
			result = "("+result+")";
		}
		return e.getOperateur().accepter(this)
			+ " " + result;
	}

	public String visiterNegation(Negation n) {
		return "-";
	}

}
