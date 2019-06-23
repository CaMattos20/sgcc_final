package br.com.sgcc.visit;

import static java.time.format.DateTimeFormatter.ofPattern;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.sgcc.building.Building;
import br.com.sgcc.company.Company;
import br.com.sgcc.core.NormalizedEntity;
import br.com.sgcc.visitor.Visitor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="TB_VISITS")
@Data @EqualsAndHashCode(callSuper=false)
public class Visit extends NormalizedEntity {

	@ManyToOne
	@JoinColumn(name="VISITOR_ID")
	private Visitor visitor;
	
	@ManyToOne
	@JoinColumn(name="COMPANY_ID")
	private Company company;
	
    @ManyToOne
    @JoinColumn(name="BUILDING_ID")
    private Building building;
    
    @Column(name="ROOM_NUMBER")
    private Integer roomNumber;
    
    @Column(name="ENTRANCE_TIME")
    @DateTimeFormat(pattern="dd/MM/yyyy HH:mm")
    private LocalDateTime entranceTime;
    
    @Column(name="EXIT_TIME")
    @DateTimeFormat(pattern="dd/MM/yyyy HH:mm")
    private LocalDateTime exitTime;
    
    
    public Visit() {
    	if (entranceTime == null) {
    		entranceTime = LocalDateTime.now();
    	}
    }

    
    public String getFormattedEntranceTime() {
    	return (entranceTime == null ? "" : entranceTime.format(ofPattern("dd/MM/yyyy HH:mm")));
    }
    
    public String getFormattedExitTime() {
    	return (exitTime == null ? "" : exitTime.format(ofPattern("dd/MM/yyyy HH:mm")));
    }
    
}
