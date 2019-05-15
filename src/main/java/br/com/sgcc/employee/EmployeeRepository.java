package br.com.sgcc.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import br.com.sgcc.core.DefaultRepository;
import br.com.sgcc.core.Filters;

public interface EmployeeRepository extends DefaultRepository<Employee> {

	@Query("select p from Employee p "
			+ "where upper(p.person.name) like concat('%', upper(:name), '%') "
			+ "and upper(p.person.document) like concat('%', upper(:document), '%') ")
	Page<Employee> findByFilters(String name, String document, Pageable page);

	@Query("select count(*) from Employee p "
			+ "where upper(p.person.name) like concat('%', upper(:name), '%') "
			+ "and upper(p.person.document) like concat('%', upper(:document), '%') "
		)
	long count(String name, String document);
	
	
	@Override
	default Page<Employee> findByFilters(Filters f, Pageable page) {
		EmployeeFilters filters = (EmployeeFilters) f;
		
		return findByFilters(filters.getName(), filters.getDocument(), page);
	}

	@Override
	default long count(Filters f) {
		EmployeeFilters filters = (EmployeeFilters) f;
		
		return count(filters.getName(), filters.getDocument());
	}
}
