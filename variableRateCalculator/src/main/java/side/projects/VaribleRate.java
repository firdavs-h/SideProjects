package side.projects;

import java.util.HashMap;
import java.util.Map;

public class VaribleRate {
	
	private Double indexRate;
	private Double bankMarginOnRate;
	private Double yourCurrentBalance;
	
	public VaribleRate(Double indexRate, Double bankMarginOnRate, Double yourCurrentBalance) {
		this.indexRate =indexRate;
		this.bankMarginOnRate = bankMarginOnRate;
		this.yourCurrentBalance = yourCurrentBalance;
		
	}
	
	public Map<String, Double> interest() {
		Map<String, Double> interestMap=new HashMap<String, Double>();

		Double totalRate=indexRate+bankMarginOnRate;
      	System.out.println("Your current APR is: % "+ totalRate);
	    Double oneDayRate=((indexRate+bankMarginOnRate)/100)/365;

		Double oneDayInterest= yourCurrentBalance*oneDayRate;
		interestMap.put("1 day", oneDayInterest);
		interestMap.put("30 day",oneDayInterest*30);
		
		return interestMap;
	}
	
}
