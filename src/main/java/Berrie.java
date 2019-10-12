import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

public class Berrie {
	String name;
	Integer size;
	Integer growthTime;
	
	public Berrie(String name, Integer size, Integer growthTime) {
		this.name = name;
		this.size = size;
		this.growthTime = growthTime;
	}
	
	public Berrie(String berrie_url) {
		try {
			URL url = new URL(berrie_url);
			
			HttpURLConnection conn = (HttpURLConnection)url.openConnection(); 

			conn.setRequestMethod("GET"); 
			
			int responsecode = conn.getResponseCode(); 
			
			if(responsecode != 200) {
				throw new RuntimeException();
			}
			
			Scanner sc = new Scanner(url.openStream());
			String inline = "";
			
			while(sc.hasNext()) {
				inline += sc.nextLine();
			}
			sc.close();
						
			JSONObject response = new JSONObject(inline);
			
			name = response.getString("name");
			size = response.getInt("size");
			growthTime = response.getInt("growth_time");
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> getAllBerriesURL() {
		ArrayList<String> urls = new ArrayList<String>();

		String api_endpoint = "https://pokeapi.co/api/v2/berry";
		
		try {
			URL url = new URL(api_endpoint);
			
			HttpURLConnection conn = (HttpURLConnection)url.openConnection(); 

			conn.setRequestMethod("GET"); 
			
			int responsecode = conn.getResponseCode(); 
			
			if(responsecode != 200) {
				throw new RuntimeException();
			}
			
			Scanner sc = new Scanner(url.openStream());
			String inline = "";
			
			while(sc.hasNext()) {
				inline += sc.nextLine();
			}
			sc.close();
						
			JSONObject response = new JSONObject(inline);
			JSONArray results = (JSONArray)response.get("results");
			
			for(int i = 0 ; i < results.length(); i++) {
				JSONObject result = (JSONObject)results.get(i);
				urls.add((String)result.get("url"));
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return urls;
	}
}