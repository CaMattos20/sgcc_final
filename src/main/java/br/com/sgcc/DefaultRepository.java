package br.com.sgcc;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DefaultRepository<T> {

	Page<T> findByFilters(Filters filters, Pageable page);
	
	long count(Filters filters);
	
}
