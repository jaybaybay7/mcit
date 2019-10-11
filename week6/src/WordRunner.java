import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class WordRunner {

	public WordRunner() {

	}

	public boolean spellChecker(String word) {
		File dic = new File("./engDictionary.txt");
		try {
			Scanner s = new Scanner(dic);

			while (s.hasNext()) {
				if (s.next().equals(word)) {
					return true;
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public String inputLetterChecker() {
		Scanner k = new Scanner(System.in);
		String letterTemp = k.nextLine();
		String letter = letterTemp.toLowerCase();

		boolean check = true;
		while (check) {
			if (letter.equals("a") || letter.equals("r") || letter.equals("t")) {
				check = false;
				break;

			} else {
				System.out.println("Please enter a valid response");
				check = true;
				String newLetter = k.nextLine();
				letter = newLetter.toLowerCase();
				

			}
		}
		return letter;
	}

	public int inputNumberChecker() {
		Scanner w = new Scanner(System.in);
		int number = w.nextInt();

		boolean check = true;
		while (check) {
			if (number == 1 || number == 2 || number == 3) {
				check = false;
				break;

			} else {
				System.out.println("Please enter a valid response");
				check = true;
				number = w.nextInt();

			}
		}
		return number;
	}

	public void spellWriter() {
		WordRecommender wr = new WordRecommender("./good_words.txt");

		File myfile = new File("/Users/jaymag/git/mcit/week6/src/bad_words.txt");

		Scanner s;
		try {
			s = new Scanner(myfile);
			FileWriter fw = new FileWriter("tester_fix.txt", true);

			while (s.hasNext()) {
				String temp = s.next().toLowerCase();

				if (spellChecker(temp) == true) {
					fw.write(temp);
					fw.write(" ");
				}
				if (spellChecker(temp) == false) {
					System.out.println("The word " + temp + " is misspelled.");

					ArrayList<String> tempStringArray = wr.getWordSuggestions(temp, 2, 0.75, 3);

					// Condition if the word suggestions return no values
					if (tempStringArray.get(0).equals("0")) {
						System.out.println("There are 0 suggestions in our dictionary for this word.");
						System.out.println("Press ‘a’ for accept as is, ‘t’ for type in manually.");

						// Check to make sure user inputs the right letter
						String thisLetter = inputLetterChecker();

						// conditionals
						if (thisLetter.equals("a")) {
							fw.write(temp);
							fw.write(" ");

						} else if (thisLetter.equals("t")) {
							Scanner u = new Scanner(System.in);
							System.out.println(
									"Please type the word that will be used as the replacement in the output file.");
							String manWord = u.nextLine().toLowerCase();
							fw.write(manWord);
							fw.write(" ");
						}

					} else {

						// Conditional for if the suggestions have values in them
						System.out.println("The following suggestions are available:");

						System.out.println(wr.prettyPrint(tempStringArray));
						System.out.println("Press ‘r’ for replace, ‘a’ for accept as is, ‘t’ for type in manually.");
						
						String letter = inputLetterChecker();

						if (letter.equals("a")) {
							fw.write(temp);
							fw.write(" ");
						} else if (letter.equals("r")) {
							System.out.println(
									"Enter the number corresponding to the word that you want to use for replacement.");

							// do the check to ensure the number is correct
							int newNumber = inputNumberChecker();

							if (newNumber == 1) {
								fw.write(tempStringArray.get(0));
								fw.write(" ");
							} else if (newNumber == 2) {
								fw.write(tempStringArray.get(1));
								fw.write(" ");
							} else if (newNumber == 3) {
								fw.write(tempStringArray.get(2));
								fw.write(" ");
							}

						} else if (letter.equals("t")) {
							Scanner p = new Scanner(System.in);
							System.out.println(
									"Please type the word that will be used as the replacement in the output file.");
							String manualWord = p.nextLine().toLowerCase();
							fw.write(manualWord);
							fw.write(" ");
						}

					}

				}
			}

			fw.flush();
			fw.close();
			System.out.println("Your new file is available to read");

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		WordRunner w = new WordRunner();
		w.spellWriter();

	}

}
