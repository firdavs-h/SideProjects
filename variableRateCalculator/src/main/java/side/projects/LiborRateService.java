package side.projects;

import java.io.BufferedReader; 
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class LiborRateService {
	private String updateDate;
	private Double rate;

	public LiborRateService() {
		lineParse(ratePuller());

	}

	public String ratePuller() {
		String line = "";
		try {
			URL url = new URL("https://fred.stlouisfed.org/data/USD1MTD156N.txt"); //FRED have this data, but not in their API. 
			                                                                                                                               //Couldn't find any other free API with LIBOR data
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			Scanner myScanner = new Scanner(in);

			while (myScanner.hasNextLine()) {
				line = myScanner.nextLine();
			}
			myScanner.close();
		} catch (Exception e) {
			System.out.println("LIBOR rate source not found");
		}
		return line;
	}
	public void lineParse(String line) {
		String[] temp=line.split("   ");
		this.updateDate = temp[0];
		this.rate = Double.parseDouble(temp[1]);
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public Double getRate() {
		return rate;
	}

}
