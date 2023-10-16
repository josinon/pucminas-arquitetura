package org.demo.sharding.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "billingrecord")
public class BillingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;


    private BigDecimal cost;

    private String detail;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String productFamily;

    private String productName;

    @Lob
    private String tags;

    private String usageAccount;

    private Long companyId;


}
