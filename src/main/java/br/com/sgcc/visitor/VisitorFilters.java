package br.com.sgcc.visitor;

import java.util.Optional;

import br.com.sgcc.core.Filters;
import lombok.Data;

@Data
public class VisitorFilters implements Filters {

	private Optional<String> name;
	private Optional<String> email;
	private Optional<String> type; 
	private Optional<String> phoneNumber;
	private Optional<String> document;
	
	
	public VisitorFilters() {
		name = Optional.empty();
		email = Optional.empty();
		type = Optional.empty();
		phoneNumber = Optional.empty();
		document = Optional.empty();
	}

	
	public String getName() {
		return name.orElse("");
	}
	
	public String getEmail() {
		return email.orElse("");
	}
	
	public String getType() {
		return type.orElse("");
	}
	
	public String getPhoneNumber() {
		return phoneNumber.orElse("");
	}
	
	public String getDocument() {
		return document.orElse("");
	}
	
	
}
