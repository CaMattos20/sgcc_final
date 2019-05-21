package br.com.sgcc.room.owner;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.sgcc.building.Building;
import br.com.sgcc.company.Company;
import br.com.sgcc.core.NormalizedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="TB_ROOM_OWNERS")
@Data @EqualsAndHashCode(callSuper=false) @NoArgsConstructor
public class RoomOwner extends NormalizedEntity {

	@ManyToOne
	@JoinColumn(name="COMPANY_ID")
	private Company company;
	
    @ManyToOne
    @JoinColumn(name="BUILDING_ID")
    private Building building;
    
    @Column(name="ROOM_NUMBER")
    private Integer roomNumber;
    
    @Column(name="VALID_TO")
    private LocalDateTime validTo;
    
}
