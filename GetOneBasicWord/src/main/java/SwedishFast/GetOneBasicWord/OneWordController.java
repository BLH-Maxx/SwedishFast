package SwedishFast.GetOneBasicWord;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mashape.unirest.http.exceptions.UnirestException;

@Controller
public class OneWordController {

	@Autowired
	private BasicWordsApiProxy proxy;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private OneWordBean response;

	@GetMapping("/getaword")
	public String ReturningOneWordFeign(Model model) {
		
		response = proxy.showOneRandomWord();

		model.addAttribute("name", response.getWord());

		return "oneword";
	}
	
	
	@GetMapping("/translated")
	public String translatingWord(Model model) throws IOException {

		String translatedWord = methods.makeTranslation(response.getWord(), "sv", "en");
		
			
		model.addAttribute("swedishWord", response.getWord());
		model.addAttribute("englishWord", translatedWord);
		
		response.setEnglishWord(translatedWord);
		return "translated";
	}
	
	@GetMapping("/fullinfo")
	public String gettingFullInfo(Model model) throws IOException, UnirestException {
		
		String englishExample = methods.getSentenceExample(response.getEnglishWord());
		response.setEnglishExample(englishExample.replaceAll("\"", "").replaceAll(".", ""));
		
		
				
		//String swedishExample = methods.makeTranslation(response.getEnglishExample(), "en", "sv");

		model.addAttribute("svWord", response.getWord());
		model.addAttribute("enWord", response.getEnglishWord());
		//model.addAttribute("svExample", swedishExample);
		model.addAttribute("enExample", englishExample);

		return "fullinfo";
	}
	

	/*
	 * @GetMapping("/oneWordFeign") //public OneWordBean ReturningOneWordFeign() {
	 * // response = proxy.showOneRandomWord();
	 * 
	 * return new OneWordBean(response.getWord(),response.getNumberoftimes());
	 * 
	 * }
	 */

}
