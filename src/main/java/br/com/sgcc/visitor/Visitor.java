package br.com.sgcc.visitor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.sgcc.core.NormalizedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="TB_VISITORS")
@Data @EqualsAndHashCode(callSuper=false) @NoArgsConstructor
public class Visitor extends NormalizedEntity {
	
    @Column(name="NAME")
    private String name;
	
    @Column(name="EMAIL")
    private String email;
	
    @Column(name="PHONE_NUMBER")
    private String phoneNumber;
	
    @Column(name="DOCUMENT")
    private String document;
	
}
