package SwedishFast.BasicWordsApi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicWordRegularController {
	
	@GetMapping("/api")
	public String index(Model model) {
		
		
		return "ApiDocs";
	}

}
