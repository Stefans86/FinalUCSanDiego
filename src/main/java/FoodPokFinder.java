import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

public class FoodPokFinder {

	static String rootURL = "https://pokeapi.co/api/v2/berry/";

	static String connecting(String URL) throws MalformedURLException, IOException {
		URL request = new URL(URL);
		InputStream openStream = request.openStream();
		String response = IOUtils.toString(openStream);

		return response;

	}

	static ArrayList<Berry> BerriesApi() throws MalformedURLException, IOException {

		JSONObject root = new JSONObject(connecting(rootURL));

		int numberOfBerries = (int) root.get("count");

		ArrayList<Berry> PokeBerries = new ArrayList<Berry>();
		for (int i = 1; i <= numberOfBerries; i++) {

			rootURL += Integer.toString(i) + "/";
			JSONObject r = new JSONObject(connecting(rootURL));

			String name = (String) r.get("name");
			int growthTime = (int) r.get("growth_time");
			int size = (int) r.get("size");

			PokeBerries.add(new Berry(name, growthTime, size));

			rootURL = "https://pokeapi.co/api/v2/berry/";
		}
		return PokeBerries;

	}

	static ArrayList<Berry> createListOfBerriesWithShortestGrowthTime(ArrayList<Berry> PokeBerries) {

		Collections.sort(PokeBerries, (pb1, pb2) -> pb1.BerryGrowTime - pb2.BerryGrowTime);
		int MinGrowthTime = PokeBerries.get(0).BerryGrowTime;
		ArrayList<Berry> berriesWithShortestGrowthTime = new ArrayList<Berry>();
		for (int i = 0; i < PokeBerries.size(); i++) {
			if (PokeBerries.get(i).BerryGrowTime == MinGrowthTime) {
				berriesWithShortestGrowthTime.add(PokeBerries.get(i));
			}

		}
		return berriesWithShortestGrowthTime;
	}

	static ArrayList<Berry> arrangeBerriesWithShortestGrowthTimeBySize(ArrayList<Berry> berriesWithShortestGrowthTime) {
		Collections.sort(berriesWithShortestGrowthTime, (pb1, pb2) -> pb2.BerrySize - pb1.BerrySize);
		return berriesWithShortestGrowthTime;
	}

	public static void main(String[] args) throws IOException {

		ArrayList<Berry> berries = BerriesApi();
		ArrayList<Berry> berriesWithShortestGrowthTime = createListOfBerriesWithShortestGrowthTime(berries);
		arrangeBerriesWithShortestGrowthTimeBySize(berriesWithShortestGrowthTime);

		System.out.println("The biggest Berry you can grow in shortest time is: " + berriesWithShortestGrowthTime.get(0).BerryToString()
				+ "\n It's colosal !!! Snorlax will be happy to eat it,if he ever wakes up :( ");

	}

}