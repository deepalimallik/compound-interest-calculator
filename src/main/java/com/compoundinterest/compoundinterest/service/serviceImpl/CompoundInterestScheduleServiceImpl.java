package com.compoundinterest.compoundinterest.service.serviceImpl;


import com.compoundinterest.compoundinterest.model.CompoundInterest;
import com.compoundinterest.compoundinterest.service.CompoundInterestService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Component
public class CompoundInterestScheduleServiceImpl {

    private final CompoundInterestService compoundInterestService;
    private final CompoundInterestCalculator compoundInterestCalculator;

    public CompoundInterestScheduleServiceImpl(CompoundInterestService compoundInterestService, CompoundInterestCalculator compoundInterestCalculator) {
        this.compoundInterestService = compoundInterestService;
        this.compoundInterestCalculator = compoundInterestCalculator;
    }

    @Scheduled(cron = "*/5 * * * * ?")
    public void scheduleCompoundInterest(){

        CompoundInterest compoundInterest1 = compoundInterestService.getByCname("default");
        CompoundInterest compoundInterest = compoundInterestCalculator.interestCalculator(compoundInterest1);


        compoundInterestService.update(compoundInterest);

    }
}
