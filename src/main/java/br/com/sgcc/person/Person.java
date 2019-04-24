package br.com.sgcc.person;

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
@Table(name="TB_PERSONS")
@Data 
@NoArgsConstructor
public class Person {
	
	@Id
	@Column(name="PERSON_ID")
	@GeneratedValue(strategy=IDENTITY)
	private Integer id;
	
    @Column(name="NAME")
    private String name;
	
    @Column(name="EMAIL")
    private String email;
	
    @Column(name="PHONE_NUMBER")
    private String phoneNumber;
	
    @Column(name="PERSON_TYPE")
    private String personType;
	
    @Column(name="DOCUMENT")
    private String document;
	
    @Column(name="STATUS")
    private String status;
	
    @Column(name="VALID_FROM")
    private LocalDateTime validFrom;
	
    @Column(name="VALID_TO")
    private LocalDateTime validTo;
    
}
