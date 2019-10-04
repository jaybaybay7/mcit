import java.util.ArrayList;
import java.util.Scanner;

public class WordRecommender {
	private String filename;

	public WordRecommender(String fileName) {
		this.filename = fileName;
	}

	/*
	 * given two words, this function computes two measures of similarity and
	 * returns the average.
	 */

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
	 * method for returning similarity. Uses returnShorterWord method
	 */
	
	public double getSimilarityMetric(String word1, String word2) {
		
		//Todo figure out how to handle words without the same length
		 
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
		 
		 double simMetric = (Double.valueOf(leftSim) + Double.valueOf(rightSim)) / 2;
		 
		 return simMetric;
	 }

	public ArrayList<String> getWordSuggestions(String word, int n, double commonPercent, int topN) {
		// given an incorrect word, return a list of legal word
		// suggestions as per an algorithm given below.
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

		System.out.println(wr.getSimilarityMetric("h", "hello"));
	}
}
