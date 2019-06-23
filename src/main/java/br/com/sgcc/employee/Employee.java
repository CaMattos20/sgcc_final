package br.com.sgcc.employee;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.sgcc.company.Company;
import br.com.sgcc.core.NormalizedEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="TB_EMPLOYEES")
@Data
@EqualsAndHashCode(callSuper=false)
public class Employee extends NormalizedEntity {
	
	
	
	@ManyToOne
	@JoinColumn(name="COMPANY_ID")
	private Company company;
	
	@Column(name="NAME")
    private String name;
	
    @Column(name="EMAIL")
    private String email;
	
    @Column(name="PHONE_NUMBER")
    private String phoneNumber;
	
    @Column(name="DOCUMENT")
    private String document;
	
	
	public Employee() {
		
		this.company = new Company();
	}
	
	
}
