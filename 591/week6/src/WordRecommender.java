import java.io.File;
import java.io.FileNotFoundException;
import java.security.KeyStore.Entry;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

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

		// w1r is now word1 backwards
		w1r.append(word1);
		w1r.reverse();

		// w2r is now word2 backwards
		w2r.append(word2);
		w2r.reverse();

		// Left to right letter check
		for (int i = 0; i < returnShorterWord(word1, word2).length(); i++) {
			if (word1.charAt(i) == word2.charAt(i)) {
				leftSim++;
			}
		}

		// righjt to left letter check
		for (int j = 0; j < returnShorterWord(word1, word2).length(); j++) {
			if (w1r.charAt(j) == w2r.charAt(j)) {
				rightSim++;
			}
		}

		double simMetric = (Double.valueOf(leftSim) + Double.valueOf(rightSim)) / 2.0;

		return simMetric;
	}

	/*
	 * given an incorrect word, return a list of legal word suggestions as per an
	 * algorithm
	 */

	public ArrayList<String> getWordSuggestions(String word, int n, double commonPercent, int topN) {

		// Defining all the variables needed
		String testWord = word.toLowerCase();
		int testWordLength = word.length();
		int upperBoundWordLength = testWordLength + n;
		int lowerBoundWordLength = testWordLength - n;

		// wordListReturn will be returned as the words to replace the misspelled word
		ArrayList<String> wordListReturn = new ArrayList<String>();

		// WordListFinal is the final returned list of values for this method.
		ArrayList<String> wordListFinal = new ArrayList<String>();
		ArrayList<String> wordListTemp = new ArrayList<String>();
		ArrayList<String> word1Chars = new ArrayList<String>();
		ArrayList<String> word2Chars = new ArrayList<String>();
		DecimalFormat df = new DecimalFormat("#.00");
		int counter = 0;
		double counterProb = 0.00;

		// making engDictionary import work
		File input = new File("engDictionary.txt");

		// pulling each character of the input word into a arraylist

		for (int i = 0; i < testWordLength; i++) {
			word1Chars.add(Character.toString(testWord.charAt(i)));
		}

		// Remove duplicate letters from word
		LinkedHashSet<String> hs1 = new LinkedHashSet<String>(word1Chars);
		ArrayList<String> word1CharsNoDups = new ArrayList<String>(hs1);

		// Open up dictionary file and read in each word. Build an arraylist of each
		// word's characters
		try {
			Scanner s = new Scanner(input);

			while (s.hasNext()) {
				String nextWord = s.next();

				// creating an arraylist with all words that are of in between the + or - length
				// of word
				if (lowerBoundWordLength <= nextWord.length() && nextWord.length() <= upperBoundWordLength) {
					wordListTemp.add(nextWord);
				}
			}

			// iterate over the list and grab each word and turn chars into an array.
			// Reset Counter
			for (int i = 0; i < wordListTemp.size(); i++) {
				String tempWord = wordListTemp.get(i);
				counter = 0;
				word2Chars.clear();

				for (int j = 0; j < tempWord.length(); j++) {
					word2Chars.add(Character.toString(tempWord.charAt(j)));
				}

				// Removing dups. Then turning back into arraylist
				LinkedHashSet<String> hs2 = new LinkedHashSet<String>(word2Chars);
				ArrayList<String> word2CharsNoDups = new ArrayList<String>(hs2);

				// Still inside the for loop. Check against the probability and if true, then
				// add to wordListReturn.

				if (word2CharsNoDups.size() >= word1CharsNoDups.size()) {

					for (int k = 0; k < word1CharsNoDups.size(); k++) {
						for (int q = 0; q < word2CharsNoDups.size(); q++) {
							if (word1CharsNoDups.get(k).equals(word2CharsNoDups.get(q))) {
								counter = counter + 1;
							}
						}

					}
					counterProb = counter / (double) word2CharsNoDups.size();

					if (counterProb >= commonPercent) {
						wordListReturn.add(tempWord);
					}

				} else {
					for (int m = 0; m < word2CharsNoDups.size(); m++) {
						for (int r = 0; r < word1CharsNoDups.size(); r++) {
							if (word1CharsNoDups.get(r).equals(word2CharsNoDups.get(m))) {
								counter = counter + 1;
							}
						}

					}

					counterProb = counter / (double) word1CharsNoDups.size();

					if (counterProb >= commonPercent) {
						wordListReturn.add(tempWord);

					}
				}

			}

			s.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creating an arraylist to store sim values of the wordListReturn objects
		ArrayList<Double> simArray = new ArrayList<Double>();

		// Created new class to hold string, double value for testing
		ArrayList<WordPairs> newList = new ArrayList<WordPairs>();

		// create an array with the simMetric results
		for (String w : wordListReturn) {
			double simIntTemp = getSimilarityMetric(word, w);
			simArray.add(simIntTemp);
		}

		// combining the words and the simMetric doubles together into WordPairs
		for (int i = 0; i < wordListReturn.size(); i++) {
			WordPairs wp = new WordPairs(wordListReturn.get(i), simArray.get(i));
			newList.add(wp);
		}

		// NewList is now sorted in descending order by its value
		for (int i = 0; i < newList.size(); i++) {
			for (int j = i + 1; j < newList.size(); j++) {
				Double temp = 0.00;
				String tempW = "";
				if (newList.get(i).getScore() < newList.get(j).getScore()) {
					temp = newList.get(i).getScore();
					tempW = newList.get(i).getWord();

					newList.get(i).setScore(newList.get(j).getScore());
					newList.get(i).setWord(newList.get(j).getWord());

					newList.get(j).setScore(temp);
					newList.get(j).setWord(tempW);
				}
			}
		}

		// this is just to catch errors with one letter words that are not present in
		// the dictionary.
		ArrayList<String> outOfBoundsChecker = new ArrayList<String>();
		outOfBoundsChecker.add("0");

		if (newList.size() == 0) {
			return outOfBoundsChecker;
		}

		// create the final Arraylist to send to WordRunner.
		for (int i = 0; i < topN; i++) {
			wordListFinal.add(newList.get(i).getWord());
		}
		return wordListFinal;

	}

	public ArrayList<String> getWordsWithCommonLetters(String word, ArrayList<String> listOfWords, int n) {
		// Given a word and a list of words from a dictionary, return the list of words
		// in the dictionary that
		// have at least (>=) n letters in common.

		String testWord = word.toLowerCase();
		int testWordLength = word.length();
		ArrayList<String> wordList = new ArrayList<String>();
		ArrayList<String> wordCharList = new ArrayList<String>();

		// Create an list with the characters from the word for testing against
		for (int i = 0; i < testWord.length(); i++) {
			wordCharList.add(Character.toString(testWord.charAt(i)));
		}

		LinkedHashSet<String> hm1 = new LinkedHashSet<String>(wordCharList);
		ArrayList<String> wordCharsNoDups = new ArrayList<String>(hm1);

		// This section produces a list of the chars of each word (no duplicates)
		ArrayList<ArrayList<String>> listOfLists = new ArrayList<ArrayList<String>>();
		ArrayList<String> charsFromWords = new ArrayList<String>();

		for (int i = 0; i < listOfWords.size(); i++) {
			for (int j = 0; j < listOfWords.get(i).length(); j++) {
				charsFromWords.add(Character.toString(listOfWords.get(i).charAt(j)));
			}

			LinkedHashSet<String> hm = new LinkedHashSet<String>(charsFromWords);

			ArrayList<String> hmNoDups = new ArrayList<String>(hm);

			listOfLists.add(hmNoDups);
			charsFromWords.clear();
		}

		ArrayList<WordPairsInt> alwp = new ArrayList<WordPairsInt>();
		WordPairsInt wp = new WordPairsInt("", 0);

		// section starting to count the number of equal letters (listWithoutDups,
		// listOfLists[]
		int counter = 0;

		for (int i = 0; i < listOfWords.size(); i++) {
			int length = returnShortLength(word, listOfLists.get(i));

			int counter1 = 0;
			for (int j = 0; j < length; j++) {
				if (wordCharsNoDups.get(i).equals(listOfLists.get(i).get(j))) {
					counter1 = counter1 + 1;
				}
			}
			wp.setWord(listOfWords.get(i));
			wp.setScore(counter1);
			alwp.add(wp);
			counter1 = 0;
		}

		// todo, scoring is not right

		ArrayList<String> finalWords = new ArrayList<String>();

		for (int i = 0; i < alwp.size(); i++) {
			if (alwp.get(i).getScore() >= n) {
				finalWords.add(alwp.get(i).getWord());
			}
		}

		return finalWords;

	}

	public int returnShortLength(String word, ArrayList<String> list) {
		if (word.length() < list.size()) {
			return word.length();
		}
		return list.size();
	}

	public String prettyPrint(ArrayList<String> list) {
		String y = "";
		for (int i = 0; i < list.size(); i++) {
			String n = (i + 1 + "." + " " + list.get(i) + "\n");
			y = y + n;
		}
		return y;
	}

	public String getFileName() {
		return this.filename;
	}

}
