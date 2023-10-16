package org.cloudcost.reports.repository;


import org.cloudcost.reports.dto.CompanyCost;
import org.cloudcost.reports.dto.ResumeCompany;
import org.cloudcost.reports.model.BillingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BillingHistoryRepository extends JpaRepository<BillingRecord, Long> {


    @Query("select new org.cloudcost.reports.dto.CompanyCost(companyId, sum(cost)) from BillingRecord group group by companyId")
    public List<CompanyCost> listCostsByCompany();


    @Query("select new org.cloudcost.reports.dto.CompanyCost(companyId, sum(cost)) from BillingRecord where companyId= :id")
    public CompanyCost costsOfCompany(@Param("id") Long id);

}
