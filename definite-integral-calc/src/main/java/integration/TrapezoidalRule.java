package integration;

import net.objecthunter.exp4j.Expression;

public class TrapezoidalRule extends IntegrationSolverImpl{

	public TrapezoidalRule(Expression f, int n) {
		super(f, n);
	}

	public double evaluateIntegral(double a, double b) {
		if(a > b) 
			throw new IllegalArgumentException("Invalid integration parameters");
		
		double xDelta = (b-a)/n;
		double sum = (f.setVariable("x", a).evaluate() + f.setVariable("x", b).evaluate())/2;
		
		for(int i=1; i<n; i++) {
			sum += f.setVariable("x", a+i*xDelta).evaluate();
		}
		
		return sum * xDelta;
	}

}
