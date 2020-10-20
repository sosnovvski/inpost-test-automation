package dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrackingDetail {
	public String status;
	@JsonProperty("origin_status")
	public String originStatus;
	public Object agency;
	public Date datetime;
}
