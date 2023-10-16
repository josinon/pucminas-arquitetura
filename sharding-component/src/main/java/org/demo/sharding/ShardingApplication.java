package org.demo.sharding;

import org.demo.sharding.model.BillingRecord;
import org.demo.sharding.repository.BillingHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootApplication
public class ShardingApplication implements CommandLineRunner {

	@Autowired
	private BillingHistoryRepository billingHistoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(ShardingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {




		System.out.println("TESTE ....");

		for (long companyId = 0; companyId < 50; companyId++) {
			for (long userId = 0; userId < 50; userId++) {
				BillingRecord billingHistory = new BillingRecord();
				billingHistory.setCost(BigDecimal.valueOf(10.00));
				billingHistory.setAmount(BigDecimal.valueOf(10.00));
				billingHistory.setDetail(String.format("Detail - User %d - Company - %d", userId, companyId));
				billingHistory.setCompanyId(companyId);
				billingHistory.setStartDate(LocalDateTime.now());

				billingHistoryRepository.save(billingHistory);



			}
		}

//		List<BillingHistory> all = billingHistoryRepository.findAll();
//		System.out.println("records  ...." + all.size());
		System.out.println("TESTE .... FIM");
	}
}
