package api;

public class RestService {
	private IParcelTrackingService parcelTrackingService;

	public static RestService getRestService() {
		return new RestService();
	}

	public RestService() {
		parcelTrackingService = new ParcelTrackingService();

	}

	public IParcelTrackingService getParcelService() {
		return parcelTrackingService;
	}

}