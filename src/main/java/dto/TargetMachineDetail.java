package dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TargetMachineDetail {
	public String name;
	@JsonProperty("opening_hours")
	public String opening_hours;
	@JsonProperty("location_description")
	public String location_description;
	public Location location;
	public Address address;
	public List<String> type;
	@JsonProperty("location247")
	public boolean isLocation24on7;
}
