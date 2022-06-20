package com.micropos.carts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.channel.DirectChannel;


@SpringBootApplication
@EnableEurekaClient
public class CartsApplication {
    private static final Logger log = LoggerFactory.getLogger(CartsApplication.class);
    public static void main(String args[]) {
        SpringApplication.run(CartsApplication.class, args);

    }

    @Bean
    public DirectChannel sampleChannel() {
        return new DirectChannel();
    }

//    @Bean
//    public Supplier<Loan> supplyLoan() {
//
//        Supplier<Loan> loanSupplier = () -> {
//            Loan loan = new Loan(UUID.randomUUID().toString(),
//                    names.get(new Random().nextInt(names.size())),
//                    amounts.get(new Random().nextInt(amounts.size())));
//            log.info("{} {} for ${} for {}", loan.getStatus(), loan.getUuid(), loan.getAmount(), loan.getName());
//            return loan;
//        };
//
//        return loanSupplier;
//    }


}
