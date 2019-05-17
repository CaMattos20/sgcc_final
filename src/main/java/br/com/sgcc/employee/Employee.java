package br.com.sgcc.employee;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.sgcc.company.Company;
import br.com.sgcc.core.NormalizedEntity;
import br.com.sgcc.person.Person;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="TB_EMPLOYEES")
@Data
@EqualsAndHashCode(callSuper=false)
public class Employee extends NormalizedEntity {
	
	@ManyToOne
	@JoinColumn(name="PERSON_ID")
	private Person person;
	
	@ManyToOne
	@JoinColumn(name="COMPANY_ID")
	private Company company;
	
	@Column(name="VALID_TO")
	private LocalDateTime validTO;
	
	
	public Employee() {
		this.person = new Person();
		this.company = new Company();
	}
	
	
}
