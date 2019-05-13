package br.com.sgcc.company;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="TB_COMPANIES")
@Data
@NoArgsConstructor
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
	
}
