package br.com.sgcc.company;

import static java.util.Optional.empty;

import java.util.Optional;

import br.com.sgcc.core.Filters;
import lombok.Data;

@Data
public class CompanyFilters implements Filters {

	private Optional<String> name = empty();
	private Optional<String> cnpj = empty();
	
	
	public String getName() {
		return name.orElse("");
	}
	
	public String getCnpj() {
		return cnpj.orElse("");
	}
	
}