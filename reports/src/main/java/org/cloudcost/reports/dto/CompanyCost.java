package org.cloudcost.reports.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class CompanyCost implements Serializable {

    private Long companyId;
    private BigDecimal cost;

    public CompanyCost(Long companyId, BigDecimal cost){
        this.companyId = companyId;
        this.cost = cost;
    }

}
