import java.io.File;
import java.io.FileNotFoundException;
import java.security.KeyStore.Entry;
import java.text.DecimalFormat;
import java.util.*;

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
		File input = new File("./engDictionary.txt");

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

		// Create a hashmap with wordListReturn and then sort by similarity. Append to
		// final list
		LinkedHashMap<String, Double> hm = new LinkedHashMap<String, Double>();

		for (String w : wordListReturn) {
			double simIntTemp = getSimilarityMetric(word, w);
			simArray.add(simIntTemp);
		}

		for (int i = 0; i < wordListReturn.size(); i++) {
			hm.put(wordListReturn.get(i), simArray.get(i));
		}

		// System.out.println(hm);

		// Need to figure out the sorting thing. Maybe convert this hash into a new list
		// somehow?
		Map<String, Double> map = new TreeMap<String, Double>(hm);
		LinkedHashMap<String, Double> sortedMap = new LinkedHashMap<String, Double>();

		ArrayList<String> outOfBoundsChecker = new ArrayList<String>();
		outOfBoundsChecker.add("0");

		if (map.size() == 0) {
			return outOfBoundsChecker;
		} else {

			for (int i = 0; i < map.size(); i++) {
				for (int j = 0; j < map.size(); j++) {
					String temp = "";
					if ((Double) map.values().toArray()[i] > (Double) map.values().toArray()[j]) {
						temp = String.valueOf(map.values().toArray()[i]);
						map.values().toArray()[i] = map.values().toArray()[j];
						map.values().toArray()[i] = temp;
					}
				}
			}
		}

		// Set set = map.entrySet();
		// Iterator iterator = set.iterator();
		// while(iterator.hasNext()) {

		// sortedMap.put(String.valueOf(me.getKey()), (Double) me.getValue());
		/*
		 * 
		 * 
		 * if (topN == 0) { return outOfBoundsChecker; }
		 */

		for (int i = 0; i < topN; i++) {
			wordListFinal.add(String.valueOf(map.keySet().toArray()[i]));
		}
		return wordListFinal;

	}

	public ArrayList<String> getWordsWithCommonLetters(String word, ArrayList<String> listOfWords, int n) {
//		 /Given a word and a list of words from a dictionary, return the list of words in the dictionary that
		// have at least (>=) n letters in common.
		// todo

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

	public static void main(String[] args) {
		WordRecommender wr = new WordRecommender("wordtedster_good");

		System.out.println(wr.getWordSuggestions("hell", 2, 0.75, 2));
	}
}
