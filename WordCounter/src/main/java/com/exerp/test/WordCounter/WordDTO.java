package com.exerp.test.WordCounter;
/**
 * 
 * @author Minu M Murukesan
 *
 */
public class WordDTO {

	private String word;
	private int count;

	/**
	 * Constructor
	 * @param word
	 * @param count
	 */
	public WordDTO(String word, int count) {
		super();
		this.word = word;
		this.count = count;
	}
	/**
	 * @return Word
	 */
	public String getWord() {
		return word;
	}
	/**
	 * @param word
	 */
	public void setWord(String word) {
		this.word = word;
	}
	/**
	 * @return count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count
	 */
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordDTO other = (WordDTO) obj;
		if (count != other.count)
			return false;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

}
