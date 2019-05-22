package br.com.sgcc.visit;

import java.util.Optional;

import br.com.sgcc.core.Filters;
import lombok.Data;

@Data
public class VisitFilters implements Filters {

	private Optional<String> person = Optional.empty();
	private Optional<String> company = Optional.empty();
	private Optional<String> building = Optional.empty();
	private Optional<Integer> roomNumber = Optional.empty();

	
	public String getPerson() {
		return person.orElse("");
	}
	
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
