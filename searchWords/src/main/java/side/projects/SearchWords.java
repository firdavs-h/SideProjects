package side.projects;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchWords {

	// Project workflow:
	// need File Input scanner
	// need File input verify
	// need Text input scanner
	// need Word searcher
	// need Case sensitive switch

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		
		System.out.println("******************");
		System.out.println("    Word Search");
		System.out.println("******************");

		File file = verifiedInputFile();
		String word = textInput();
		boolean caseSensitive = caseSensitive();
		wordSearch(file, word, caseSensitive);

	}

	public static void wordSearch(File InputFile, String searchWord, boolean caseSensitive)
			throws FileNotFoundException {

		File inputFile = InputFile;
		try (Scanner fileScanner = new Scanner(inputFile)) {
			int lineCount = 0;
			while (fileScanner.hasNextLine()) {

				if (caseSensitive) { //case sensitive search
					String line = fileScanner.nextLine();
					lineCount++;

					if (line.contains(" "+searchWord)) {
						System.out.println(lineCount + ") " + line);
					}

				} else if (!caseSensitive) {
					String line = fileScanner.nextLine().toLowerCase();
					lineCount++;

					if (line.contains(" "+searchWord.toLowerCase())) {
						System.out.println(lineCount + ") " + line);

					}
				}
			}
		}
	}

	public static File fileInput() {
		System.out.println("What is the file that should be searched? ");

		String filePath = input.nextLine();
		File inputFile = new File(filePath);
		return inputFile;

	}

	public static File verifiedInputFile() {

		File temp = fileInput();
		//checks if file valid or exists
		while (temp.exists() != true || temp.isFile() != true) {
			if (temp.exists() == false) {
				System.out.println(temp.getPath() + " file does not exist, please try again");
				temp = fileInput();     //prompts new input from user, if file does not exists

			} else if (temp.isFile() == false) {
				System.out.println(temp.getPath() + " is not a file, please try again");
				temp = fileInput();   //prompts new input from user, if not a file

			}
		}

		return temp;

	}

	public static String textInput() {
		System.out.println("What is the search word you are looking for?");
		String lookWord = input.nextLine();

		return lookWord;

	}

	public static boolean caseSensitive() {
		System.out.println("Should the search be case sensitive? (Y\\N)");
		String caseInput = input.nextLine().toUpperCase();
		
		//checks if Y or N entered
		while (!caseInput.equals("Y") && !caseInput.equals("N")) {
			System.out.println(caseInput + " entered, please enter Y or N");
			caseInput = input.nextLine().toUpperCase(); // if not  Y or N prompts new entry

		}
		input.close();
		return caseInput.equals("Y");

	}

}
