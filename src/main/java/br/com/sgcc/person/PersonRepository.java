package br.com.sgcc.person;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepository extends PagingAndSortingRepository<Person, Integer> {

	@Query("select p from Person p "
			+ "where upper(p.name) like concat('%', upper(:name), '%') "
			+ "and upper(p.email) like concat('%', upper(:email), '%') "
			+ "and upper(p.personType) like concat('%', upper(:type), '%') "
			+ "and upper(p.phoneNumber) like concat('%', upper(:phoneNumber), '%') "
			+ "and upper(p.document) like concat('%', upper(:document), '%') "
		)
	Page<Person> findByFilters(String name, String email, String type, String phoneNumber, String document, Pageable page);

	@Query("select count(*) from Person p "
			+ "where upper(p.name) like concat('%', upper(:name), '%') "
			+ "and upper(p.email) like concat('%', upper(:email), '%') "
			+ "and upper(p.personType) like concat('%', upper(:type), '%') "
			+ "and upper(p.phoneNumber) like concat('%', upper(:phoneNumber), '%') "
			+ "and upper(p.document) like concat('%', upper(:document), '%') "
		)
	long count(String name, String email, String type, String phoneNumber, String document);
	
}
