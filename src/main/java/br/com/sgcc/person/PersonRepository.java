package br.com.sgcc.person;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import br.com.sgcc.core.DefaultRepository;
import br.com.sgcc.core.Filters;

public interface PersonRepository extends DefaultRepository<Person> {

	@Query("select p from Person p "
			+ "where upper(p.name) like concat('%', upper(:name), '%') "
			+ "and upper(p.email) like concat('%', upper(:email), '%') "
			+ "and upper(p.phoneNumber) like concat('%', upper(:phoneNumber), '%') "
			+ "and upper(p.document) like concat('%', upper(:document), '%') "
		)
	Page<Person> findByFilters(String name, String email, String phoneNumber, String document, Pageable page);

	@Query("select count(*) from Person p "
			+ "where upper(p.name) like concat('%', upper(:name), '%') "
			+ "and upper(p.email) like concat('%', upper(:email), '%') "
			+ "and upper(p.phoneNumber) like concat('%', upper(:phoneNumber), '%') "
			+ "and upper(p.document) like concat('%', upper(:document), '%') "
		)
	long count(String name, String email, String phoneNumber, String document);
	
	
	@Override
	default Page<Person> findByFilters(Filters f, Pageable page) {
		PersonFilters filters = (PersonFilters) f;
		
		return findByFilters(filters.getName(), filters.getEmail(), filters.getPhoneNumber(), filters.getDocument(), page);
	}

	@Override
	default long count(Filters f) {
		PersonFilters filters = (PersonFilters) f;
		
		return count(filters.getName(), filters.getEmail(), filters.getPhoneNumber(), filters.getDocument());
	}
	
}
