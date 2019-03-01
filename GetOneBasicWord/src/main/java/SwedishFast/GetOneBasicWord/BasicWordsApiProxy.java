package SwedishFast.GetOneBasicWord;

import java.util.List;
import java.util.Random;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;



//@FeignClient(name="BasicWordsApi", url="http://localhost:8001")

@FeignClient(name="BasicWordsApi")
@RibbonClient(name="BasicWordsApi")
public interface BasicWordsApiProxy {
	
	@GetMapping("/OneRandomWord")
	public OneWordBean showOneRandomWord();
	
	
	@GetMapping("/sometime")
	public OneWordBean simpleStuff();

}
	