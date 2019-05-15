package br.com.sgcc.core;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface DefaultRepository<T> extends PagingAndSortingRepository<T, Integer> {

	Page<T> findByFilters(Filters filters, Pageable page);
	
	long count(Filters filters);
	
}
