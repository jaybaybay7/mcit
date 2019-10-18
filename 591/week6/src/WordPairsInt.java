
public class WordPairsInt {

	private String word;
	private int score;
	
	/*
	 * @params word1, score 1
	 * 
	 * This constructor is used like a {K,V} pair but maintains order unlike a HashMap
	 * 
	 */
	
	public WordPairsInt(String word1, int score2) {
		this.word = word1;
		this.score = score2;
	}

	/*
	 * Returns word
	 */
	public String getWord() {
		return word;
	}
	
	/*
	 * sets word
	 */

	public void setWord(String word) {
		this.word = word;
	}

	
	/*
	 * Returns score
	 */
	public int getScore() {
		return score;
	}

	
	/*
	 * Sets score
	 */
	public void setScore(int score) {
		this.score = score;
	}
}

	
