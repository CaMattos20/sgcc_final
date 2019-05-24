package br.com.sgcc.expenses;

import java.util.Optional;

import br.com.sgcc.core.Filters;
import lombok.Data;

@Data
public class ExpensesFilters implements Filters {

	private Optional<Integer> month = Optional.empty();
	private Optional<Integer> year = Optional.empty();
	

	public Integer getMonth() {
		return month.orElse(null);
	}

	public Integer getYear() {
		return year.orElse(null);
	}
	
}
