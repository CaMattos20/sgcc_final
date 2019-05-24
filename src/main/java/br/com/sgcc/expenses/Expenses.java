package br.com.sgcc.expenses;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.sgcc.core.NormalizedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="TB_EXPENSES")
@Data @EqualsAndHashCode(callSuper=false) @NoArgsConstructor
public class Expenses extends NormalizedEntity {

    @Column(name="MONTH")
    private Integer month;

    @Column(name="YEAR")
    private Integer year;
    
    
    @Column(name="MATERIALS")
    private BigDecimal materials;

    @Column(name="WATER")
    private BigDecimal water;

    @Column(name="ELECTRICITY")
    private BigDecimal electricity;

    @Column(name="ELEVATORS")
    private BigDecimal elevators;

    @Column(name="ENVIRONMENT")
    private BigDecimal environment;

    @Column(name="CLEANING")
    private BigDecimal cleaning;

    @Column(name="FIRE")
    private BigDecimal fire;

    @Column(name="GARBAGE")
    private BigDecimal garbage;

    @Column(name="PARKING")
    private BigDecimal parking;

    @Column(name="MAIL")
    private BigDecimal mail;
    
}
