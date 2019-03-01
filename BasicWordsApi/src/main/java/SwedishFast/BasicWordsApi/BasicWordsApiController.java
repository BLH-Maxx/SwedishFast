package SwedishFast.BasicWordsApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@RestController
public class BasicWordsApiController {

	@Autowired
	private BasicSwedishWordsRepo bsw;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/basicwords")
	public List<Basicwords> showAllWords() {

		return bsw.findAllByOrderByNumberoftimesDesc();
	}

	// getting a random basic word
	// the logic is outside the query because we can have a high number of elements
	// in the
	// DB
	@GetMapping("/OneRandomWord")
	public Basicwords showOneRandomWord() {

		List<Basicwords> findAll = bsw.findAll();
		Random rand = new Random();
		Basicwords randomWord = findAll.get(rand.nextInt(findAll.size()));
		
		logger.info("{}");

		return randomWord;

	}
	

	@GetMapping("/SpecificRandomWords/{Ntimes}")
	public List<Basicwords> ShowSpecificNumberOfWords(@PathVariable int Ntimes) {

		List<Basicwords> findAll = bsw.findAll();
		List<Basicwords> ReturnedValue = new ArrayList<>();

		for (int x = 0; x < Ntimes; x++) {

			Random rand = new Random();
			Basicwords randomWord = findAll.get(rand.nextInt(findAll.size()));
			ReturnedValue.add(randomWord);
		}

		return ReturnedValue;

	}

	/*
	
	@GetMapping("/try")
	public String Try() throws UnirestException {

		// Cambiar la calabra "cook" en el call del api
		HttpResponse<JsonNode> response = Unirest.get("https://wordsapiv1.p.rapidapi.com/words/cook/examples")
				.header("X-RapidAPI-Key", "key").asJson();

		JSONArray node = response.getBody().getObject().getJSONArray("examples");

		String[] node1 = node.toString().split(",");

		return node1[1];

	}

	@GetMapping("/try1")
	public String Try1() throws UnirestException, IOException {

		StringBuffer response = new StringBuffer();
		String finalResponse;
		URL mMUrl = new URL("https://api.mymemory.translated.net/get?q=och!&langpair=sv|en");
		String readLine = null;
		HttpURLConnection conection = (HttpURLConnection) mMUrl.openConnection();
		conection.setRequestMethod("GET");
		int responseCode = conection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));			
			while ((readLine = in.readLine()) != null) {
				response.append(readLine);
			}
			in.close();
		} 
		finalResponse = response.toString();

		try {
			final JSONObject json = (JSONObject) new JSONParser().parse(finalResponse);
			final JSONObject data = (JSONObject) json.get("responseData");
			finalResponse = data.get("translatedText").toString();
		} catch (final Exception e) {
			return null;
		}
		
	
		return finalResponse;

	}
	*/

}
