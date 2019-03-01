package SwedishFast.GetOneBasicWord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class methods {
	
	public static String makeTranslation(String svWord, String fLenguage, String sLenguage) throws IOException {
		
		
		StringBuffer response = new StringBuffer();
		String finalResponse;
		URL mMUrl = new URL("https://api.mymemory.translated.net/get?q=" + svWord + "!&langpair=" + fLenguage + "|" + sLenguage);
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
		finalResponse = response.toString().replace("!", "");

		try {
			final JSONObject json = (JSONObject) new JSONParser().parse(finalResponse);
			final JSONObject data = (JSONObject) json.get("responseData");
			finalResponse = data.get("translatedText").toString();
		} catch (final Exception e) {
			return null;
		}
	
		return finalResponse;
	}
	
	
	
	public static String getSentenceExample(String englishExampleWord) throws UnirestException {

		// Cambiar la calabra "cook" en el call del api
		HttpResponse<JsonNode> response = Unirest.get("https://wordsapiv1.p.rapidapi.com/words/" + englishExampleWord + "/examples")
				.header("X-RapidAPI-Key", "key").asJson();

		JSONArray node = response.getBody().getObject().getJSONArray("examples");

		String[] node1 = node.toString().split(",");
		String exampleHolder = node1[0].replace("[", "").replace("]", "");
		
		
		return exampleHolder;

	}

	

}
