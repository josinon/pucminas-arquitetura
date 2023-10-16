package org.demo.sharding.repository;

import org.demo.sharding.model.BillingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingHistoryRepository extends JpaRepository<BillingRecord, Long> {
}
