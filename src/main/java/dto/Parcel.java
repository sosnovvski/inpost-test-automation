package dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Parcel {
	@JsonProperty("tracking_number")
	public String trackingNumber;
	public String service;
	public String type;
	public String status;
	@JsonProperty("custom_attributes")
	public CustomAttributes customAttributes;
	@JsonProperty("tracking_details")
	public List<TrackingDetail> trackingDetails;
	@JsonProperty("expected_flow")
	public List<Object> expectedFlow;
	@JsonProperty("created_at")
	public Date createdAt;
	@JsonProperty("updated_at")
	public Date updatedAt;
}
