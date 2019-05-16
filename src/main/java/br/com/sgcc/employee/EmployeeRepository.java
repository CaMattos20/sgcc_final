package br.com.sgcc.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import br.com.sgcc.core.DefaultRepository;
import br.com.sgcc.core.Filters;

public interface EmployeeRepository extends DefaultRepository<Employee> {

	@Query("select p from Employee p "
			+ "where upper(p.person.name) like concat('%', upper(:name), '%') "
			+ "and upper(p.person.document) like concat('%', upper(:document), '%') "
			+ "and upper(p.company.name) like concat('%', upper(:company), '%') "
			+ "and upper(p.status) like concat('%', upper(:status), '%') "
		)
	Page<Employee> findByFilters(String name, String document, String company, String status, Pageable page);

	@Query("select count(*) from Employee p "
			+ "where upper(p.person.name) like concat('%', upper(:name), '%') "
			+ "and upper(p.person.document) like concat('%', upper(:document), '%') "
			+ "and upper(p.company.name) like concat('%', upper(:company), '%') "
			+ "and upper(p.status) like concat('%', upper(:status), '%') "
		)
	long count(String name, String document, String company, String status);
	
	
	@Override
	default Page<Employee> findByFilters(Filters f, Pageable page) {
		EmployeeFilters filters = (EmployeeFilters) f;
		
		return findByFilters(filters.getName(), filters.getDocument(), filters.getCompany(), filters.getStatus(), page);
	}

	@Override
	default long count(Filters f) {
		EmployeeFilters filters = (EmployeeFilters) f;
		
		return count(filters.getName(), filters.getDocument(), filters.getCompany(), filters.getStatus());
	}
}
