import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordRecommender {
	private String filename;

	public WordRecommender(String fileName) {
		this.filename = fileName;
	}

	// helper method to return which of the two words is shorter
	// used in the getSimilarityMetric method
	public String returnShorterWord(String firstWord, String secondWord) {
		if (firstWord.length() < secondWord.length()) {
			return firstWord;
		} else {
			return secondWord;
		}
	}

	/*
	 * given two words, this function computes two measures of similarity and
	 * returns the average.
	 */
	
	public double getSimilarityMetric(String word1, String word2) {
		 
		 int leftSim = 0;
		 int rightSim = 0;
		 
		 StringBuilder w1r = new StringBuilder();
		 StringBuilder w2r = new StringBuilder();
		 
		 //w1r is now word1 backwards
		 w1r.append(word1);
		 w1r.reverse();
		 
		//w2r is now word2 backwards
		 w2r.append(word2);
		 w2r.reverse();
		 
		 
		 //Left to right letter check
			for (int i = 0; i < returnShorterWord(word1, word2).length(); i++) {
			 if (word1.charAt(i) == word2.charAt(i)) {
				 leftSim++;
			 }
		 }
		 
		 //righjt to left letter check
		 for (int j = 0; j < returnShorterWord(word1, word2).length(); j++) {
			 if(w1r.charAt(j) == w2r.charAt(j)) {
				 rightSim++;
			 }
		 }
		 
		 double simMetric = (Double.valueOf(leftSim) + Double.valueOf(rightSim)) / 2.0;
		 
		 return simMetric;
	 }
	
	
	/*
	 * given an incorrect word, return a list of legal word
	 * suggestions as per an algorithm
	 */

	public ArrayList<String> getWordSuggestions(String word, int n, double commonPercent, int topN) {
		
		//Defining all the variables needed
		String testWord = word.toLowerCase();
		int testWordLength = word.length();
		int upperBoundWordLength = testWordLength + n;
		int lowerBoundWordLength = testWordLength - n;
		ArrayList<String> wordList = new ArrayList<String>();
		ArrayList<String> word1Chars = new ArrayList<String>();
		ArrayList<String> word2Chars = new ArrayList<String>();
		
		//making engDictionary import work
		File input = new File("./engDictionary.txt");
		
		//pulling each character of the input word into a arraylist
		
		for (int i = 0; i < testWordLength; i++) {
			word1Chars.add(Character.toString(testWord.charAt(i)));
		}
		
		
		//Open up dictionary file and read in each word
		 try {
			Scanner s = new Scanner(input);
			
			while(s.hasNext()) {
				String nextWord = s.next();
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return word1Chars;
		
	}

	public ArrayList<String> getWordsWithCommonLetters(String word, ArrayList<String> listOfWords, int n) {
//		 /Given a word and a list of words from a dictionary, return the list of words in the dictionary that
		// have at least (>=) n letters in common.
		// todo
	}

	public String prettyPrint(ArrayList<String> list) {

	}

	public static void main(String[] args) {
		WordRecommender wr = new WordRecommender("wordtedster_good");
		
		wr.getWordSuggestions("hello", 1, 1.0, 1);
	}
}
