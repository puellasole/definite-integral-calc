package integration;

import net.objecthunter.exp4j.Expression;

public abstract class IntegrationSolverImpl implements IntegrationSolver{
	protected Expression f;
	protected int n;
	
	public IntegrationSolverImpl(Expression f, int n) {
		if(f == null || n <= 0)
			throw new IllegalArgumentException();
		this.f = f;
		this.n = n;
	}
	public void setN(int n) {
		if(n <= 0)
			throw new IllegalArgumentException();
		this.n = n;
	}
	
}
