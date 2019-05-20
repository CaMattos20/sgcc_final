package br.com.sgcc.building;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.sgcc.core.NormalizedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="TB_BUILDINGS")
@Data @EqualsAndHashCode(callSuper=false) @NoArgsConstructor
public class Building extends NormalizedEntity {

    @Column(name="NAME")
    private String name;
    
}
