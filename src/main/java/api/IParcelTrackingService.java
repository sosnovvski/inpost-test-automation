package api;

import java.io.IOException;

import dto.Parcel;

public interface IParcelTrackingService {
	String getParcelTrackingStatus(String parcelNumber) throws IOException;

	Parcel getAllInformationAboutParcelTracking(String parcelNumber) throws IOException;
}
