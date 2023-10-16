package org.cloudcost.reports.dto;


import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ResumeCompany implements Serializable {

    private String companyName;
    private BigDecimal totalCost;

}
