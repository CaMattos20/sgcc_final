package br.com.sgcc.company;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.sgcc.employee.Employee;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="TB_COMPANIES")
@Data
@NoArgsConstructor
@ToString
public class Company {

	@Id
	@Column(name="COMPANY_ID")
	@GeneratedValue(strategy=IDENTITY)
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;
	
	@Column(name="CNPJ")
	private String cnpj;
	
	@Column(name="VALID_FROM")
	private LocalDateTime validFrom;
	
	@OneToMany(mappedBy="company")
	@ToString.Exclude
	private List<Employee> employees;
	
}
