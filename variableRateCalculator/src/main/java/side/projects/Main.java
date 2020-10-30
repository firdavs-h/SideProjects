package side.projects;

import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		menu();
		LiborRateService my = new LiborRateService();
		System.out.println("Current 1-Month USD LIBOR: % " + my.getRate() + "\nlast update on: " + my.getUpdateDate()
				+ "\nSource FRED: https://fred.stlouisfed.org/series/USD1MTD156N");

		Double bankMarginOnRate = input("Lender's Margin on Rate: %");
		Double yourCurrentBalance = input("current loan balance: $");

		VaribleRate myVaribleRate = new VaribleRate(my.getRate(), bankMarginOnRate, yourCurrentBalance);

		Map<String, Double> temp = myVaribleRate.interest();
		System.out.printf("Your daily interest amount is:  $%.2f %n", temp.get("1 day"));
		System.out.printf("Your monthly (30 days) interest amount is:  $%.2f %n", temp.get("30 day"));

	}

	public static void menu() {
		System.out.println("       *** Variable Rate Interest Calculator*** \n"
				+ "__________________________________________________\n");
		System.out.println("1-Month London Interbank Offered Rate (LIBOR) \n"
				+ "is most often used benchmark for variable rate loans \n"
				+ "If your variable rate loan based on LIBOR, \n"
				+ "this tool will calculate your interest amount with current LIBOR rates.\n"
				+ "\nLender's Margin on Rate: fixed rate amount lenders add to LIBOR \n"
				+ "Pulling current rate....\n");

	}

	public static Double input(String text) {
		Scanner scanner = new Scanner(System.in);
		Double temp = null;
		System.out.println("\nEnter to continue..");
		scanner.nextLine();
		boolean isNumber = false;
		while (!isNumber) {
			try {
				System.out.print("Please enter your " + text);
				temp = Double.parseDouble(scanner.nextLine());
				isNumber = true;
			} catch (NumberFormatException e) {
				System.out.println("Invalid entry, try again in 0.00 number format");
			}
		}
		return temp;

	}
}
