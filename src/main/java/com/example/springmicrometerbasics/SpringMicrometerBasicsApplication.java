package com.example.springmicrometerbasics;

import io.micrometer.core.instrument.Metrics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@SpringBootApplication
@RestController
@RequestMapping("/metrics")
@EnableScheduling
public class SpringMicrometerBasicsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMicrometerBasicsApplication.class, args);
    }



    private static final int PURCHASE_FREQUENCY_IN_MILLISECONDS = 10000;

    @Scheduled(fixedRate = PURCHASE_FREQUENCY_IN_MILLISECONDS)
    void performScheduledPurchases() {

        double purchaseAmount = getRandomPurchaseAmount();

        Metrics.counter("application.purchases.count").increment();
        Metrics.counter("application.purchases.dollarvalue").increment(purchaseAmount);
    }


    @RequestMapping("/count")
    public void count(){


        Metrics.counter("application.sample.counter").increment();
    }

    //Random Purchase Amount with an hourly pattern
    private double getRandomPurchaseAmount(){

        double waveValue = (Math.cos(((double) LocalTime.now().getMinute() )/ 60 * (2 * Math.PI)) + 1 ) / 2;
        double totalValue = waveValue * 50 + (Math.random() * 35);
        double roundedValue = Math.round(totalValue*100)/100;

        return roundedValue;

    }

}
