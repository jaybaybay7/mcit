
public class WordPairs {
	private String word;
	private Double score;
	
	/*
	 * @params word1, score 1
	 * 
	 * This constructor is used like a {K,V} pair but maintains order unlike a HashMap
	 */
	
	public WordPairs(String word1, Double score1) {
		this.word = word1;
		this.score = score1;
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
	public Double getScore() {
		return score;
	}

	
	/*
	 * Sets score
	 */
	public void setScore(Double score) {
		this.score = score;
	}
}

	
