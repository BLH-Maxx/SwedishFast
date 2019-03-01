package SwedishFast.BasicWordsApi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Basicwords {
	
	@Id
	private String word;
	private String numberoftimes;
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
	public Basicwords(String word, String numberoftimes) {
		this.word = word;
		this.numberoftimes = numberoftimes;
	}
	
	public Basicwords() {
		
	}
	@Override
	public String toString() {
		return "BasicSwedishWords [word=" + word + ", numberoftimes=" + numberoftimes + "]";
	}
	

}
