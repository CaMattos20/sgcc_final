package br.com.sgcc.employee;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.sgcc.company.Company;
import br.com.sgcc.person.Person;
import lombok.Data;

@Entity
@Table(name="TB_EMPLOYEES")
@Data 
public class Employee {

	@Id
	@Column(name="EMPLOYEE_ID")
	@GeneratedValue(strategy=IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="PERSON_ID")
	private Person person;
	
	@ManyToOne
	@JoinColumn(name="COMPANY_ID")
	private Company company;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="VALID_FROM")
	private LocalDateTime validFrom;
	
	@Column(name="VALID_TO")
	private LocalDateTime validTO;
	
	
	public Employee() {
		this.person = new Person();
		this.company = new Company();
	}
	
	
}
