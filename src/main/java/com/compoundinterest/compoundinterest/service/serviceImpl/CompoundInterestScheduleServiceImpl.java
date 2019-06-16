package com.compoundinterest.compoundinterest.service.serviceImpl;


import com.compoundinterest.compoundinterest.dto.CompoundInterestDTO;
import com.compoundinterest.compoundinterest.model.CompoundInterest;
import com.compoundinterest.compoundinterest.repository.CompoundInterestRepository;
import com.compoundinterest.compoundinterest.service.CompoundInterestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;


@Component
public class CompoundInterestScheduleServiceImpl {
    private final CompoundInterestService compoundInterestService;


    public CompoundInterestScheduleServiceImpl(CompoundInterestService compoundInterestService) {
        this.compoundInterestService = compoundInterestService;
    }

    private final Logger logger = LoggerFactory.getLogger(CompoundInterestScheduleServiceImpl.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(cron = "0 */1 * ? * *")
    public void scheduleCompoundInterest(){

        CompoundInterest compoundInterest1 = compoundInterestService.getByCname("default");
        logger.info("compoundInterest:",compoundInterest1.toString());
        CompoundInterest compoundInterest = new CompoundInterest();
        compoundInterest.setCname(compoundInterest1.getCname());
        double newPrinciple = compoundInterest1.getPrinciple() + compoundInterest1.getIncreasingAmount();
        compoundInterest.setPrinciple(newPrinciple);
        compoundInterest.setRate(compoundInterest1.getRate());
        compoundInterest.setYear(compoundInterest1.getYear());
        compoundInterest.setNumber(compoundInterest1.getNumber());
        //compoundInterest.setAmount(compoundInterest1.getAmount());
      //  compoundInterest.setInterest(compoundInterest1.getInterest());

        double futureValue = compoundInterest.getPrinciple()*Math.pow((1+(compoundInterest1.getRate()/compoundInterest1.getNumber())),compoundInterest1.getYear()*compoundInterest1.getNumber());

        compoundInterest.setAmount(futureValue);
        compoundInterest.setInterest(compoundInterest1.getAmount()-compoundInterest1.getPrinciple());

        compoundInterestService.update(compoundInterest);

    }
}
