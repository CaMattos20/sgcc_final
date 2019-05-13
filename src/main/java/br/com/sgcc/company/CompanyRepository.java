package br.com.sgcc.company;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import br.com.sgcc.DefaultRepository;
import br.com.sgcc.Filters;

public interface CompanyRepository extends DefaultRepository<Company> {

	@Query("select p from Company p "
			+ "where upper(p.name) like concat('%', upper(:name), '%') "
			+ "and upper(p.cnpj) like concat('%', upper(:cnpj), '%') ")
	Page<Company> findByFilters(String name, String cnpj, Pageable page);

	@Query("select count(*) from Company p "
			+ "where upper(p.name) like concat('%', upper(:name), '%') "
			+ "and upper(p.cnpj) like concat('%', upper(:cnpj), '%') "
		)
	long count(String name, String cnpj);
	
	
	@Override
	default Page<Company> findByFilters(Filters f, Pageable page) {
		CompanyFilters filters = (CompanyFilters) f;
		
		return findByFilters(filters.getName(), filters.getCnpj(), page);
	}

	@Override
	default long count(Filters f) {
		CompanyFilters filters = (CompanyFilters) f;
		
		return count(filters.getName(), filters.getCnpj());
	}
	
}
