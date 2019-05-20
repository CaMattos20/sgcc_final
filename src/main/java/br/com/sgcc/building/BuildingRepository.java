package br.com.sgcc.building;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import br.com.sgcc.core.DefaultRepository;
import br.com.sgcc.core.Filters;

public interface BuildingRepository extends DefaultRepository<Building> {

	@Query("select p from Building p "
			+ "where upper(p.name) like concat('%', upper(:name), '%') "
		)
	Page<Building> findByFilters(String name, Pageable page);

	@Query("select count(*) from Building p "
			+ "where upper(p.name) like concat('%', upper(:name), '%') "
		)
	long count(String name);
	
	
	@Override
	default Page<Building> findByFilters(Filters f, Pageable page) {
		BuildingFilters filters = (BuildingFilters) f;
		
		return findByFilters(filters.getName(), page);
	}

	@Override
	default long count(Filters f) {
		BuildingFilters filters = (BuildingFilters) f;
		
		return count(filters.getName());
	}
	
	
}
