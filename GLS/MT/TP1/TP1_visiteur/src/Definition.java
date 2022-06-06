
public class Definition implements Expression{
	
	private Expression expressiongauche;
	private Expression expressiondroite;
	private AccesVariable variable;

	public Definition(AccesVariable x, Expression gauche, Expression droite)
	{
		this.variable = x;
		this.expressiongauche = gauche;
		this.expressiondroite = droite;
	}

	public Expression getExpressionGauche() {
		return this.expressiongauche;
	}

	public Expression getExpressionDroite() {
		return this.expressiondroite;
	}

	public AccesVariable getVariable() {
		return this.variable;
	}
	public <R> R accepter(VisiteurExpression<R> visiteur) {
		return visiteur.visiterDefinition(this);
	}
}
