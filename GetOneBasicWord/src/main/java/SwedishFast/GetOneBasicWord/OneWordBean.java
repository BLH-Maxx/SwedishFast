package SwedishFast.GetOneBasicWord;

public class OneWordBean {
	
	private String word;

	private String numberoftimes;
	
	private String englishWord;
	
	private String englishExample;
	
	private String swedishExample;
	
	
	public OneWordBean() {
		
	}


	public String getWord() {
		return word;
	}


	public void setWord(String word) {
		this.word = word;
	}


	public String getNumberoftimes() {
		return numberoftimes;
	}


	public void setNumberoftimes(String numberoftimes) {
		this.numberoftimes = numberoftimes;
	}


	public String getEnglishWord() {
		return englishWord;
	}


	public void setEnglishWord(String englishWord) {
		this.englishWord = englishWord;
	}


	public String getEnglishExample() {
		return englishExample;
	}


	public void setEnglishExample(String englishExample) {
		this.englishExample = englishExample;
	}


	public String getSwedishExample() {
		return swedishExample;
	}


	public void setSwedishExample(String swedishExample) {
		this.swedishExample = swedishExample;
	}


	public OneWordBean(String word, String numberoftimes, String englishWord, String englishExample,
			String swedishExample) {
		this.word = word;
		this.numberoftimes = numberoftimes;
		this.englishWord = englishWord;
		this.englishExample = englishExample;
		this.swedishExample = swedishExample;
	}


	@Override
	public String toString() {
		return "OneWordBean [word=" + word + ", numberoftimes=" + numberoftimes + ", englishWord=" + englishWord
				+ ", englishExample=" + englishExample + ", swedishExample=" + swedishExample + "]";
	}

	
	

}
