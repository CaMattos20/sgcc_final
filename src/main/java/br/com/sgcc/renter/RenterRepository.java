package br.com.sgcc.renter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import br.com.sgcc.core.DefaultRepository;
import br.com.sgcc.core.Filters;

public interface RenterRepository extends DefaultRepository<Renter> {

	@Query("select p from Renter p "
			+ "where upper(p.company.name) like concat('%', upper(:company), '%') "
			+ " and upper(p.building.name) like concat('%', upper(:building), '%')"
			
		)
	Page<Renter> findByFilters(String company, String building, Pageable page);

	@Query("select count(*) from Renter p "
			+ "where upper(p.company.name) like concat('%', upper(:company), '%') "
			+ " and upper(p.building.name) like concat('%', upper(:building), '%')"
		)
	long count(String company, String building);
	
	
	@Override
	default Page<Renter> findByFilters(Filters f, Pageable page) {
		RenterFilters filters = (RenterFilters) f;
		
		return findByFilters(filters.getCompany(), filters.getBuilding(), page);
	}

	@Override
	default long count(Filters f) {
		RenterFilters filters = (RenterFilters) f;
		
		return count(filters.getCompany(), filters.getBuilding());
	}
	
	
}
