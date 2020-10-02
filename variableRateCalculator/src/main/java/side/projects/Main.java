package side.projects;

import java.math.BigDecimal;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
VaribleRate myVaribleRate =new VaribleRate(4.85, 100000.00);

Map<String, Double> temp =myVaribleRate.interest();
System.out.printf("Your daily interest amount is:  %.2f %n", temp.get("1 day"));
System.out.printf("Your monthly (30 days) interest amount is:  %.2f %n", temp.get("30 day"));

	}

}
