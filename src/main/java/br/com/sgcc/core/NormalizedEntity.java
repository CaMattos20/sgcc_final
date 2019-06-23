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


	public boolean isNew() {
		return getId() == null;
	}
	
	
	
}
