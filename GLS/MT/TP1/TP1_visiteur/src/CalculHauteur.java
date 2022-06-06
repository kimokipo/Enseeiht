/** Afficheur infixe, complètement parenthésé, d'une expression arithmétique.
  *
  * @author	Xavier Crégut
  * @version	$Revision$
  */
public class CalculHauteur implements VisiteurExpression<Integer> {

	public Integer visiterDefinition(Definition def) {
		return 1+max(def.getExpressionGauche().accepter(this),def.getExpressionDroite().accepter(this));
	}
	
	public Integer visiterAccesVariable(AccesVariable v) {
		return 1;
	}

	public Integer visiterConstante(Constante c) {
		return 1;
	}

	public Integer visiterExpressionBinaire(ExpressionBinaire e) {
		return e.getOperateur().accepter(this) + max(e.getOperandeGauche().accepter(this),
				e.getOperandeDroite().accepter(this));
	}

	private Integer max(Integer accepter, Integer accepter2) {
		if (accepter < accepter2) {
			return accepter2;
		}else {
			return accepter;
		}
	}

	public Integer visiterAddition(Addition a) {
		return 1;
	}

	public Integer visiterMultiplication(Multiplication m) {
		return 1;
	}

	public Integer visiterSoustraction(Soustraction s) {
		return 1;
	}
	
	public Integer visiterExpressionUnaire(ExpressionUnaire e) {
		return e.getOperateur().accepter(this)
		 + e.getOperande().accepter(this);
	}

	public Integer visiterNegation(Negation n) {
		return 1;
	}

}
