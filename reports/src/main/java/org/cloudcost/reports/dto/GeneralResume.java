package org.cloudcost.reports.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class GeneralResume implements Serializable  {

    private List<ResumeCompany> companies = new ArrayList<>();
    private BigDecimal totalCost = BigDecimal.ZERO;

    public void addResumeCompany(CompanyCost c){
        ResumeCompany resumeCompany = new ResumeCompany();
        resumeCompany.setCompanyName("Company"+c.getCompanyId());
        resumeCompany.setTotalCost(c.getCost());
        this.getCompanies().add(resumeCompany);
        this.totalCost = this.totalCost.add(c.getCost());
    }

}
