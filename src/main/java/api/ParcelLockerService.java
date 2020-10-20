package api;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

import dto.Item;
import dto.ParcelLocker;

public class ParcelLockerService implements IParcelLockerService {
	private static final String BASE_URL = "https://inpost.pl/SzybkieNadania/v1/api/points?query=Krak%C3%B3w&type=standard_parcel_send&page=1&perPage=";

	@Override
	public List<String> getParcelLockerInfo(int perPage) throws IOException {
		InputStream response = fetchInputStream(perPage);
		ObjectMapper mapper = new ObjectMapper();
		ParcelLocker parcelLocker = mapper.readValue(response, ParcelLocker.class);
		return parcelLocker.getItems().stream().map(this::lol).collect(Collectors.toList());
	}

	private InputStream fetchInputStream(int perPage) throws IOException {
		URL url = new URL(BASE_URL + perPage);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("accept", "application/json");
		connection.setRequestProperty("X-Requested-With", "XMLHttpRequest");
		return connection.getInputStream();
	}

	private String lol(Item item) {
		String itemName = item.getName().
				substring(item.getName().indexOf("Kraków"), item.getName().lastIndexOf('\n')).replace('\n', ' ');
		return itemName + ' ' + item.getId();
	}
}
