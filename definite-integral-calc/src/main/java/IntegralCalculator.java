import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import integration.TrapezoidalRule;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class IntegralCalculator {

	public static void main(String[] args) throws IOException {
		System.out.println("Input a function to integrate:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ExpressionBuilder expBuilder = new ExpressionBuilder(reader.readLine());
		Expression f = expBuilder.variable("x").build();
		System.out.println("Input a:");
		double a = Double.parseDouble(reader.readLine());
		System.out.println("Input b:");
		double b = Double.parseDouble(reader.readLine());
		System.out.println("Input precision:");
		int n = Integer.parseInt(reader.readLine());
		System.out.println("Solving integral...");
		System.out.println("Trapezoidal Method: ");
		System.out.println(new TrapezoidalRule(f,n).evaluateIntegral(a,b));
	}

}
