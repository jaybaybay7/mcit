/**
 * Vowels class iterates over each character in a string and counts the number of vowels in the string
 * @author jaymaglione
 *
 */


public class Vowels {
	
	/*
	 * Main method to iterate over string and count number of vowels
	 */

	public static void main(String[] args) {
		String word = "Test String";
		int counter = 0;

		for (int x = 0; x < word.length(); x++) {
			if (word.charAt(x) == 'a') {
				counter++;
			}
			else if (word.charAt(x) == 'e') {
				counter++;
			}
			else if (word.charAt(x) == 'i') {
				counter++;
			}
			else if (word.charAt(x) == 'o') {
				counter++;
			}
			else if (word.charAt(x) == 'u') {
				counter++;
			}
		}
		System.out.println(counter);
	}
		
		
}
