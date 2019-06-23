package br.com.sgcc.visitor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import br.com.sgcc.core.DefaultRepository;
import br.com.sgcc.core.Filters;

public interface VisitorRepository extends DefaultRepository<Visitor> {

	@Query("select p from Visitor p "
			+ "where upper(p.name) like concat('%', upper(:name), '%') "
			+ "and upper(p.email) like concat('%', upper(:email), '%') "
			+ "and upper(p.phoneNumber) like concat('%', upper(:phoneNumber), '%') "
			+ "and upper(p.document) like concat('%', upper(:document), '%') "
		)
	Page<Visitor> findByFilters(String name, String email, String phoneNumber, String document, Pageable page);

	@Query("select count(*) from Visitor p "
			+ "where upper(p.name) like concat('%', upper(:name), '%') "
			+ "and upper(p.email) like concat('%', upper(:email), '%') "
			+ "and upper(p.phoneNumber) like concat('%', upper(:phoneNumber), '%') "
			+ "and upper(p.document) like concat('%', upper(:document), '%') "
		)
	long count(String name, String email, String phoneNumber, String document);
	
	
	@Override
	default Page<Visitor> findByFilters(Filters f, Pageable page) {
		VisitorFilters filters = (VisitorFilters) f;
		
		return findByFilters(filters.getName(), filters.getEmail(), filters.getPhoneNumber(), filters.getDocument(), page);
	}

	@Override
	default long count(Filters f) {
		VisitorFilters filters = (VisitorFilters) f;
		
		return count(filters.getName(), filters.getEmail(), filters.getPhoneNumber(), filters.getDocument());
	}
	
}
