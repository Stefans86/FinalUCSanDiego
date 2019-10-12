import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

public class BerryHelper {

	public static String getBerry(int id) throws IOException {
		String berriesURL = GottaCatchEmAll.getBerriesURL() + id + "/";
		URL request = new URL(berriesURL);
		InputStream openStream = request.openStream();
		String response = IOUtils.toString(openStream, "UTF-8");
		JSONObject body = new JSONObject(response);

		return "Berry " + body.getString("name") + " is the largest berry (size = " + body.getInt("size")
				+ ") you can grow in the shortest time (" + body.getInt("growth_time") + "h).";
	}

	public static int findMinTime(List<Berry> berries) {
		return berries.stream().min(Comparator.comparingInt(Berry::getGrowthTime)).get().getGrowthTime();
	}

	public static int findMaxSizeBerry() throws IOException {
		List<Berry> berries = GottaCatchEmAll.collectBerries();
		int minTime = findMinTime(berries);
		return berries.stream().filter(berry -> berry.getGrowthTime() == minTime)
				.max(Comparator.comparingInt(Berry::getSize)).get().getId();

	}
}