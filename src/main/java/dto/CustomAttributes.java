package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomAttributes {
	public String size;
	@JsonProperty("target_machine_id")
	public String targetMachineId;
	@JsonProperty("target_machine_detail")
	public TargetMachineDetail targetMachineDetail;
	@JsonProperty("end_of_week_collection")
	public boolean endOfWeekCollection;
}
