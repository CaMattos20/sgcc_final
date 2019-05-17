package br.com.sgcc.company;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.sgcc.core.NormalizedEntity;
import br.com.sgcc.employee.Employee;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="TB_COMPANIES")
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@ToString
public class Company extends NormalizedEntity {
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;
	
	@Column(name="CNPJ")
	private String cnpj;
	
	@OneToMany(mappedBy="company")
	@ToString.Exclude
	private List<Employee> employees;
	
}
