package br.com.sgcc.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import br.com.sgcc.core.DefaultRepository;
import br.com.sgcc.core.Filters;

public interface EmployeeRepository extends DefaultRepository<Employee> {

	@Query("select p from Employee p "
			+ "where upper(p.name) like concat('%', upper(:name), '%') "
			+ "and upper(p.document) like concat('%', upper(:document), '%') "
			+ "and upper(p.company.name) like concat('%', upper(:company), '%') "
			
		)
	Page<Employee> findByFilters(String name, String document, String company, Pageable page);

	@Query("select count(*) from Employee p "
			+ "where upper(p.name) like concat('%', upper(:name), '%') "
			+ "and upper(p.document) like concat('%', upper(:document), '%') "
			+ "and upper(p.company.name) like concat('%', upper(:company), '%') "
			
		
		)
	long count(String name, String document, String company);
	
	
	@Override
	default Page<Employee> findByFilters(Filters f, Pageable page) {
		EmployeeFilters filters = (EmployeeFilters) f;
		
		return findByFilters(filters.getName(), filters.getDocument(), filters.getCompany(), page);
	}

	@Override
	default long count(Filters f) {
		EmployeeFilters filters = (EmployeeFilters) f;
		
		return count(filters.getName(), filters.getDocument(), filters.getCompany());
	}
}
