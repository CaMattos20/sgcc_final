package br.com.sgcc.visit;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import br.com.sgcc.core.DefaultRepository;
import br.com.sgcc.core.Filters;

public interface VisitRepository extends DefaultRepository<Visit> {

	@Query("select p from Visit p "
			+ "where upper(p.company.name) like concat('%', upper(:company), '%') "
			+ " and upper(p.building.name) like concat('%', upper(:building), '%')"
			+ " and upper(p.visitor.name) like concat('%', upper(:visitor), '%')"
			
		)
	Page<Visit> findByFilters(String company, String building, String visitor, Pageable page);

	@Query("select count(*) from Visit p "
			+ "where upper(p.company.name) like concat('%', upper(:company), '%') "
			+ " and upper(p.building.name) like concat('%', upper(:building), '%')"
			+ " and upper(p.visitor.name) like concat('%', upper(:visitor), '%')"
		)
	long count(String company, String building, String visitor);
	
	
	@Override
	default Page<Visit> findByFilters(Filters f, Pageable page) {
		VisitFilters filters = (VisitFilters) f;
		
		return findByFilters(filters.getCompany(), filters.getBuilding(), filters.getVisitor(), page);
	}

	@Override
	default long count(Filters f) {
		VisitFilters filters = (VisitFilters) f;
		
		return count(filters.getCompany(), filters.getBuilding(), filters.getVisitor());
	}
	
	
}
