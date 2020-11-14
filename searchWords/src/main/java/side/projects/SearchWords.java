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

		System.out.println("======================");
		System.out.println("   Search A Word In The File");
		System.out.println("======================\n");

		File file = verifiedInputFile();
		String word = textInput();
		boolean caseSensitive = caseSensitive();
		wordSearch(file, word, caseSensitive);
		int option = 0;
		while (option != 3) {
			option = optionsMenu();
			if (option == 1) {
				word = textInput();
				caseSensitive = caseSensitive();
				wordSearch(file, word, caseSensitive);
			}
			if (option == 2) {
				file = verifiedInputFile();
				word = textInput();
				caseSensitive = caseSensitive();
				wordSearch(file, word, caseSensitive);
			}
		}
		input.close(); // closing scanner in last method that uses it
		System.exit(0);

	}

	private static void wordSearch(File InputFile, String searchWord, boolean caseSensitive)
			throws FileNotFoundException {

		File inputFile = InputFile;
		try (Scanner fileScanner = new Scanner(inputFile)) {
			int lineCount = 0;
			while (fileScanner.hasNextLine()) {

				if (caseSensitive) { // case sensitive search
					String line = fileScanner.nextLine();
					lineCount++;

					if (line.contains(searchWord)) {
						System.out.println(lineCount + ") " + line);
					}

				} else if (!caseSensitive) {
					String line = fileScanner.nextLine().toLowerCase();
					lineCount++;

					if (line.contains(searchWord.toLowerCase())) {
						System.out.println(lineCount + ") " + line);

					}
				}
			}
		}
	}

	private static File fileInput() {
		System.out.print("Name / Locate the file that should be searched? >>> ");

		String filePath = input.nextLine();
		File inputFile = new File(filePath);
		return inputFile;

	}

	private static File verifiedInputFile() {

		File temp = fileInput();
		// checks if file valid or exists
		while (temp.exists() != true || temp.isFile() != true) {
			if (temp.exists() == false) {
				System.out.println(temp.getAbsolutePath() + " file does not exist, please try again");
				temp = fileInput(); // prompts new input from user, if file does not exists
				if (temp.isFile() == false) {
					System.out.println(temp.getAbsolutePath() + " is not a file, please try again");
					temp = fileInput(); // prompts new input from user, if not a file
				}

			}
		}

		return temp;

	}

	private static String textInput() {
		System.out.print("Type a word / phase part of the word to search >>> ");
		String lookWord = input.nextLine();

		return lookWord;

	}

	private static boolean caseSensitive() {
		System.out.println("Should the search be case sensitive? (Y\\N)");
		String caseInput = input.nextLine().toUpperCase();

		// checks if Y or N entered
		while (!caseInput.equals("Y") && !caseInput.equals("N")) {
			System.out.println(caseInput + " entered, please enter Y or N");
			caseInput = input.nextLine().toUpperCase(); // if not Y or N prompts new entry

		}

		return caseInput.equals("Y");

	}

	private static int optionsMenu() {
		System.out.println("\n=====================\n" + "Choose options to continue:\n" + "1 - New word search\n"
				+ "2 - Search in new file\n" + "3 - Quit");
		String userInput = "";
		boolean valid = false;
		while (!valid) {
			userInput = input.nextLine();
			if (userInput.equals("1") || userInput.equals("2") || userInput.equals("3")) {
				valid = true;
			} else {
				System.out.println("Not valid option, Please choose 1,2 or 3:");
			}
		}

		return Integer.parseInt(userInput);
	}

}
