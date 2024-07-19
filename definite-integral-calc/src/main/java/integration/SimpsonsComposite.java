package integration;

import net.objecthunter.exp4j.Expression;

public class SimpsonsComposite extends IntegrationSolverImpl {
	
	public SimpsonsComposite(Expression f, int n) {
		super(f,n);
	}

	public double evaluateIntegral(double a, double b) {
		if(a > b)
			throw new IllegalArgumentException("Invalid integration parameters");
		
		double h = (b-a)/n;
		double eval = f.setVariable("x", a).evaluate() + f.setVariable("x", b).evaluate();
		
		for(int i=1; i<n; i++) {
			double x = a + i*h;
			if(i%2 == 0)
				eval += f.setVariable("x", x).evaluate() * 2;
			else 
				eval += f.setVariable("x", x).evaluate() * 4;
		}
		
		return eval * h/3;
	}
	
}
