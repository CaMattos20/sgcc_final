package br.com.sgcc.expenses;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import br.com.sgcc.core.DefaultRepository;
import br.com.sgcc.core.Filters;

public interface ExpensesRepository extends DefaultRepository<Expenses> {

	@Query("select p from Expenses p "
			+ " where month = COALESCE(:month, month) "
			+ " and year = COALESCE(:year, year) "
		)
	Page<Expenses> findByFilters(Integer month, Integer year, Pageable page);

	@Query("select count(*) from Expenses p "
			+ " where month = COALESCE(:month, month) "
			+ " and year = COALESCE(:year, year) "
		)
	long count(Integer month, Integer year);
	
	
	@Override
	default Page<Expenses> findByFilters(Filters f, Pageable page) {
		ExpensesFilters filters = (ExpensesFilters) f;
		
		return findByFilters(filters.getMonth(), filters.getYear(), page);
	}

	@Override
	default long count(Filters f) {
		ExpensesFilters filters = (ExpensesFilters) f;
		
		return count(filters.getMonth(), filters.getYear());
	}
	
	
}
