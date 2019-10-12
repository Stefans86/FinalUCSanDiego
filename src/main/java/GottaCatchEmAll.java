import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

public class GottaCatchEmAll {
	static final int numberOfBerries = 64;
	static final String berriesURL = "https://pokeapi.co/api/v2/berry/";

	public static List<Berry> collectBerries() throws IOException {
		List<Berry> berries = new ArrayList<Berry>();

		for (int i = 0; i < numberOfBerries; i++) {
			URL request = new URL(berriesURL + (i + 1) + "/");
			InputStream openStream = request.openStream();
			String response = IOUtils.toString(openStream, "UTF-8");
			JSONObject body = new JSONObject(response);
			berries.add(
					new Berry(body.getInt("id"), response, response, body.getInt("growth_time"), body.getInt("size")));
		}
		return berries;
	}

	public static String getBerriesURL() {
		return berriesURL;
	}

}