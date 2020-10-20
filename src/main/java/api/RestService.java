package api;

public class RestService {
	private IParcelTrackingService parcelTrackingService;
	private IParcelLockerService parcelLockerService;

	public static RestService getRestService() {
		return new RestService();
	}

	public RestService() {
		parcelTrackingService = new ParcelTrackingService();
		parcelLockerService = new ParcelLockerService();
	}

	public IParcelTrackingService getParcelService() {
		return parcelTrackingService;
	}

	public IParcelLockerService getParcelLockerService() {
		return parcelLockerService;
	}
}