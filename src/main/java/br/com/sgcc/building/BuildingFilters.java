package br.com.sgcc.building;

import java.util.Optional;

import br.com.sgcc.core.Filters;
import lombok.Data;

@Data
public class BuildingFilters implements Filters {

	private Optional<String> name = Optional.empty();
	
	
	public String getName() {
		return name.orElse("");
	}
	
}
