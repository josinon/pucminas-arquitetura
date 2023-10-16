package org.cloudcost.reports;

import org.cloudcost.reports.dto.CompanyCost;
import org.cloudcost.reports.dto.GeneralResume;
import org.cloudcost.reports.dto.ResumeCompany;
import org.cloudcost.reports.repository.BillingHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    @Autowired
    private BillingHistoryRepository billingHistoryRepository;


    @GetMapping
    public String index(){ return "OK"; }


    @GetMapping("costs/all")
    @Cacheable("costs-all")
    public GeneralResume allCosts(){
        List<CompanyCost> companyCosts = billingHistoryRepository.listCostsByCompany();
        GeneralResume generalResume = new GeneralResume();
        for (CompanyCost c: companyCosts) {
            generalResume.addResumeCompany(c);
        }
        return generalResume;
    }

    @GetMapping("costs/company/{id}")
    @Cacheable("costs-company")
    public ResumeCompany companyCost(@PathVariable Long id){
        CompanyCost companyCost = billingHistoryRepository.costsOfCompany(id);
        ResumeCompany resumeCompany = new ResumeCompany();
        resumeCompany.setCompanyName("Company"+id);
        resumeCompany.setTotalCost(companyCost.getCost());
        return resumeCompany;
    }


    @GetMapping("clear/cache")
    @CacheEvict("costs-all")
    public String clearCache(){
        return "CLEAR";
    }

}
