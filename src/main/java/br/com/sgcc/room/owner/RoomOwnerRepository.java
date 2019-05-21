package br.com.sgcc.room.owner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import br.com.sgcc.core.DefaultRepository;
import br.com.sgcc.core.Filters;

public interface RoomOwnerRepository extends DefaultRepository<RoomOwner> {

	@Query("select p from RoomOwner p "
			+ "where upper(p.company.name) like concat('%', upper(:company), '%') "
			+ " and upper(p.building.name) like concat('%', upper(:building), '%')"
			
		)
	Page<RoomOwner> findByFilters(String company, String building, Pageable page);

	@Query("select count(*) from RoomOwner p "
			+ "where upper(p.company.name) like concat('%', upper(:company), '%') "
			+ " and upper(p.building.name) like concat('%', upper(:building), '%')"
		)
	long count(String company, String building);
	
	
	@Override
	default Page<RoomOwner> findByFilters(Filters f, Pageable page) {
		RoomOwnerFilters filters = (RoomOwnerFilters) f;
		
		return findByFilters(filters.getCompany(), filters.getBuilding(), page);
	}

	@Override
	default long count(Filters f) {
		RoomOwnerFilters filters = (RoomOwnerFilters) f;
		
		return count(filters.getCompany(), filters.getBuilding());
	}
	
	
}
