package br.com.sgcc.room.owner;

import java.util.Optional;

import br.com.sgcc.core.Filters;
import lombok.Data;

@Data
public class RoomOwnerFilters implements Filters {

	private Optional<String> company = Optional.empty();
	private Optional<String> building = Optional.empty();
	private Optional<Integer> roomNumber = Optional.empty();
	
	
	public String getCompany() {
		return company.orElse("");
	}
	
	public String getBuilding() {
		return building.orElse("");
	}
	
	public Integer getRoomNumber() {
		return roomNumber.orElse(null);
	}
	
}
