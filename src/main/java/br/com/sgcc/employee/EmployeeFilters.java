package br.com.sgcc.employee;

import java.util.Optional;

import br.com.sgcc.core.Filters;
import lombok.Data;

@Data
public class EmployeeFilters implements Filters {

	private Optional<String> name = Optional.empty();
	private Optional<String> company = Optional.empty();
	private Optional<String> document = Optional.empty();
	private Optional<String> status = Optional.empty();
	
	
	public String getName() {
		return name.orElse("");
	}
	
	public String getCompany() {
		return company.orElse("");
	}
	
	public String getDocument() {
		return document.orElse("");
	}
	
	public String getStatus() {
		return status.orElse("");
	}
	
}
