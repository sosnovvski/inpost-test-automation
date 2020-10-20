package api;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import dto.Parcel;

public class ParcelTrackingService implements IParcelTrackingService {
	private static final String BASE_URL = "https://inpost.pl/shipx-proxy/?number=";

	@Override
	public String getParcelTrackingStatus(String parcelNumber) throws IOException {
		InputStream response = fetchInputStream(parcelNumber);
		ObjectMapper mapper = new ObjectMapper();
		HashMap lol = mapper.readValue(response, HashMap.class);
		if (lol.get("status") != null) {
			return lol.get("status").toString();
		} else {
			return lol.get("message").toString();
		}
	}

	@Override
	public Parcel getAllInformationAboutParcelTracking(String parcelNumber) throws IOException {
		InputStream response = fetchInputStream(parcelNumber);
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(response, Parcel.class);

	}

	private InputStream fetchInputStream(String parcelNumber) throws IOException {
		URL url = new URL(BASE_URL + parcelNumber);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("accept", "application/json");
		connection.setRequestProperty("X-Requested-With", "XMLHttpRequest");
		return connection.getInputStream();
	}
}
