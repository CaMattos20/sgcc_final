package br.com.sgcc.core;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public abstract class NormalizedEntity {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=IDENTITY)
	private Integer id;
	
	@Column(name="STATUS")
	protected String status;

	@Column(name="VALID_FROM")	
	protected LocalDateTime validFrom;


	public boolean isNew() {
		return getId() == null;
	}
	
	public void initialize() {
		this.status = "A";
		this.validFrom = LocalDateTime.now();
	}
	
}
